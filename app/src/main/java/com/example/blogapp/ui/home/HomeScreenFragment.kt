package com.example.blogapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import com.example.blogapp.R
import com.example.blogapp.data.Post
import com.example.blogapp.databinding.FragmentHomeScreenBinding

import com.example.blogapp.ui.home.adapter.HomeScreenAdapter
import com.google.firebase.Timestamp

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeScreenBinding.bind(view)

        val postList = listOf(
                Post("https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/gallery/594a1ced5bafe85dfd3c9869/gato-romano_0.jpg",
                        "don_gato666",
                        Timestamp.now(),
                        "https://www.fundacion-affinity.org/sites/default/files/el-gato-necesita-tener-acceso-al-exterior.jpg"),
                Post("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT50irqaJbPAGB8CsLn930dlFOGQNR8-EPtjg&usqp=CAU",
                        "lucian_322",
                        Timestamp.now(),
                        "https://tucachorro.com.co/wp-content/uploads/2019/11/BERNES-DE-LA-MONTA%C3%91A.jpg"),
        Post("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuTW5uO-KEnfLdsYJtg2SSVRiiSwgw1vdvmA&usqp=CAU",
        "kiara231",
        Timestamp.now(),
        "https://blog.mascotaysalud.com/wp-content/uploads/2019/07/golden-retriever-mascota-y-salud.jpg"))

        binding.rvHome.adapter = HomeScreenAdapter(postList)
    }
}