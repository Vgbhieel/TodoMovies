package me.vitornascimento.todomovies.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import me.vitornascimento.todomovies.R
import me.vitornascimento.todomovies.model.SimilarMovie
import java.text.SimpleDateFormat

class DetalhesFilmeAdapter(
    val context: Context,
    val filmesRelacionados: MutableList<SimilarMovie> = mutableListOf()
) :
    RecyclerView.Adapter<DetalhesFilmeAdapter.DetalhesFilmeViewHolder>() {

    private val BASE_URL_IMG = "https://image.tmdb.org/t/p/w780"

    inner class DetalhesFilmeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivCartaz: ImageView = view.findViewById(R.id.iv_cartaz_filme)
        val tvTitulo: TextView = view.findViewById(R.id.tv_titulo_filme)
        val tvAno: TextView = view.findViewById(R.id.tv_ano_lancamento)


        fun bind(filmeRelacionado: SimilarMovie) {

            tvTitulo.text = filmeRelacionado.title

            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)

            Glide
                .with(context)
                .load(BASE_URL_IMG + "${filmeRelacionado.poster_path}")
                .apply(options)
                .into(ivCartaz)

            tvAno.text = "${SimpleDateFormat("YYYY").format(filmeRelacionado.release_date)}"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalhesFilmeViewHolder {
        val viewCriada =
            LayoutInflater.from(context).inflate(R.layout.item_filmes_relacionados, parent, false)
        return DetalhesFilmeViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder: DetalhesFilmeViewHolder, position: Int) {
        holder.bind(filmesRelacionados[position])
    }

    override fun getItemCount(): Int = this.filmesRelacionados.size

    fun atualiza(filmesSimilares: List<SimilarMovie>) {
        notifyItemRangeRemoved(0, this.filmesRelacionados.size)
        this.filmesRelacionados.clear()
        this.filmesRelacionados.addAll(filmesSimilares)
        notifyItemRangeInserted(0, this.filmesRelacionados.size)
    }
}