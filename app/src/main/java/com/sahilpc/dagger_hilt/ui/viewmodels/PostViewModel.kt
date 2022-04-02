package com.sahilpc.dagger_hilt.ui.viewmodels
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahilpc.dagger_hilt.models.Post
import com.sahilpc.dagger_hilt.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository):ViewModel() {
    private val _postLiveData:MutableLiveData<List<Post>> = MutableLiveData()
    val postLiveData get() = _postLiveData

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPosts().catch { e->
                Log.d("main", "getPost: ${e.message}")
            }.collect{response->
                _postLiveData.value = response
            }
        }
    }
}