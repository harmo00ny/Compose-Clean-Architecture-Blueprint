package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PostsScreen(
  mainViewModel: MainViewModel,
  navController: NavController
) {
  val posts = mainViewModel.posts.observeAsState()

  LazyColumn {
    posts.value?.forEach { post ->
      item {
        Card(modifier = Modifier
          .padding(16.dp)
          .wrapContentSize()
          .clickable {
            navController.navigate("posts/" + post.id.toString())
          }
        ) {
          Text(post.title)
        }
      }
    }
  }
}