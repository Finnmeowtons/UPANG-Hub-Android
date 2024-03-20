package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soriano.christianjose.block6.p1.upanghub.adapter.AnnouncementsAdapter
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentAnnouncementsBinding

class AnnouncementsFragment : Fragment() {
    private var _binding: FragmentAnnouncementsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnnouncementsBinding.inflate(inflater, container, false)
        val view = binding.root


        val recyclerViewAdapter = AnnouncementsAdapter()
        binding.rvAnnouncements.adapter = recyclerViewAdapter




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}