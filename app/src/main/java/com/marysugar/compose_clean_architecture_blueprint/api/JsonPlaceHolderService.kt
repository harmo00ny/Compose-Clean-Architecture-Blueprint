package com.marysugar.compose_clean_architecture_blueprint.api

import com.marysugar.compose_clean_architecture_blueprint.data.Post
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface JsonPlaceHolderService {
  @GET("posts")
  suspend fun getPosts(): ApiResponse<List<Post>>
}