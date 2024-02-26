package movieapp.application

import LocalViewModelHost
import ViewModelHost
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import movieapp.resource.ImageResourcesProvider
import movieapp.resource.LocalImageResource
import movieapp.screen.home.data.repository.HomeRepository
import movieapp.screen.home.data.repository.LocalHomeRepository
import movieapp.screen.main.BottomNavScreen
import movieapp.screen.main.BottomNavigator
import movieapp.screen.main.LocalBottomNavigator
import movieapp.utils.RouterConstant.ROUTE_HOME

@Composable
fun App() {
    val viewModelHost = remember { ViewModelHost() }
    val appConfigProvider = remember { AppConfigProvider() }
    val imageResourcesProvider = remember { ImageResourcesProvider() }
    val bottomNavigator = remember { BottomNavigator() }

    //provides repo
    val movieRepository = remember { HomeRepository(appConfigProvider) }

    CompositionLocalProvider(
        LocalViewModelHost provides viewModelHost,
        LocalAppConfig provides appConfigProvider,
        LocalImageResource provides imageResourcesProvider,
        LocalBottomNavigator provides bottomNavigator,
        LocalHomeRepository provides movieRepository,
    ) {
        MaterialTheme {
            PreComposeApp {
                val navigator = rememberNavigator()
                NavHost(
                    navigator = navigator,
                    navTransition = NavTransition(),
                    initialRoute = ROUTE_HOME
                ) {
                    scene(
                        route = ROUTE_HOME
                    ) {
                        BottomNavScreen(navigator)
                    }
                }
            }
        }
    }
}