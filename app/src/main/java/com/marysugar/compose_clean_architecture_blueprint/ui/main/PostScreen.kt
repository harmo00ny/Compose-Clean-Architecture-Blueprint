package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PostScreen(
  navController: NavController,
  id: String?
) {
  val mainViewModel: MainViewModel = hiltViewModel()
  val post = mainViewModel.post.observeAsState()
  id?.let { mainViewModel.loadPost(it) }

  Column {
    post.value?.let { post ->
      Text(post.title)
    }
  }

  BackHandler(enabled = true, onBack = {navController.popBackStack()})
}