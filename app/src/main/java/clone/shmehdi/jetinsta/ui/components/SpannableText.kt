package shmehdi.jet.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.core.text.buildSpannedString


@Composable
fun SpannableText(
    text: String,
    spanText: String,
    modifier: Modifier = Modifier,
    spanStyle: SpanStyle = SpanStyle(color = Color.Blue),
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = mapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
) {

    val annotatedString =  buildSpannable(text, spanText,spanStyle, false)

    Text(
        text = annotatedString,
        modifier,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        maxLines,
        inlineContent,
        onTextLayout,
        style
    )

}

@Composable
fun SpannableText(
    text: String,
    spanText: String,
    modifier: Modifier = Modifier,
    spanStyle: SpanStyle = SpanStyle(color = Color.Blue),
    style: TextStyle = LocalTextStyle.current,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    onClick: (String) -> Unit,
) {

    val annotatedString = buildSpannable(text, spanText,spanStyle, true)

    ClickableText(
        text = annotatedString,
        modifier,
        style,
        softWrap,
        overflow,
        maxLines,
        onTextLayout,
        onClick = { offset ->
            spanText.split(" ").forEach { tag ->
                annotatedString.getStringAnnotations(tag, offset, offset).firstOrNull()?.let {
                    onClick.invoke(it.item)
                }
            }
        }
    )
}

private fun buildSpannable(
    text: String,
    spanText: String,
    spanStyle: SpanStyle,
    isClickable: Boolean
) = buildAnnotatedString {
    text.split(" ").forEach {
        if (spanText.contains(it)) {
            if (isClickable) pushStringAnnotation(it, it)
            withStyle(style = spanStyle) {
                append("$it ")
            }
            if (isClickable) pop()
        } else {
            append("$it ")
        }
    }
}

@Composable
fun SpannableText() {
   val annotatedString = buildAnnotatedString {
        append("I have read")
        withStyle(style = SpanStyle(Color.Blue)) {
            append(" Terms and Condition")
        }
    }

    Text(text = annotatedString)
}