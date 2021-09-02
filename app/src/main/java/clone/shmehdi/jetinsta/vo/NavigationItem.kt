package clone.shmehdi.jetinsta.vo

import clone.shmehdi.jetinsta.R
import clone.shmehdi.jetinsta.utils.then

sealed class NavigationItem(val route: String, var icon: Int, var selectedIcon: Int, var title: String) {
    object Home: NavigationItem(Routes.HOME, R.drawable.home_outline, R.drawable.home_filled, "Home")
    object Search: NavigationItem(Routes.SEARCH, R.drawable.search_outline, R.drawable.search_filled,"Search")
    object Reel: NavigationItem(Routes.REEL, R.drawable.reel, R.drawable.reel,"Reel")
    object Notification: NavigationItem(Routes.NOTIFICATION, R.drawable.notification_outline, R.drawable.notification_filled,"Notification")
    object Profile: NavigationItem(Routes.PROFILE, R.drawable.temp, R.drawable.temp,"Profile")

    fun getCurrentIcon(isSelected: Boolean): Int {
        return isSelected then selectedIcon ?: icon
    }

    companion object {

        val menu get() = listOf(
            Home, Search, Reel, Notification, Profile
        )
    }
}
