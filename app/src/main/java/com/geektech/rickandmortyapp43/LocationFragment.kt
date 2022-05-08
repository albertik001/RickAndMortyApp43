package com.geektech.rickandmortyapp43

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.rickandmortyapp43.adapters.LocationAdapter
import com.geektech.rickandmortyapp43.databinding.FragmentLocationBinding
import com.geektech.rickandmortyapp43.models.Characters

class LocationFragment : Fragment() {
    private lateinit var binding: FragmentLocationBinding
    private var adapter: LocationAdapter? = null
    private var list: ArrayList<Characters>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLocationBinding.inflate(
            LayoutInflater.from(requireContext()),
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = LocationAdapter(this::onItemClick)
        list?.let { adapter?.setList(it) }
        binding.recycleLocation.adapter = adapter
    }

    private fun loadData() {
        list = ArrayList<Characters>()
        list!!.add(Characters("Earth (C-137)", "Planet"))
        list!!.add(Characters("Abadango", "Cluster"))
        list!!.add(Characters("Citadel of Ricks", "Space station"))
        list!!.add(Characters("Worldender's lair", "Planet"))
        list!!.add(Characters("Anatomy Park", "Microverse"))
        list!!.add(Characters("Interdimensional Cable", "TV"))
        list!!.add(Characters("Immortality Field Resort", "Resort"))
        list!!.add(Characters("Post-Apocalyptic Earth", "Planet"))
        list!!.add(Characters("Purge Planet", "Planet"))
        list!!.add(Characters("Venzenulon 7", "Planet"))
        list!!.add(Characters("Bepis 9", "Planet"))
        list!!.add(Characters("Cronenberg Earth", "Planet"))
        list!!.add(Characters("Nuptia 4", "Planet"))
        list!!.add(Characters("Bird World", "Planet"))
        list!!.add(Characters("Earth (5-126)", "Planet"))
        list!!.add(Characters("Gromflom Prime", "Planet"))
        list!!.add(Characters("Earth (Rpl. Dimension)", "Planet"))
        list!!.add(Characters("Mr. Goldenfold's dream", "Dream"))
        list!!.add(Characters("St. Gloopy Noops Hospital", "Space station"))
        list!!.add(Characters("Giant's Town", "Fantasy town"))
    }

    private fun onItemClick(model: Characters) {
        findNavController().navigate(LocationFragmentDirections.actionLocationFragment2ToScreenFragment(model))
    }
}

