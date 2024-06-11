package com.example.certificacion.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.certificacion.R
import com.example.certificacion.data.network.api.ApiService
import com.example.certificacion.data.network.repository.SimpsonRepositoryImplement
import com.example.certificacion.data.network.retrofit.RetrofitHelper
import com.example.certificacion.databinding.FragmentHomePageBinding
import com.example.certificacion.domain.SimpsonsUseCase
import com.example.certificacion.presentation.adapter.GenericAdapter
import com.example.certificacion.presentation.viewmodel.SimpsonsViewModel
import com.example.certificacion.presentation.viewmodel.SimpsonsViewModelFactory


class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding
    private lateinit var simpsonsViewModel: SimpsonsViewModel
    private lateinit var genericAdapter: GenericAdapter

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

        val apiService = RetrofitHelper.getRetrofit().create(ApiService::class.java)
        val repository = SimpsonRepositoryImplement(apiService)
        val useCase = SimpsonsUseCase(repository)
        val viewModelFactory = SimpsonsViewModelFactory(useCase)
        simpsonsViewModel = ViewModelProvider(requireActivity(), viewModelFactory)[SimpsonsViewModel::class.java]


        //Logica

        initAdapter()

        simpsonsViewModel.simpsonsList.observe(viewLifecycleOwner) { simpsons ->
            simpsons?.let {
                genericAdapter.simpsons = it
            }
        }

    }

    private fun initAdapter() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerList.layoutManager = linearLayoutManager
        genericAdapter = GenericAdapter { simpson ->
            simpsonsViewModel.selectSimpson(simpson)
            findNavController().navigate(R.id.action_homePageFragment_to_detailFragment)
        }
        binding.recyclerList.adapter = genericAdapter
    }

}