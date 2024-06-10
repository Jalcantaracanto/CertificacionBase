package com.example.certificacion.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.certificacion.R
import com.example.certificacion.data.local.model.Generic
import com.example.certificacion.databinding.GenericItemBinding

class GenericAdapter : RecyclerView.Adapter<GenericAdapter.ViewHolder>() {

    var generics = mutableListOf<Generic>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    init {
        generics.add(Generic(id = 1, first_name = "Elemento 1", last_name = "Descripción 1"))
        generics.add(Generic(id = 2, first_name = "Elemento 2", last_name = "Descripción 2"))
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericAdapter.ViewHolder {
        val bindingItem =
            GenericItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: GenericAdapter.ViewHolder, position: Int) {
        val generic: Generic = generics[position]
        holder.bind(generic)
    }

    override fun getItemCount(): Int {
        return generics.size
    }

    inner class ViewHolder(var bindingItem: GenericItemBinding) :
        RecyclerView.ViewHolder(bindingItem.root) {

        fun bind(generic: Generic) {
            bindingItem.btnArrow.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                navController.navigate(R.id.detailFragment)
            }
        }
    }
}