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
import com.example.exercicio01_navigation.databinding.FragmentQuestaoABinding
import com.example.exercicio01_navigation.databinding.FragmentQuestaoBBinding

class questaoBFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentQuestaoBBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_questao_b, container, false)

        binding.btnConfirm.setOnClickListener() {
            var alternativaSelecionada = binding.radioGroup.checkedRadioButtonId
            val args = questaoBFragmentArgs.fromBundle(requireArguments())
            var pontos = args.pontos

            if (alternativaSelecionada != -1){
                if (alternativaSelecionada == R.id.rdQuestionBOptionD) {
                    pontos += 1
                    view?.findNavController()?.navigate(questaoBFragmentDirections.actionQuestaoBFragmentToQuestaoCFragment(pontos))
                } else {
                    view?.findNavController()?.navigate(questaoBFragmentDirections.actionQuestaoBFragmentToQuestaoCFragment(pontos))
                }
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar à tela anterior", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}