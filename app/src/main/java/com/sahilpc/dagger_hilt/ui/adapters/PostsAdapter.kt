package com.sahilpc.dagger_hilt.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahilpc.dagger_hilt.R
import com.sahilpc.dagger_hilt.models.Post

class PostsAdapter(private val context: Context,private var postList:ArrayList<Post> ): RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.body.text = post.body
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val body:TextView = itemView.findViewById(R.id.body)
    }

    fun setData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}