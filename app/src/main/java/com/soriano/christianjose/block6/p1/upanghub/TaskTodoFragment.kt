package com.soriano.christianjose.block6.p1.upanghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentTaskBinding
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentTaskTodoBinding

class TaskTodoFragment : Fragment() {

    private lateinit var binding: FragmentTaskTodoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskTodoBinding.inflate(inflater, container, false)

        return binding.root
    }

}