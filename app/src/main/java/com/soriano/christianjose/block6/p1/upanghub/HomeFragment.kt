package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.soriano.christianjose.block6.p1.upanghub.adapter.AnnouncementsAdapter
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentHomeBinding
import com.soriano.christianjose.block6.p1.upanghub.viewmodel.SharedViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel.updateAppBarTitle("Home")
        val recyclerViewAdapter = AnnouncementsAdapter()
        binding.rvAnnouncements.adapter = recyclerViewAdapter

        binding.cvMap.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mapFragment)
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}