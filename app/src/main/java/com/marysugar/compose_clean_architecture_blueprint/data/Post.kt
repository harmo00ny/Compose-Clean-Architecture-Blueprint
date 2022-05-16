package com.marysugar.compose_clean_architecture_blueprint.data

data class Post(
  val body: String,
  val id: Int,
  val title: String,
  val userId: Int
)