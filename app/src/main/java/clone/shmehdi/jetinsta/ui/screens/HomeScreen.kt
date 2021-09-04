package clone.shmehdi.jetinsta.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import clone.shmehdi.jetinsta.MainNavigation
import clone.shmehdi.jetinsta.data.model.fakeStories
import clone.shmehdi.jetinsta.ui.components.AppBottomNavigation
import clone.shmehdi.jetinsta.ui.components.InstaLogoHeader
import clone.shmehdi.jetinsta.ui.components.items.AddStoryView
import clone.shmehdi.jetinsta.ui.components.items.PostItem
import clone.shmehdi.jetinsta.ui.components.items.StoryView

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            InstaLogoHeader()
        },
    ) {
        PostComponent {
            Column {
                StoryComponent()
                Divider()
            }
        }
    }
}

@Composable
private fun PostComponent(top: @Composable () -> Unit) {
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
private fun StoryComponent() {
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