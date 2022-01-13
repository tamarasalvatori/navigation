package com.example.exercicio01_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exercicio01_navigation.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentStartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        binding.btnStart.setOnClickListener {
            view?.findNavController()?.navigate(StartFragmentDirections.actionStartFragmentToQuestAFragment())
        }

        return binding.root
    }
}