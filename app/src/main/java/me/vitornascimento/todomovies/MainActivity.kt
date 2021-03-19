package me.vitornascimento.todomovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.vitornascimento.todomovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val view by lazy {
        binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view)
    }

}