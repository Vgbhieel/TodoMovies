package me.vitornascimento.todomovies.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.vitornascimento.todomovies.databinding.FragmentDetalhesFilmeBinding
import me.vitornascimento.todomovies.viewmodel.DetalhesFilmeViewModel
import me.vitornascimento.todomovies.viewmodel.factory.DetalhesFilmeViewModelFactory

class DetalhesFilmeFragment : Fragment() {

    private var _binding: FragmentDetalhesFilmeBinding? = null

    private val binding get() = _binding!!

    private val viewModel by lazy {
        val factory = DetalhesFilmeViewModelFactory()
        val provider = ViewModelProvider(this, factory)
        provider.get(DetalhesFilmeViewModel::class.java)
    }

    private val ID_FILME_A_CABANA = 345938

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesFilmeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}