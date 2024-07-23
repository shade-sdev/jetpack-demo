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
import ui.theme.DarkColors
import ui.theme.LightColors
import ui.theme.customTypography


fun main() = application {

    val colors = if (!isSystemInDarkTheme()) LightColors else DarkColors

    Window(
        onCloseRequest = ::exitApplication,
        resizable = true,
        state = WindowState(size = DpSize(1150.dp, 700.dp), position = WindowPosition.Aligned(Alignment.Center)),
        undecorated = true,
        transparent = true,
        icon = painterResource("icon.png")
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