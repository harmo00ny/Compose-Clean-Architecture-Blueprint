package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marysugar.compose_clean_architecture_blueprint.data.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
  private val mainRepository: MainRepository
) : ViewModel() {

  private val _post = MutableLiveData<Post>()
  val post: LiveData<Post> = _post

  private fun loadPost() {
    viewModelScope.launch {
      _post.value = mainRepository.getPost()
    }
  }

  init {
    loadPost()
  }
}