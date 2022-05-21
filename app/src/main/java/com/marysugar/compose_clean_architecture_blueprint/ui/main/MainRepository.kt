package com.marysugar.compose_clean_architecture_blueprint.ui.main

import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.marysugar.compose_clean_architecture_blueprint.data.Post
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainRepository @Inject constructor(
  private val jsonPlaceHolderService: JsonPlaceHolderService
) {
  suspend fun getPost(id: String): Post {
    return suspendCoroutine {
      val task = jsonPlaceHolderService.getPost(id)
      task.enqueue(object : retrofit2.Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
          if (response.isSuccessful) {
            it.resume(response.body()!!)
            Timber.d(it.toString())
          } else {
            Timber.e("Can't attribute data")
          }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
          t.stackTrace
        }
      })
    }
  }
  suspend fun getPosts(): List<Post> {
    return suspendCoroutine {
      val task = jsonPlaceHolderService.getPosts()
      task.enqueue(object : retrofit2.Callback<List<Post>> {
        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
          if (response.isSuccessful) {
            it.resume(response.body().orEmpty())
          } else {
            Timber.e("Can't attribute data")
          }
        }

        override fun onFailure(call: Call<List<Post>>, t: Throwable) {
          t.stackTrace
        }
      })
    }
  }
}