package clone.shmehdi.jetinsta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import clone.shmehdi.jetinsta.data.model.Story
import clone.shmehdi.jetinsta.data.model.fakeStories
import clone.shmehdi.jetinsta.ui.components.*
import clone.shmehdi.jetinsta.ui.theme.Black
import clone.shmehdi.jetinsta.ui.theme.Blue
import clone.shmehdi.jetinsta.ui.theme.JetInstaTheme
import clone.shmehdi.jetinsta.ui.theme.White
import clone.shmehdi.jetinsta.utils.adaptiveColor
import clone.shmehdi.jetinsta.utils.themeColor
import clone.shmehdi.jetinsta.utils.then
import clone.shmehdi.jetinsta.vo.NavigationItem
import coil.compose.rememberImagePainter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetInstaTheme() {
                // A surface container using the 'background' color from the theme
                Surface(color = if (isSystemInDarkTheme()) Black else White) {
                    Scaffold(
                        topBar = {
                            InstaLogoHeader()
                        },
                        bottomBar = {
                            AppBottomNavigation()
                        }
                    ) {
                        PostComponent {
                            Column {
                                StoryComponent()
                                Divider()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostComponent(top: @Composable () -> Unit) {
    LazyColumn(content = {
        item {
            top()
            PostItem()
            PostItem()
            PostItem()
            PostItem()
        }
    })
}

@Composable
fun AppBottomNavigation() {

    var selectedRoute = remember {
        "home"
    }

    BottomNavigation(backgroundColor = isSystemInDarkTheme().themeColor) {
        NavigationItem.menu.forEach {
            BottomNavigationItem(
                selected = selectedRoute == it.route,
                onClick = {
                    selectedRoute = it.route
                },
                icon = {
                    (it == NavigationItem.Profile) then Avatar(id = it.icon, size = 22)
                        ?: Icon(
                            painterResource(id = it.getCurrentIcon(selectedRoute == it.route)),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp),
                            tint = isSystemInDarkTheme().adaptiveColor
                        )
                },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray

            )
        }
    }
}

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
fun StoryComponent() {
    LazyRow(content = {
        item {
            AddStoryView()
        }
        fakeStories.forEach {
            item {
                StoryView(story = it)
            }
        }
    }, modifier = Modifier.padding(horizontal = 12.dp))
}

@Composable
fun InstaLogoHeader() {
    Box(modifier = Modifier.padding(horizontal = 12.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            AdaptiveImage(
                painter = painterResource(id = R.drawable.instagram_logo),
                contentDescription = "",
                modifier = Modifier.height(38.dp),
            )

            Row {
                AdaptiveImage(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 12.dp)
                )

                AdaptiveImage(
                    painter = painterResource(id = R.drawable.messenger),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetInstaTheme(darkTheme = true) {
        PostItem()
    }
}