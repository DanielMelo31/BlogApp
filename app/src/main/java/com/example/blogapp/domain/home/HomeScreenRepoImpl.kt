package com.example.blogapp.domain.home

import com.example.blogapp.core.Resource
import com.example.blogapp.data.Post
import com.example.blogapp.data.remote.home.HomeScreenDataSource

class HomeScreenRepoImpl(private val dataSource: HomeScreenDataSource):
    HomeScreenRepo {

    override suspend fun getLatestPost(): Resource<List<Post>> = dataSource.getLastPost()
}