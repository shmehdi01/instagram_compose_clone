package clone.shmehdi.jetinsta.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import clone.shmehdi.jetinsta.utils.adaptiveColor
import clone.shmehdi.jetinsta.utils.themeColor
import clone.shmehdi.jetinsta.utils.then
import clone.shmehdi.jetinsta.vo.NavigationItem
import clone.shmehdi.jetinsta.vo.Routes

@Composable
fun AppBottomNavigation(navController: NavHostController) {

    val selectedRoute = remember {
        mutableStateOf(Routes.HOME)
    }

    BottomNavigation(backgroundColor = isSystemInDarkTheme().themeColor) {
        NavigationItem.menu.forEach {
            BottomNavigationItem(
                selected = selectedRoute.value == it.route,
                onClick = {
                    selectedRoute.value = it.route
                    navController.navigate(it.route)
                },
                icon = {
                    (it == NavigationItem.Profile) then Avatar(id = it.icon, size = 22)
                        ?: Icon(
                            painterResource(id = it.getCurrentIcon(selectedRoute.value == it.route)),
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