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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    .fillMaxWidth()
                    .background(PasswordColors.primary)
            )
            {
                SideBar()
            }

            Column(
                modifier = Modifier.weight(4.5f)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(PasswordColors.secondary)
            )
            {

            }

            Column(
                modifier = Modifier.weight(4.5f)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(PasswordColors.tertiary)
            )
            {

            }

        }
    }
}

@Composable
fun SideBar() {
    Column(
        modifier = Modifier.padding(PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp))
    )
    {

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1.6f)
        )
        {
            Header()
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(7f)
        )
        {

            SideBarMenu()
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(0.8f)
        )
        {
            Footer()
        }
    }
}


@Composable
fun SideBarMenu() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalSpacer()
        Spacer(Modifier.height(15.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically),
        )

        {
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "VAULT",
                color = Color.White,
                fontFamily = Font.RussoOne,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            )
            {
                SideBarMenuSection()
            }

            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "CATEGORIES",
                color = Color.White,
                fontFamily = Font.RussoOne,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            )
            {
                SideBarMenuSection()

            }
        }
    }
}

@Composable
fun SideBarMenuSection() {
    Column {
        Spacer(Modifier.height(2.dp))
        SideBarMenuItem("Passwords",
                        Icons.Default.Security,
                        onClick = {
                            println("Hello")
                        })

        SideBarMenuItem("Notes",
                        Icons.Default.NoteAlt,
                        onClick = {
                            println("Hello")
                        })
    }
}

@Composable
fun SideBarMenuItem(
        text: String,
        icon: ImageVector,
        onClick: () -> Unit = {},
        backgroundColor: Color = Color.Transparent,
        hoverColor: Color = PasswordColors.onSurface,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick, indication = null, interactionSource = interactionSource)
            .hoverable(interactionSource)
            .height(34.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(if (isHovered) hoverColor else backgroundColor, shape = RoundedCornerShape(CornerSize(10.dp)))

    ) {
        Spacer(modifier = Modifier.width(2.dp))
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = if (isHovered) Color.White else PasswordColors.outline
        )
        Text(
            text = text,
            color = if (isHovered) Color.White else PasswordColors.outline,
            fontSize = 12.sp,
            fontFamily = Font.RussoOne,
            fontWeight = FontWeight.Normal,
        )
    }
}

@Composable
fun Header() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Icon(
                    painter = painterResource("icon.png"),
                    contentDescription = "Setting button",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = "SecVault",
                    color = Color.White,
                    fontFamily = Font.RussoOne,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }

        Row(
            modifier = Modifier.weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User Icon",
                    modifier = Modifier.size(28.dp).align(Alignment.CenterVertically),
                    tint = Color.White
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy((-12).dp, Alignment.CenterVertically),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Shade",
                        color = Color.White,
                        fontFamily = Font.RussoOne,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                    )
                    Text(
                        text = "View Profile",
                        color = Color.White,
                        fontFamily = Font.RobotoThin,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }
    }

}

@Composable
fun Footer() {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .hoverable(interactionSource)
            .clickable(onClick = { println("Settings") }, indication = null, interactionSource = interactionSource)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "Setting button",
                modifier = Modifier.size(18.dp),
                tint = if (isHovered) Color.Gray else Color.White,
            )
            Text(
                modifier = Modifier,
                text = "Settings",
                color = if (isHovered) Color.Gray else Color.White,
                fontFamily = Font.RussoOne,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun HorizontalSpacer() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    )
    {
        HorizontalDivider(
            color = Color.Gray,
            thickness = 0.2.dp,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
    }
}