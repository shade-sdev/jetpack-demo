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
import ui.theme.DarkColors
import ui.theme.LightColors
import ui.theme.customTypography

@Composable
@Preview
fun App() {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                5.dp,
                Alignment.CenterVertically
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Username") },
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconToggleButton(checked = passwordVisible, onCheckedChange = { passwordVisible = it }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.VisibilityOff
                            else Icons.Default.Visibility, contentDescription = ""
                        )
                    }
                },
            )
            Button(onClick = {}) {
                Text(text = "Login")
            }
        }
    }
}

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
                SecVault()
            }
        }
    }
}