package movieapp.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import movieapp.resource.LocalImageResource
import movieapp.screen.favorite.presentation.FavoriteScreen
import movieapp.screen.home.presentation.HomeScreen
import movieapp.screen.profile.presentation.ProfileScreen

enum class TabModel {
    HOME, FAVORITE, PROFILE
}

class BottomNavigator {
    var currentTab by mutableStateOf(TabModel.HOME)
}

val LocalBottomNavigator =
    compositionLocalOf<BottomNavigator> { error("Bottom Navigator not provided") }

@Composable
fun RowScope.BottomTabItem(tab: TabModel, onTabSelected: (TabModel) -> Unit) {
    val tabNavigator = LocalBottomNavigator.current
    val isSelected = tab == tabNavigator.currentTab
    val imageResources = LocalImageResource.current

    BottomNavigationItem(
        selected = isSelected,
        onClick = {
            onTabSelected(tab)
        },
        icon = {
            val iconPainter = when (tab) {
                TabModel.HOME -> imageResources.ArrowBack()
                TabModel.FAVORITE -> imageResources.ArrowBack()
                TabModel.PROFILE -> imageResources.ArrowBack()
            }

            Image(
                painter = iconPainter,
                contentDescription = null,
                modifier = Modifier
                    .size(if (tab == TabModel.FAVORITE) 28.dp else 24.dp),
                colorFilter = ColorFilter.tint(if (isSelected) Color.Black else Color.Gray)
            )
        },
        label = {}
    )
}


@Composable
fun BottomNavScreen(navigator: Navigator) {
    val tabNavigator = LocalBottomNavigator.current
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                TabModel.entries.forEach { tab ->
                    BottomTabItem(tab) {
                        tabNavigator.currentTab = it
                    }
                }
            }
        }
    ) {
        when (tabNavigator.currentTab) {
            TabModel.HOME -> {
                HomeScreen(navigator)
            }

            TabModel.FAVORITE -> {
                FavoriteScreen(navigator)
            }

            TabModel.PROFILE -> {
                ProfileScreen(navigator)
            }
        }
    }
}