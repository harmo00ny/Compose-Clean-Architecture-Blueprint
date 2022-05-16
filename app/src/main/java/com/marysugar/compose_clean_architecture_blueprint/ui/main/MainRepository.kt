package com.marysugar.compose_clean_architecture_blueprint.ui.main

import androidx.annotation.WorkerThread
import com.marysugar.compose_clean_architecture_blueprint.api.JsonPlaceHolderService
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(
  private val jsonPlaceHolderService: JsonPlaceHolderService
) {
  @WorkerThread
  fun loadPosts() = flow {
    jsonPlaceHolderService.getPosts()
      .suspendOnSuccess {
        emit(data)
      }
  }
}