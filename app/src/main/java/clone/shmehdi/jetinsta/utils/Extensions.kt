package clone.shmehdi.jetinsta.utils

import clone.shmehdi.jetinsta.ui.theme.Black
import clone.shmehdi.jetinsta.ui.theme.White

infix fun <T> Boolean.then(b: T): T? = if (this) b else null

val Boolean.adaptiveColor get() = this then White ?: Black

val Boolean.themeColor get() = this then Black ?: White