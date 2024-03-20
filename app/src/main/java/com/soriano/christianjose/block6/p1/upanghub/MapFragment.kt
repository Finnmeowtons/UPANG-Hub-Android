package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentMapBinding
import com.soriano.christianjose.block6.p1.upanghub.viewmodel.SharedViewModel

class MapFragment : Fragment() {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel.updateAppBarTitle("Map")




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}