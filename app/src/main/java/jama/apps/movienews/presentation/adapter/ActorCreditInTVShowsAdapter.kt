package jama.apps.movienews.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jama.apps.movienews.BuildConfig
import jama.apps.movienews.R
import jama.apps.movienews.data.actors.model.remote.tv_credits.ActorCastInTVShows
import jama.apps.movienews.databinding.ItemActorCreditInMovieBinding

class ActorCreditInTVShowsAdapter : RecyclerView.Adapter<ActorCreditInTVShowsAdapter.MovieCardViewHolder>() {

    private var itemClickListener: ((id: Long) -> Unit)? = null

    fun setItemClickListener(f: (id: Long) -> Unit) {
        itemClickListener = f
    }

    var data = mutableListOf<ActorCastInTVShows>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPersons(nData: List<ActorCastInTVShows>) {
        this.data.clear()
        this.data.addAll(nData)
        notifyDataSetChanged()
    }

    inner class MovieCardViewHolder(private val binding: ItemActorCreditInMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: ActorCastInTVShows) {
            binding.apply {
                name.text = data.original_name
                character.text = data.character
                Glide.with(binding.root.context)
                    .load("${BuildConfig.BASE_IMAGE_URL}${data.poster_path}")
                    .placeholder(R.drawable.ic_trailer)
                    .into(binding.image)

                itemView.setOnClickListener {
                    itemClickListener?.invoke(data.id.toLong())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieCardViewHolder(
        ItemActorCreditInMovieBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) =
        holder.bindData(data[position])
}