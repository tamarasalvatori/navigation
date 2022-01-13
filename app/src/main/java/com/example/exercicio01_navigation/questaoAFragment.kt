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

class questaoAFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentQuestaoABinding = DataBindingUtil.inflate(inflater, R.layout.fragment_questao_a, container, false)

        binding.btnConfirm.setOnClickListener() {
            var alternativaSelecionada = binding.radioGroup.checkedRadioButtonId

            if (alternativaSelecionada != -1) {
                var pontos = 0
                if (alternativaSelecionada == R.id.rdQuestionAOptionA) {
                    pontos += 1
                    view?.findNavController()?.navigate(questaoAFragmentDirections.actionQuestAFragmentToQuestaoBFragment(pontos))
                } else {
                    view?.findNavController()?.navigate(questaoAFragmentDirections.actionQuestAFragmentToQuestaoBFragment(pontos))
                }
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar à tela anterior", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}