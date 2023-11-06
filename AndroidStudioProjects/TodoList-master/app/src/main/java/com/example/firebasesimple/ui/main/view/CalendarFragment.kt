package com.example.firebasesimple.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firebasesimple.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {
    lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        // ActionBar 숨기기
        (activity as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }



}