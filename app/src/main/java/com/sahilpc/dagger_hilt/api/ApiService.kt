package com.sahilpc.dagger_hilt.api

import com.sahilpc.dagger_hilt.models.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts():List<Post>
}