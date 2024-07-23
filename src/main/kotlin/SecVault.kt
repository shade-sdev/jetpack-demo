import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import ui.theme.Font
import ui.theme.PasswordColors
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SecVault : Screen {

    @Composable
    override fun Content() {
        SecVaultContent()
    }

}

@Composable
@Preview
fun SecVaultContent() {
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
                PasswordLayout()
            }

            Column(
                modifier = Modifier.weight(4.5f)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(PasswordColors.tertiary)
            )
            {
                PasswordInfo()
            }

        }
    }
}

@Composable
fun PasswordInfo() {
    Column(
        modifier = Modifier
            .padding(PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp))
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {

        Row(
            modifier = Modifier.weight(1.5f)
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            PasswordInfoHeader()
        }

        Row(
            modifier = Modifier.weight(5f)
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            PasswordForm()
        }

        Row(
            modifier = Modifier.weight(6f)
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            PasswordMisc()
        }
    }
}

@Composable
fun PasswordMisc() {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

        Row(modifier = Modifier.weight(2f).fillMaxHeight().fillMaxWidth()) {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)) {

                Row() {
                    Text(
                        text = "Category", fontSize = 12.sp,
                        fontFamily = Font.RobotoRegular,
                        color = PasswordColors.outline
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(5) { index ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .background(Color(0xFF2B2B2B), shape = RoundedCornerShape(2.dp))
                                    .size(width = 56.dp, height = 28.dp)
                            ) {
                                Text(
                                    text = "Item $index",
                                    fontSize = 12.sp,
                                    fontFamily = Font.RobotoRegular,
                                    color = Color(0xFFcd9b5b),
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }

        Row(modifier = Modifier.weight(4f),
            horizontalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically)
        {

            Column() {
                PasswordMiscProgressIndicator()
            }

            Column() {
                Row() {
                    Text(
                        text = "Password Score: 82%",
                        fontSize = 14.sp,
                        fontFamily = Font.RussoOne,
                        color = Color.White,
                    )
                }

                Row() {
                    Column {
                        Text(
                            text = "Password Strength:",
                            fontSize = 12.sp,
                            fontFamily = Font.RobotoRegular,
                            color = Color.Gray,
                        )
                    }

                    Column {
                        Text(
                            text = "Good",
                            fontSize = 12.sp,
                            fontFamily = Font.RussoOne,
                            color = Color(0xFF9AE6b4),
                        )
                    }
                }
            }

        }

        Row(modifier = Modifier.weight(3f)) {
            Column() {

                Row() {
                    Column(verticalArrangement = Arrangement.spacedBy((-4).dp, alignment = Alignment.CenterVertically)) {

                        Row() {
                            Text(
                                text = "Last Modified",
                                fontSize = 10.sp,
                                fontFamily = Font.RussoOne,
                                color = Color(0xFF6C6C6C),
                            )
                        }

                        Row() {
                            Text(
                                text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                                fontSize = 12.sp,
                                fontFamily = Font.RussoOne,
                                color = Color.Gray,
                            )
                        }
                    }
                }

                Row() {
                    Column(verticalArrangement = Arrangement.spacedBy((-4).dp, alignment = Alignment.CenterVertically)) {

                        Row() {
                            Text(
                                text = "Created",
                                fontSize = 10.sp,
                                fontFamily = Font.RussoOne,
                                color = Color(0xFF6C6C6C),
                            )
                        }

                        Row() {
                            Text(
                                text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                                fontSize = 12.sp,
                                fontFamily = Font.RussoOne,
                                color = Color.Gray,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PasswordMiscProgressIndicator() {
    var progress by remember { mutableStateOf(0.75f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(120.dp)
    ) {
        CircularProgressIndicator(
            color = Color(0xFFE25C63),
            progress = { animatedProgress },
            trackColor = Color(0xFF1C1520),
            strokeWidth = 12.dp,
            strokeCap = StrokeCap.Round,
            modifier = Modifier.size(120.dp)
                .scale(scaleX = -1f, scaleY = 1f)
        )
        Text(
            text = "82%",
            color = Color.White,
            fontFamily = Font.RussoOne,
            fontSize = 22.sp
        )
    }
}

@Composable
fun PasswordForm() {
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {

        Row(modifier = Modifier.weight(1f)) {
            PasswordFormTitle()
        }

        Row(modifier = Modifier.weight(9f)) {
            var userName by remember { mutableStateOf("") }

            Column() {
                Row(modifier = Modifier.weight(1f)) {
                    UnderLineTextFiled(
                        field = userName,
                        onFieldChange = { userName = it },
                        label = "Username",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Row(modifier = Modifier.weight(1f)) {
                    UnderLineTextFiled(
                        field = userName,
                        onFieldChange = { userName = it },
                        label = "Password",
                        modifier = Modifier.fillMaxWidth(),
                        isPassword = true
                    )
                }

                Row(modifier = Modifier.weight(1f)) {
                    UnderLineTextFiled(
                        field = userName,
                        onFieldChange = { userName = it },
                        label = "Email",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Row(modifier = Modifier.weight(1f)) {
                    UnderLineTextFiled(
                        field = userName,
                        onFieldChange = { userName = it },
                        label = "Website",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }

    }
}

@Composable
fun PasswordFormTitle() {
    Column() {
        Row() {
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Details",
                color = Color(0xFFFF6363),
                fontFamily = Font.RussoOne,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )
        }
        Row() {
            Column(modifier = Modifier.weight(0.3f)) {
                HorizontalSpacer(thickness = 1.dp, width = 1f, color = Color(0xFFFF6363))
            }

            Column(modifier = Modifier.weight(0.7f)) {
                HorizontalSpacer(thickness = 1.dp, width = 1f, color = Color(0xFF333333))
            }
        }
    }
}

@Composable
fun PasswordInfoHeader() {

    Row(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    )
    {
        Column(
            modifier = Modifier.weight(7f).fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        )
        {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Column() {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "User Icon",
                        modifier = Modifier.size(56.dp),
                        tint = Color.White
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy((-6).dp, Alignment.CenterVertically)) {

                    Row() {
                        Text(
                            text = "Spotify",
                            fontSize = 20.sp,
                            fontFamily = Font.RussoOne,
                            color = Color.White
                        )
                    }

                    Row() {
                        Text(
                            text = "Shade@Shade.ga",
                            fontSize = 14.sp,
                            fontFamily = Font.Aldrich,
                            color = PasswordColors.outline
                        )
                    }

                }

            }
        }

        Column(
            modifier = Modifier.weight(3f)
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(PaddingValues(top = 4.dp)),
            horizontalAlignment = Alignment.End
        )
        {
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Column() {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "User Icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color.White
                    )
                }

                Column() {
                    val interactionSource = remember { MutableInteractionSource() }
                    val isHovered by interactionSource.collectIsHoveredAsState()
                    val navigator = LocalNavigator.current

                    OutlinedButton(
                        onClick = { navigator?.push(LoginScreen()) },
                        modifier = Modifier.size(height = 28.dp, width = 62.dp)
                            .hoverable(interactionSource),
                        shape = RoundedCornerShape(size = 4.dp),
                        contentPadding = PaddingValues(4.dp),
                        border = BorderStroke(2.dp, color = Color.White),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = if (isHovered) Color.White else Color.Transparent,
                        )

                    )
                    {
                        Text(
                            text = "Edit",
                            fontSize = 12.sp,
                            fontFamily = Font.RussoOne,
                            color = if (isHovered) PasswordColors.tertiary else Color.White
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun PasswordLayout() {
    Column(
        modifier = Modifier.padding(PaddingValues(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 20.dp))
    )
    {

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1.6f)
        )
        {
            PasswordFilterHeader()
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(8.4f)
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            )
            {
                items(24) { index ->
                    PasswordItem()
                }
            }

        }
    }
}

@Composable
fun PasswordItem() {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        modifier = Modifier.height(60.dp).fillMaxWidth()
            .background(if (isHovered) PasswordColors.tertiary else Color.Transparent, shape = RoundedCornerShape(6.dp))
            .padding(PaddingValues(start = 5.dp, end = 5.dp))
            .clickable(onClick = {}, indication = null, interactionSource = interactionSource)
            .hoverable(interactionSource),
        verticalAlignment = Alignment.CenterVertically
    )
    {

        Column(modifier = Modifier.weight(1f)) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "User Icon",
                modifier = Modifier.size(38.dp),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(8.5f).fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy((-8).dp, Alignment.CenterVertically)
        )
        {

            Row {
                Text(
                    text = "Spotify",
                    fontSize = 16.sp,
                    fontFamily = Font.RussoOne,
                    color = Color.White
                )
            }

            Row {
                Text(
                    text = "shade@shade.ga",
                    fontSize = 12.sp,
                    fontFamily = Font.RobotoThin,
                    color = PasswordColors.outline
                )
            }

        }

        Column(
            modifier = Modifier.weight(0.5f).fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "User Icon",
                modifier = Modifier.size(38.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
fun PasswordFilterHeader() {
    val options = listOf("Name", "Favourite", "Created")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(modifier = Modifier.weight(8.5f).fillMaxHeight().fillMaxWidth()) {
                RoundedFilledTextField(
                    placeholder = "Search Passwords",
                    modifier = Modifier.height(36.dp).fillMaxWidth()
                )
            }

            Column(
                modifier = Modifier.weight(1.5f).fillMaxHeight().fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                FilledIconButton(
                    shape = IconButtonDefaults.filledShape,
                    onClick = {},
                    enabled = true,
                    modifier = Modifier.height(36.dp).width(36.dp),
                    colors = IconButtonColors(
                        containerColor = Color(0xFFFB8C00),
                        contentColor = Color.White,
                        disabledContentColor = Color(0xFFFB8C00),
                        disabledContainerColor = Color(0xFFFB8C00)
                    )
                )
                {
                    Icon(Icons.Outlined.Add, contentDescription = "Localized description")

                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Column(
                modifier = Modifier.weight(6f)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            )
            {
                Text(
                    modifier = Modifier.align(Alignment.Start),
                    text = "All Passwords",
                    color = Color.White,
                    fontFamily = Font.RussoOne,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            }

            Column(
                modifier = Modifier.weight(5f)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
            )
            {
                Row(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = "Sort By",
                            color = Color.White,
                            fontFamily = Font.RobotoThin,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        )
                    }
                    Spacer(Modifier.width(10.dp))
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    )
                    {
                        Row(
                            modifier = Modifier
                                .clickable(
                                    onClick = { expanded = !expanded },
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End,
                        )
                        {
                            Text(selectedOption, fontFamily = Font.RussoOne, fontSize = 10.sp, color = Color.White)
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown Menu",
                                tint = Color.White,
                                modifier = Modifier.padding(PaddingValues(top = 4.dp))
                            )
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier.background(PasswordColors.primary)
                            ) {
                                options.forEach { selectionOption ->
                                    DropdownMenuItem(onClick = {
                                        selectedOption = selectionOption
                                        expanded = false
                                    }) {
                                        Text(
                                            text = selectionOption,
                                            fontFamily = Font.RussoOne,
                                            fontSize = 10.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }

                    }
                }
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
fun HorizontalSpacer(
        thickness: Dp = 0.2.dp,
        color: Color = Color.Gray,
        width: Float = 0.8f,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    )
    {
        HorizontalDivider(
            color = color,
            thickness = thickness,
            modifier = Modifier.fillMaxWidth(width)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnderLineTextFiled(
        modifier: Modifier = Modifier,
        label: String,
        field: String,
        onFieldChange: (String) -> Unit,
        isPassword: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var passwordVisible by remember { mutableStateOf(false) }

    BasicTextField(
        value = field,
        onValueChange = onFieldChange,
        interactionSource = interactionSource,
        modifier = modifier,
        textStyle = TextStyle(
            fontFamily = Font.RussoOne,
            color = Color.White,
            textAlign = TextAlign.Start,
            fontSize = 12.sp
        ),
        singleLine = true,
        cursorBrush = SolidColor(Color.White),
        visualTransformation = if (!isPassword || passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            interactionSource = interactionSource,
            innerTextField = innerTextField,
            enabled = true,
            value = field,
            singleLine = true,
            visualTransformation = if (!isPassword || passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = {
                Text(
                    label,
                    fontFamily = Font.RussoOne,
                    textAlign = TextAlign.Start,
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            },
            trailingIcon = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        if (isPassword) {
                            IconToggleButton(checked = passwordVisible, onCheckedChange = { passwordVisible = it }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.VisibilityOff
                                    else Icons.Default.Visibility,
                                    contentDescription = "",
                                    modifier = Modifier.size(width = 15.dp, height = 15.dp),
                                    tint = Color.Gray
                                )
                            }
                        }
                    }
                    Column {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = Modifier.size(width = 15.dp, height = 15.dp)
                        )
                    }
                    if (isPassword) {
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            },
            contentPadding = TextFieldDefaults.contentPaddingWithLabel(0.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF333333),
                unfocusedIndicatorColor = Color(0xFF333333),
                disabledTextColor = Color.LightGray,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedFilledTextField(
        modifier: Modifier = Modifier,
        placeholder: String = "",
) {
    var user by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = user,
        onValueChange = { user = it },
        interactionSource = interactionSource,
        modifier = modifier,
        textStyle = TextStyle(
            fontFamily = Font.RussoOne,
            color = PasswordColors.outlineVariant,
            textAlign = TextAlign.Start,
            fontSize = 13.sp
        ),
        singleLine = true
    ) { innerTextField ->

        TextFieldDefaults.DecorationBox(
            innerTextField = innerTextField,
            placeholder = {
                Text(
                    placeholder,
                    fontSize = 13.sp,
                    fontFamily = Font.RussoOne,
                    modifier = Modifier.padding(PaddingValues(bottom = 3.dp))
                )
            },
            value = user,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                    tint = PasswordColors.outlineVariant,
                    modifier = Modifier.width(20.dp).height(20.dp)

                )
            },
            enabled = true,
            interactionSource = interactionSource,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledTextColor = Color.LightGray,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedTextColor = PasswordColors.outlineVariant,
                unfocusedTextColor = PasswordColors.outlineVariant,
                focusedPlaceholderColor = PasswordColors.outlineVariant,
                unfocusedPlaceholderColor = PasswordColors.outlineVariant
            ),
            shape = RoundedCornerShape(20.dp),
            contentPadding = PaddingValues(0.dp)
        )
    }
}