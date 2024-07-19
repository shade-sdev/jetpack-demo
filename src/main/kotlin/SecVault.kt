import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.DarkColors
import ui.theme.Font
import ui.theme.PasswordColors

@Composable
@Preview
fun SecVault() {
    Surface(
        modifier = Modifier.fillMaxSize()
    )
    {
        Row {

            Column(
                modifier = Modifier.weight(3f)
                    .fillMaxHeight()
                    .background(PasswordColors.primary)
            )
            {
                SideBar()
            }

            Column(
                modifier = Modifier.weight(4.5f)
                    .fillMaxHeight()
                    .background(PasswordColors.secondary)
            )
            {

            }

            Column(
                modifier = Modifier.weight(4.5f)
                    .fillMaxHeight()
                    .background(PasswordColors.tertiary)
            )
            {

            }

        }
    }
}

@Composable
fun SideBar() {
    Column {

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1.8f)
                .background(DarkColors.primary)
        )
        {

        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(7f)
                .background(DarkColors.tertiary)
        )
        {

        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(0.8f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Footer()
        }
    }
}

@Composable
fun Footer() {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(PaddingValues(start = 15.dp))
            .hoverable(interactionSource)
            .clickable(onClick = { println("Settings") }, indication = null, interactionSource = interactionSource)
    )
    {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Setting button",
            modifier = Modifier.size(18.dp).align(Alignment.CenterVertically),
            tint = if (isHovered) Color.Gray else Color.White,
        )
        Text(
            text = "Settings",
            color = if (isHovered) Color.Gray else Color.White,
            fontFamily = Font.RussoOne,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
    }
}