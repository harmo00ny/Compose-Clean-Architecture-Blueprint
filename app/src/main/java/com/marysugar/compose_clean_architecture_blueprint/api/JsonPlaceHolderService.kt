package com.marysugar.compose_clean_architecture_blueprint.api

import com.marysugar.compose_clean_architecture_blueprint.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderService {
  @GET("posts/1")
  fun getPosts(): Call<Post>
}