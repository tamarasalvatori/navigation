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

class aprovadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentAprovadoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_aprovado, container, false)
        val args = aprovadoFragmentArgs.fromBundle(requireArguments())

        binding.txtAprovado.text = "Parabéns! Você acertou ${args.pontos} das 3 perguntas"

        binding.btnFinish.setOnClickListener() {
            view?.findNavController()?.navigate(aprovadoFragmentDirections.actionAprovadoFragmentToStartFragment())
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            view?.findNavController()?.navigate(aprovadoFragmentDirections.actionAprovadoFragmentToStartFragment())
        }

        return binding.root
    }
}