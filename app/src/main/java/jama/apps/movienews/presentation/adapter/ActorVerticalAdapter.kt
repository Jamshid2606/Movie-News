package jama.apps.movienews.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jama.apps.movienews.BuildConfig
import jama.apps.movienews.R
import jama.apps.movienews.data.actors.model.local.ActorsResultDto
import jama.apps.movienews.databinding.ItemActorVerticalBinding

class ActorVerticalAdapter : RecyclerView.Adapter<ActorVerticalAdapter.MovieCardViewHolder>() {

    private var itemClickListener: ((id: Long) -> Unit)? = null

    fun setItemClickListener(f: (id: Long) -> Unit) {
        itemClickListener = f
    }

    var data = mutableListOf<ActorsResultDto>()

    @SuppressLint("NotifyDataSetChanged")
    fun setPersons(nData: List<ActorsResultDto>) {
        this.data.clear()
        this.data.addAll(nData)
        notifyDataSetChanged()
    }

    inner class MovieCardViewHolder(private val binding: ItemActorVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: ActorsResultDto) {
            binding.apply {
                name.text = data.name

                Glide.with(binding.root.context)
                    .load("${BuildConfig.BASE_IMAGE_URL}${data.profilePath}")
                    .placeholder(R.drawable.ic_actor)
                    .into(binding.image)

                itemView.setOnClickListener {
                    itemClickListener?.invoke(data.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieCardViewHolder(
        ItemActorVerticalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieCardViewHolder, position: Int) =
        holder.bindData(data[position])
}