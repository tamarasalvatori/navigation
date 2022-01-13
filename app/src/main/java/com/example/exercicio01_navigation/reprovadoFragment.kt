package com.example.exercicio01_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exercicio01_navigation.databinding.FragmentAprovadoBinding
import com.example.exercicio01_navigation.databinding.FragmentQuestaoABinding
import com.example.exercicio01_navigation.databinding.FragmentReprovadoBinding

class reprovadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentReprovadoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reprovado, container, false)
        val args = reprovadoFragmentArgs.fromBundle(requireArguments())

        binding.txtReprovado.text = "Tente novamente! Você acertou ${args.pontos} das 3 perguntas"

        binding.btnFinish.setOnClickListener() {
            view?.findNavController()?.navigate(reprovadoFragmentDirections.actionReprovadoFragmentToStartFragment())
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            view?.findNavController()?.navigate(reprovadoFragmentDirections.actionReprovadoFragmentToStartFragment())
        }

        return binding.root
    }
}