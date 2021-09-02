package clone.shmehdi.jetinsta.ui.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import clone.shmehdi.jetinsta.R
import clone.shmehdi.jetinsta.ui.components.AdaptiveImage
import clone.shmehdi.jetinsta.ui.components.AdaptiveText
import clone.shmehdi.jetinsta.ui.components.Avatar
import clone.shmehdi.jetinsta.ui.components.CaptionText
import coil.compose.rememberImagePainter

@Composable
fun PostItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Avatar(id = R.drawable.temp)
                Spacer(modifier = Modifier.size(12.dp))
                AdaptiveText(text = "hackyrizz", fontWeight = FontWeight.Bold)
            }
            Icon(Icons.Default.MoreVert, contentDescription = null)

        }
        Box {
            Image(
                painter = rememberImagePainter("https://picsum.photos/200/200"),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(vertical = 2.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AdaptiveImage(
                    painter = painterResource(id = R.drawable.notification_outline),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(12.dp))
                AdaptiveImage(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                AdaptiveImage(
                    painter = painterResource(id = R.drawable.send),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp)
                )
            }
            AdaptiveImage(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = null,
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, bottom = 8.dp)
        ) {
            AdaptiveText(text = "65075 likes", fontWeight = FontWeight.Bold)
            Box(modifier = Modifier.size(8.dp))
            CaptionText(
                username = "hackyrizz",
                caption = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            )
        }

    }
}