package com.example.certificacion.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.certificacion.R
import com.example.certificacion.data.local.model.Generic
import com.example.certificacion.data.network.response.SimpsonsResponse
import com.example.certificacion.data.network.response.SimpsonsResponseItem
import com.example.certificacion.databinding.GenericItemBinding
import com.squareup.picasso.Picasso

class GenericAdapter(private val onItemClicked: (SimpsonsResponseItem) -> Unit) :
    RecyclerView.Adapter<GenericAdapter.ViewHolder>() {

    var simpsons = mutableListOf<SimpsonsResponseItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericAdapter.ViewHolder {
        val bindingItem =
            GenericItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: GenericAdapter.ViewHolder, position: Int) {
        val simpson: SimpsonsResponseItem = simpsons[position]
        holder.bind(simpson)
    }

    override fun getItemCount(): Int {
        return simpsons.size
    }

    inner class ViewHolder(var bindingItem: GenericItemBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        fun bind(simpsons: SimpsonsResponseItem) {

            bindingItem.txtName.text = simpsons.character
            bindingItem.txtDate.text = simpsons.characterDirection
            Picasso.get()
                .load(simpsons.image)
                //.resize(60,60)
                //.centerCrop()
                .into(bindingItem.imageAvatar)

            bindingItem.btnArrow.setOnClickListener {
                onItemClicked(simpsons)
            }
        }
    }
}