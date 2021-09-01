package clone.shmehdi.jetinsta.vo

import clone.shmehdi.jetinsta.R
import clone.shmehdi.jetinsta.utils.then

sealed class NavigationItem(val route: String, var icon: Int, var selectedIcon: Int, var title: String) {
    object Home: NavigationItem("home", R.drawable.home_outline, R.drawable.home_filled, "Home")
    object Search: NavigationItem("search", R.drawable.search_outline, R.drawable.search_filled,"Search")
    object Reel: NavigationItem("reel", R.drawable.reel, R.drawable.reel,"Reel")
    object Notification: NavigationItem("notification", R.drawable.notification_outline, R.drawable.notification_filled,"Notification")
    object Profile: NavigationItem("profile", R.drawable.temp, R.drawable.temp,"Profile")

    fun getCurrentIcon(isSelected: Boolean): Int {
        return isSelected then selectedIcon ?: icon
    }

    companion object {

        val menu get() = listOf(
            Home, Search, Reel, Notification, Profile
        )
    }
}
