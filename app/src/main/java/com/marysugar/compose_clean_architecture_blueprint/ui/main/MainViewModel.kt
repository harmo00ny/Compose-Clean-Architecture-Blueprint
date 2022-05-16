package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.marysugar.compose_clean_architecture_blueprint.data.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
  private val jsonPlaceHolderService: JsonPlaceHolderService
) : ViewModel() {

  private val _post = MutableLiveData<Post>()
  val post: LiveData<Post> = _post

  private fun getPost() {
    jsonPlaceHolderService.getPosts().enqueue(object : Callback<Post> {
      override fun onResponse(call: Call<Post>, response: Response<Post>) {
        if (response.code() == 200) {
          _post.value = response.body()
        }
      }

      override fun onFailure(call: Call<Post>, t: Throwable?) {
        // Do something
      }
    })
  }

  init {
    getPost()
  }
}