package ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

object Font {
    val RussoOne = FontFamily(Font("RussoOne.ttf"))
    val Aldrich = FontFamily(Font("Aldrich-Regular.ttf"))
}

val font = FontFamily(
    Font("Aldrich-Regular.ttf", FontWeight.Normal),
)

val customTypography = Typography(
    titleSmall = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)