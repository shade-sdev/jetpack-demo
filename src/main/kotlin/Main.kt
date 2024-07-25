import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent.getKoin
import ui.theme.DarkColors
import ui.theme.LightColors
import ui.theme.customTypography


fun main() = application {
    startKoin {
        modules(databaseModule, repositoryModule)
    }

    getKoin().get<AppInitializer>().initialize()

    val colors = if (!isSystemInDarkTheme()) LightColors else DarkColors

    Window(
        onCloseRequest = ::exitApplication,
        resizable = true,
        state = WindowState(size = DpSize(1150.dp, 700.dp), position = WindowPosition.Aligned(Alignment.Center)),
        undecorated = true,
        transparent = true,
        icon = painterResource("assets/icon.png")
    ) {
        WindowDraggableArea(modifier = Modifier.clip(RoundedCornerShape(10.dp))) {
            MaterialTheme(
                colorScheme = colors,
                typography = customTypography,
            )
            {
                Navigator(LoginScreen()) { navigator: Navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}

val databaseModule = module {
    val config = HikariConfig().apply {
        jdbcUrl = "jdbc:sqlite:data.db"
        driverClassName = "org.sqlite.JDBC"
        maximumPoolSize = 6
        isReadOnly = false
        transactionIsolation = "TRANSACTION_SERIALIZABLE"
    }

    val dataSource = HikariDataSource(config)
    val flyway = Flyway.configure().dataSource(dataSource).load()

    single {
        flyway.migrate()
        Database.connect(dataSource)
    }

    single { AppInitializer() }
}

val repositoryModule = module {
    single { StarwarsRepository() }
}