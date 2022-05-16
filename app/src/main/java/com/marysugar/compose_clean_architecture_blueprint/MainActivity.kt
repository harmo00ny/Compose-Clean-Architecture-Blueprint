package com.marysugar.compose_clean_architecture_blueprint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.marysugar.compose_clean_architecture_blueprint.ui.main.MainViewModel
import com.marysugar.compose_clean_architecture_blueprint.ui.main.PostsScreen
import com.marysugar.compose_clean_architecture_blueprint.ui.theme.ComposeCleanArchitectureBlueprintTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Timber.plant(Timber.DebugTree())

    val mainViewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    mainViewModel.post.observe(this) {
      setContent {
        ComposeCleanArchitectureBlueprintTheme {
          PostsScreen(it)
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