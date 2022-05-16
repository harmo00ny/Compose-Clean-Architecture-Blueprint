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
  mainRepository: MainRepository
) : ViewModel() {

  private val _postList = MutableLiveData<List<Post>>()
  val postList: LiveData<List<Post>> = _postList

  init {
    viewModelScope.launch {
      mainRepository.loadPosts().collect {
        _postList.value = it
      }
    }
  }
}