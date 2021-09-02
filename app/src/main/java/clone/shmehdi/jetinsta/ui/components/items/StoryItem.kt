package clone.shmehdi.jetinsta.ui.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import clone.shmehdi.jetinsta.R
import clone.shmehdi.jetinsta.data.model.Story
import clone.shmehdi.jetinsta.ui.components.AdaptiveText
import clone.shmehdi.jetinsta.ui.theme.Blue
import clone.shmehdi.jetinsta.ui.theme.White
import clone.shmehdi.jetinsta.utils.then
import coil.compose.rememberImagePainter

@Composable
fun StoryView(modifier: Modifier = Modifier, story: Story) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(vertical = 12.dp)
    ) {
        Box(
            Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(
                    story.isSeen then 1.0.dp ?: 1.5.dp, Brush.sweepGradient(
                        colors = story.isSeen then listOf(
                            Color(0xFF838282),
                            Color(0xFF838282),
                        ) ?: listOf(
                            Color(0xFFFFDC80),
                            Color(0xFFF56040),
                            Color(0xFFF77737),
                            Color(0xFFF56040),
                            Color(0xFFFFDC80)
                        ),
                    ), CircleShape
                )
        ) {
            Image(
                painter = rememberImagePainter("https://picsum.photos/200/300"),
                contentDescription = null,
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(64.dp)
                    .padding(4.dp)
                    .clip(CircleShape)                  // clip to the circle shape
            )
        }

        AdaptiveText(text = story.name, fontSize = 11f)
    }

}

@Composable
fun AddStoryView() {

    Box() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 12.dp)
        ) {

            Box(
                Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .size(64.dp)
                    .clip(CircleShape)                       // clip to the circle shape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.temp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(64.dp)
                        .padding(4.dp)
                        .clip(CircleShape)                  // clip to the circle shape
                )
            }


            AdaptiveText(text = "Your Story", fontSize = 11f)
        }

        Box(
            Modifier.offset(y = 60.dp, x = 52.dp)
        ) {
            Box(
                Modifier
                    .size(15.dp)
                    .clip(CircleShape)
                    .background(Blue),
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "",
                    //modifier = Modifier.size(15.dp),
                    tint = White
                )
            }
        }
    }
}