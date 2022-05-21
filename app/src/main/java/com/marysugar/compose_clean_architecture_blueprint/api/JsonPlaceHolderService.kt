package com.marysugar.compose_clean_architecture_blueprint.api

import com.marysugar.compose_clean_architecture_blueprint.data.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderService {
  @GET("posts/{id}")
  fun getPost(@Path("id") id:String): Call<Post>

  @GET("posts")
  fun getPosts(): Call<List<Post>>
}