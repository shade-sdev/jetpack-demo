package ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

object Font {
    val RussoOne = FontFamily(Font("fonts/RussoOne.ttf"))
    val Aldrich = FontFamily(Font("fonts/Aldrich-Regular.ttf"))
    val RobotoThin = FontFamily(Font("fonts/Roboto-Light.ttf"))
    val RobotoRegular = FontFamily(Font("fonts/Roboto-Regular.ttf"))

}

val font = FontFamily(
    Font("fonts/Aldrich-Regular.ttf", FontWeight.Normal),
)

val customTypography = Typography(
    titleSmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)