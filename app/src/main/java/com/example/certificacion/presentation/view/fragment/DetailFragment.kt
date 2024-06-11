package com.example.certificacion.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.certificacion.R
import com.example.certificacion.data.network.api.ApiService
import com.example.certificacion.data.network.repository.SimpsonRepositoryImplement
import com.example.certificacion.data.network.response.SimpsonsResponseItem
import com.example.certificacion.data.network.retrofit.RetrofitHelper
import com.example.certificacion.databinding.FragmentDetailBinding
import com.example.certificacion.databinding.FragmentHomePageBinding
import com.example.certificacion.domain.SimpsonsUseCase
import com.example.certificacion.presentation.viewmodel.SimpsonsViewModel
import com.example.certificacion.presentation.viewmodel.SimpsonsViewModelFactory
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var simpsonsViewModel: SimpsonsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var isVisible = false

        simpsonsViewModel = ViewModelProvider(requireActivity())[SimpsonsViewModel::class.java]

        simpsonsViewModel.selectedSimpson.observe(viewLifecycleOwner){ simpson ->
            binding.txtName.text = simpson.character
            binding.txtDetail.text = simpson.quote
            Picasso.get().load(simpson.image).into(binding.imageAvatar)

            binding.btnPrimary.setOnClickListener {
                if (isVisible) {
                    binding.btnSendMail.visibility = View.GONE
                    isVisible = false
                } else {
                    binding.btnSendMail.visibility = View.VISIBLE
                    isVisible = true
                }
            }

            binding.btnSendMail.setOnClickListener {
                sendEmailMovie(simpson)
            }

        }
    }

    private fun sendEmailMovie(simpson: SimpsonsResponseItem) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("javier.alcantara.canto@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Movie Recommendation")

        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Has seleccionado a: ${simpson.character} "
        )

        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(Intent.createChooser(intent, "Send email"))
        } else {
            Toast.makeText(requireContext(), "El mensaje no puede ser enviado", Toast.LENGTH_SHORT)
                .show()
        }
    }

}