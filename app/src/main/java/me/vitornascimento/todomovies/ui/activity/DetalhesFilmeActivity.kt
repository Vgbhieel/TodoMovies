package me.vitornascimento.todomovies.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.todomovies.databinding.ActivityDetalhesFilmeBinding

class DetalhesFilmeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding
    private val view by lazy {
        binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(view)
    }

}