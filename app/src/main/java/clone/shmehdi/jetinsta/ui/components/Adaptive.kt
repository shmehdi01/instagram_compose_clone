package clone.shmehdi.jetinsta.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import clone.shmehdi.jetinsta.ui.theme.Black
import clone.shmehdi.jetinsta.ui.theme.White
import clone.shmehdi.jetinsta.utils.adaptiveColor
import clone.shmehdi.jetinsta.utils.then

@Composable
fun AdaptiveImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        colorFilter = ColorFilter.tint(color = if (isSystemInDarkTheme()) Color.White else Color.Black)
    )

}


@OptIn(ExperimentalUnitApi::class)
@Composable
fun AdaptiveText(
    text: String,
    color: Color = isSystemInDarkTheme() then White ?: Black,
    fontSize: Float = 14f,
    fontWeight: FontWeight? = null,
    maxLines: Int = Int.MAX_VALUE ,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text, style = TextStyle(
            color = color,
            fontSize = TextUnit(fontSize, TextUnitType.Sp),
            fontWeight = fontWeight,
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}


@Composable
fun AdaptiveIcon(imageVector: ImageVector, contentDescription: String?) {
    Icon(imageVector, contentDescription = contentDescription, tint = isSystemInDarkTheme().adaptiveColor)
}
