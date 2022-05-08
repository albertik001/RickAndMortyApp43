package com.geektech.rickandmortyapp43.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmortyapp43.databinding.ItemCharacterBinding
import com.geektech.rickandmortyapp43.models.Characters

class CharacterAdapter(private val onItemClick: (model: Characters) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.CountViewHolder>() {
    private lateinit var binding: ItemCharacterBinding
    private var characters = arrayListOf<Characters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountViewHolder {
        binding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return CountViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun setList(list: ArrayList<Characters>) {
        this.characters = list
        notifyDataSetChanged()
    }

    inner class CountViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Characters) {
            character.image?.let { binding.ivImage.setImageResource(it) }
            binding.tvLive.text = character.live
            binding.tvName.text = character.name
            binding.root.setOnClickListener {
                onItemClick(character)
            }
        }

    }
}