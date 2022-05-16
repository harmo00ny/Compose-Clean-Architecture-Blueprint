package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.marysugar.compose_clean_architecture_blueprint.data.Post

@Composable
fun PostsScreen(
  post: Post
) {
  SimpleText(post.toString())
}
@Composable
fun SimpleText(title: String) {
  Text(title)
}