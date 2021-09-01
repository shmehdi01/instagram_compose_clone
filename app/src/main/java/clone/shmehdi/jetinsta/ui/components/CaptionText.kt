package clone.shmehdi.jetinsta.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import clone.shmehdi.jetinsta.utils.adaptiveColor

@Composable
fun CaptionText(username: String, caption: String) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,)) {
                append("$username ")
            }


            append(caption)
        },
        style = TextStyle(color = isSystemInDarkTheme().adaptiveColor)
    )

}