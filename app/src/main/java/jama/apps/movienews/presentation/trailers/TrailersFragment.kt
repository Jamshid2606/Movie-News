package jama.apps.movienews.presentation.trailers

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jama.apps.movienews.databinding.FragmentTrailersBinding
import jama.apps.movienews.presentation.BaseFragment
import jama.apps.movienews.presentation.YoutubeActivity
import jama.apps.movienews.presentation.adapter.MovieTrailerLimitlessAdapter
import jama.apps.movienews.presentation.tv_show_details.TVShowDetailViewModel

@AndroidEntryPoint
class TrailersFragment : BaseFragment<FragmentTrailersBinding>(FragmentTrailersBinding::inflate) {
    val viewModel: TVShowDetailViewModel by viewModels()
    private val adapterTrailer by lazy {
        MovieTrailerLimitlessAdapter()
    }
    override fun onViewCreate() {
        val id = requireArguments().getLong("TV_ID", 0)

        binding.allTrailersList.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        binding.allTrailersList.adapter = adapterTrailer

        viewModel.getTVTrailerListById(id)
        viewModel.movieTrailerLiveData.observe(viewLifecycleOwner) {
            it.results.let { item ->
                if (item != null) {
                    adapterTrailer.setTrailers(item)
                }
            }
        }

        adapterTrailer.setItemClickListener {
            val intent = Intent(requireContext(), YoutubeActivity::class.java)
            intent.putExtra("YOUTUBE_VIDEO_ID", it)
            startActivity(intent)
        }
    }
}