package com.example.blogapp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogapp.core.BaseViewHolder
import com.example.blogapp.data.Post
import com.example.blogapp.databinding.PostItemBinding

class HomeScreenAdapter(private val postList: List<Post>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HomeScreenViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is HomeScreenViewHolder -> holder.bind(postList[position])
        }
    }

    override fun getItemCount(): Int = postList.size

    private inner class HomeScreenViewHolder(
            val binding: PostItemBinding,
            val context: Context
    ): BaseViewHolder<Post>(binding.root){
        override fun bind(item: Post) {
            Glide.with(context).load(item.profile_picture).centerCrop().into(binding.circleProfileImage)
            Glide.with(context).load(item.post_image).centerCrop().into(binding.postImage)
            binding.tvUserName.text = item.profile_name
            binding.tvPostTimeStamp.text = "2 hours ago"
        }
    }
}