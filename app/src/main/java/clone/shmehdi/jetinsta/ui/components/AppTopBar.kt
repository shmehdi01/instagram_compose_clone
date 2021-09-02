package clone.shmehdi.jetinsta.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import clone.shmehdi.jetinsta.R

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