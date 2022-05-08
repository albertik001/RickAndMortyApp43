package com.geektech.rickandmortyapp43

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geektech.rickandmortyapp43.databinding.FragmentScreenBinding
import com.geektech.rickandmortyapp43.models.Characters

class ScreenFragment : Fragment() {
    private lateinit var binding: FragmentScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentScreenBinding.inflate(
            LayoutInflater.from(requireContext()),
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        val characters: Characters = ScreenFragmentArgs.fromBundle(requireArguments()).model
        binding.tvLive3.text = characters.live
        binding.tvName3.text = characters.name
        if (characters.image != null) {
            binding.imageBig.setImageResource(characters.image)
        }
    }
}