package com.geektech.rickandmortyapp43.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmortyapp43.databinding.ItemLocationBinding
import com.geektech.rickandmortyapp43.models.Characters

class LocationAdapter(private val onItemClick: (model: Characters) -> Unit) :
    RecyclerView.Adapter<LocationAdapter.CountViewHolder>() {
    private lateinit var binding: ItemLocationBinding
    private var list = arrayListOf<Characters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountViewHolder {
        binding = ItemLocationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: ArrayList<Characters>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class CountViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characters: Characters) {
            binding.tvLive.text = characters.live
            binding.tvName.text = characters.name
            binding.root.setOnClickListener {
                onItemClick(characters)
            }
        }

    }
}