package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PostsScreen() {
  val viewModel: MainViewModel = viewModel()
  val posts = viewModel.posts.observeAsState()

  LazyColumn {
    posts.value?.forEach { post ->
      item {
        Text(post.title)
      }
    }
  }
}