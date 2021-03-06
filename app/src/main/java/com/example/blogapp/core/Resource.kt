package com.example.blogapp.core

import java.lang.Exception

sealed class Resource<out T> {
    class Loading<out T>: Resource<T>()
    class Success<out T>(val data: T): Resource<T>()
    class Failure<out T>(val exception: Exception): Resource<T>()
}