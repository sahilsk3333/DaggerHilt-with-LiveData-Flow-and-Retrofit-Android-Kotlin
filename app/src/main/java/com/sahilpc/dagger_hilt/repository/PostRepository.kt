package com.sahilpc.dagger_hilt.repository

import com.sahilpc.dagger_hilt.api.ApiService
import com.sahilpc.dagger_hilt.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts():Flow<List<Post>> = flow {
        val response = apiService.getPosts()
        emit(response)
    }.flowOn(Dispatchers.IO)

}