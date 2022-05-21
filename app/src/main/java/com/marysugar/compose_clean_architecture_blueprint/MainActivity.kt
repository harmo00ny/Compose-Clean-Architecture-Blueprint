package com.marysugar.compose_clean_architecture_blueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.marysugar.compose_clean_architecture_blueprint.ui.main.MainViewModel
import com.marysugar.compose_clean_architecture_blueprint.ui.main.PostScreen
import com.marysugar.compose_clean_architecture_blueprint.ui.main.PostsScreen
import com.marysugar.compose_clean_architecture_blueprint.ui.theme.ComposeCleanArchitectureBlueprintTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Timber.plant(Timber.DebugTree())

    setContent {
      ComposeCleanArchitectureBlueprintTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "postsScreen") {
          composable("postsScreen") {
            val viewModel: MainViewModel = hiltViewModel()
            PostsScreen(viewModel, navController = navController)
          }
          composable(
            route = "posts/{postId}",
            arguments = listOf(navArgument("postId") { type = NavType.StringType })
          ) { backStackEntry ->
            PostScreen(navController, backStackEntry.arguments?.getString("postId"))
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposeCleanArchitectureBlueprintTheme {
    Greeting("Android")
  }
}