import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AmpStories
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.DarkColors
import ui.theme.LightColors
import ui.theme.font

@Composable
@Preview
fun RoboForm() {

    Surface(modifier = Modifier.fillMaxSize()) {
        Row {

            Column(
                modifier = Modifier.weight(0.7f, fill = true)
                    .fillMaxHeight()
                    .background(DarkColors.surface)
            )
            {
                Column(modifier = Modifier.padding(20.dp)) {
                    RoboFarmLogo()
                    ActionButton()
                    MainMenu()
                }
            }

            Column(
                modifier = Modifier.weight(2.3f, fill = true)
                    .fillMaxHeight()
                    .background(DarkColors.surfaceContainer)
            )
            {

            }

        }
    }

}

@Composable
fun RoboFarmLogo() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            5.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AmpStories,
            contentDescription = "",
            modifier = Modifier.size(30.dp),
            tint = DarkColors.tertiary
        )
        Text(
            text = "Password",
            fontSize = 16.sp,
            fontFamily = font,
            color = Color.White
        )
    }
}

@Composable
fun ActionButton() {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = LightColors.surfaceTint,
            contentColor = Color.White
        ),
        modifier = Modifier.padding(PaddingValues(vertical = 20.dp))
            .size(width = Dp.Unspecified, height = 36.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
            Text(text = "Add New",
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = font)
        }
    }
}

@Composable
fun MainMenu() {
    RoundedCard(modifier = Modifier.size(Dp.Infinity, 305.dp)) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
            modifier = Modifier.padding(15.dp)
        ) {
            MenuItem("All",
                Icons.Default.AccountBox,
                hoverColor = DarkColors.surface,
                onClick = {
                    println("Hello")
                })
            MenuItem("Persons",
                Icons.Default.AccountBox,
                hoverColor = DarkColors.surface,
                onClick = {
                    println("Hello")
                })
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit = {},
    backgroundColor: Color = Color.Transparent,
    hoverColor: Color = Color.Gray,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row (
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick, indication = null, interactionSource = interactionSource)
            .hoverable(interactionSource)
            .height(35.dp)
            .fillMaxWidth()
            .background(if (isHovered) hoverColor else backgroundColor, shape = RoundedCornerShape(CornerSize(10.dp)))

    ) {
        Spacer(modifier = Modifier.width(2.dp))
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(18.dp)
                .align(Alignment.CenterVertically),
            tint = DarkColors.secondary,
        )
        Text(text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = font,
            modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun RoundedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        shape = RoundedCornerShape(CornerSize(8.dp)),
        color = LightColors.inverseSurface,
        shadowElevation = 4.dp,
        modifier = modifier
    ) {
        content()
    }
}

