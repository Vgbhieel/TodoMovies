package me.vitornascimento.todomovies.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.vitornascimento.todomovies.R
import me.vitornascimento.todomovies.databinding.FragmentDetalhesFilmeBinding
import me.vitornascimento.todomovies.ui.adapter.DetalhesFilmeAdapter
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

    private val adapter by lazy {
        context?.let {
            DetalhesFilmeAdapter(context = it)
        } ?: throw IllegalArgumentException("Contexto Inválido")
    }

    private val ID_FILME_A_CABANA = 345938

    private val BASE_URL_IMG = "https://image.tmdb.org/t/p/w780"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesFilmeBinding.inflate(inflater, container, false)
        val view = binding.root

        configuraRecyclerView()

        configuraBotaoFavoritar()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        buscaFilme(ID_FILME_A_CABANA)

    }

    private fun buscaFilme(movieId: Int) {

        viewModel.buscaFilme(movieId).observe(this) {

            it?.let {
                binding.detalhesFilmesTvTituloFilme.text = it.title

                binding.detalhesFilmesTvLikes.text = "${it.vote_count.toString()} Likes"

                val options: RequestOptions = RequestOptions()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                Glide
                    .with(this)
                    .load(BASE_URL_IMG + "${it.poster_path}")
                    .apply(options)
                    .into(binding.detalhesFilmesIvCartazFilme)
            }

        }

        viewModel.buscaFilmesRelacionados(movieId).observe(this) {

            it?.let {
                adapter.atualiza(it)
            }

        }

    }

    private fun configuraBotaoFavoritar() {

        var currentImage = R.drawable.ic_favorite_heart_outlined

        binding.detalhesFilmesIvFavorite.setOnClickListener {

            if (currentImage == R.drawable.ic_favorite_heart_outlined) {

                binding.detalhesFilmesIvFavorite.setImageResource(R.drawable.ic_favorite_heart_filled)
                currentImage = R.drawable.ic_favorite_heart_filled

            } else {

                binding.detalhesFilmesIvFavorite.setImageResource(R.drawable.ic_favorite_heart_outlined)
                currentImage = R.drawable.ic_favorite_heart_outlined

            }
        }
    }

    private fun configuraRecyclerView() {
        binding.detalhesFilmesRvFilmesRelacionados.adapter = adapter
    }
}