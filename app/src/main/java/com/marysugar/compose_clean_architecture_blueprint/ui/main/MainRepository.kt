package com.marysugar.compose_clean_architecture_blueprint.ui.main

import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.marysugar.compose_clean_architecture_blueprint.data.Post
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainRepository @Inject constructor(
  private val jsonPlaceHolderService: JsonPlaceHolderService
) {
  suspend fun getPost(): Post {
    return suspendCoroutine {
      val task = jsonPlaceHolderService.getPost()
      task.enqueue(object : retrofit2.Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
          if (response.code() == 200) {
            it.resume(response.body()!!)
          }
        }

        override fun onFailure(call: Call<Post>, t: Throwable?) {
          // Do something
        }
      })
    }
  }
}