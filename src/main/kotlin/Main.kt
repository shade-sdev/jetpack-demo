import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
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
        state = WindowState(size = DpSize(1150.dp, 700.dp)),
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
                Navigator(SecVault()) { navigator: Navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}