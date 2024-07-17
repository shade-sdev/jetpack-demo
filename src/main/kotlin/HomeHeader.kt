import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ui.theme.customTypography
import ui.theme.font
import ui.theme.primaryLight
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Composable
@Preview
fun HomeHeader() {

    Column(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
            .background(color = primaryLight)
            .padding(all = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        RatesStatus()
    }

}

@Composable
fun RatesStatus() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row (horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(modifier = Modifier.size(50.dp),
                painter = painterResource("money.png"),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss")),
                    color = Color.White,
                    fontFamily = font,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    )
                Text(
                    text = "Balance",
                    color = Color.White,
                    style = customTypography.titleSmall
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(modifier = Modifier.size(24.dp),
                painter = painterResource("refresh.png"),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}