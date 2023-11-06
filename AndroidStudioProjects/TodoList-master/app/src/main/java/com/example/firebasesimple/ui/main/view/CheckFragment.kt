package com.example.firebasesimple.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firebasesimple.databinding.FragmentCheckBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CheckFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckFragment : Fragment() {
    lateinit var binding: FragmentCheckBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckBinding.inflate(inflater, container, false)
        // ActionBar 숨기기
        (activity as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }



}