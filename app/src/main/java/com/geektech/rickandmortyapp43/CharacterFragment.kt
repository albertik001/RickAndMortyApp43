package com.geektech.rickandmortyapp43

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmortyapp43.adapters.CharacterAdapter
import com.geektech.rickandmortyapp43.databinding.FragmentCharacterBinding
import com.geektech.rickandmortyapp43.models.Characters

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val adapter = CharacterAdapter(this::onItemClick)

    private var characters = arrayListOf<Characters>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(
            LayoutInflater.from(requireContext()),
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter.setList(characters)
        binding.recycleCharacter.adapter = adapter
    }

    private fun loadData() {
        characters = arrayListOf()
        characters.add(Characters("Rick Sanchez", "Alive", R.drawable.rick))
        characters.add(Characters("Morty Smith", "Alive", R.drawable.morty))
        characters.add(Characters("Albert Einstein", "Dead", R.drawable.rick))
        characters.add(Characters("Jerry Smith", "Alive", R.drawable.jerry))
        characters.add(Characters("Sashka Zver", "Alive", R.drawable.morty))
    }

    private fun onItemClick(model: Characters) {
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragment2ToScreenFragment(model))
    }
}
