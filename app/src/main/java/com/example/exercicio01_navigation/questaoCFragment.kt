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
import com.example.exercicio01_navigation.databinding.FragmentQuestaoCBinding

class questaoCFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentQuestaoCBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_questao_c, container, false)

        binding.btnConfirm.setOnClickListener() {
            var alternativaSelecionada = binding.radioGroup.checkedRadioButtonId
            val args = questaoCFragmentArgs.fromBundle(requireArguments())
            var pontos = args.pontos

            if (alternativaSelecionada != -1){
                if (alternativaSelecionada == R.id.rdQuestionCOptionB) {
                    pontos += 1
                }
            }

            if (pontos >= 2 ){
                view?.findNavController()?.navigate(questaoCFragmentDirections.actionQuestaoCFragmentToAprovadoFragment(pontos))
            }else {
                view?.findNavController()?.navigate(questaoCFragmentDirections.actionQuestaoCFragmentToReprovadoFragment(pontos))
            }
        }

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar à tela anterior", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}