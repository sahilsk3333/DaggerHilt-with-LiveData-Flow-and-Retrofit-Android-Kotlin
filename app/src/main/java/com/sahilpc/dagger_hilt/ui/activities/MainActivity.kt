package com.sahilpc.dagger_hilt.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahilpc.dagger_hilt.R
import com.sahilpc.dagger_hilt.models.Post
import com.sahilpc.dagger_hilt.ui.adapters.PostsAdapter
import com.sahilpc.dagger_hilt.ui.viewmodels.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postsAdapter: PostsAdapter
    private val postViewModel:PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUi()
        postViewModel.getPost()
        postViewModel.postLiveData.observe(this, Observer {response->
            postsAdapter.setData(response as ArrayList<Post>)
        })
    }

    private fun setUi() {
        recyclerView=findViewById(R.id.recyclerView)
        postsAdapter= PostsAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postsAdapter
        }
    }
}