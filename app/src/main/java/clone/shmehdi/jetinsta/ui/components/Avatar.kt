package clone.shmehdi.jetinsta.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Avatar(id: Int, size: Int = 32) {
    Image(
        painter = painterResource(id),
        contentDescription = null,
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)                  // clip to the circle shape
    )
}