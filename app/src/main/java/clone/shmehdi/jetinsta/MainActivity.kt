package clone.shmehdi.jetinsta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import clone.shmehdi.jetinsta.ui.components.*
import clone.shmehdi.jetinsta.ui.components.items.PostItem
import clone.shmehdi.jetinsta.ui.screens.*
import clone.shmehdi.jetinsta.ui.theme.Black
import clone.shmehdi.jetinsta.ui.theme.JetInstaTheme
import clone.shmehdi.jetinsta.ui.theme.White
import clone.shmehdi.jetinsta.vo.Routes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           InstaApp()
        }
    }
}

@Composable fun InstaApp() {
    val navController = rememberNavController()

    JetInstaTheme() {
        // A surface container using the 'background' color from the theme
        Surface(color = if (isSystemInDarkTheme()) Black else White) {
            Scaffold (
                bottomBar = {
                    AppBottomNavigation(navController)
                }
            ) {
                MainNavigation(navController = navController)
            }

        }
    }
}

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.HOME) {

        composable(route = Routes.HOME) {
            HomeScreen()
        }

        composable(route = Routes.SEARCH) {
            SearchScreen()
        }

        composable(route = Routes.REEL) {
            ReelScreen()
        }

        composable(route = Routes.NOTIFICATION) {
            NotificationScreen()
        }

        composable(route = Routes.PROFILE) {
            ProfileScreen()
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