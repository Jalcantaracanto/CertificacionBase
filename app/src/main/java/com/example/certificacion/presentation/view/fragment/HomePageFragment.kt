package com.example.certificacion.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.certificacion.R
import com.example.certificacion.databinding.FragmentHomePageBinding
import com.example.certificacion.presentation.adapter.GenericAdapter


class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Logica

        initAdapter()
    }

    private fun initAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerList.layoutManager = linearLayoutManager

        val movieAdapter = GenericAdapter()
        movieAdapter.generics
        binding.recyclerList.adapter = movieAdapter


    }

}