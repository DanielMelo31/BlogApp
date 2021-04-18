package com.example.blogapp.data.remote.home

import android.util.Log
import com.example.blogapp.core.Resource
import com.example.blogapp.data.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {
    suspend fun getLastPost(): Resource<List<Post>>{
        val postList = mutableListOf<Post>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("Post").get().await()

        //Bring each post from firebase
        for (post in querySnapshot.documents){
            post.toObject(Post::class.java)?.let { firebasePost ->
                postList.add(firebasePost)
                Log.d("Success", "Data: ${post.data}")
            }
        }
        return Resource.Success(postList)
    }
}