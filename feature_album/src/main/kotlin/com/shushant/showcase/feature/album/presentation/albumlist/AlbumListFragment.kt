package com.shushant.showcase.feature.album.presentation.albumlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.shushant.cleanarchitecture.base.presentation.extension.observe
import com.shushant.cleanarchitecture.base.presentation.fragment.InjectionFragment
import com.shushant.showcase.feature.album.R
import com.shushant.showcase.feature.album.databinding.FragmentAlbumListBinding
import com.shushant.showcase.feature.album.presentation.albumlist.recyclerview.AlbumAdapter
import com.shushant.showcase.feature.album.presentation.albumlist.recyclerview.GridAutofitLayoutManager
import org.kodein.di.generic.instance

class AlbumListFragment : InjectionFragment(R.layout.fragment_album_list) {

    private val binding: FragmentAlbumListBinding by viewBinding()

    private val viewModel: AlbumListViewModel by instance()

    private val albumAdapter: AlbumAdapter by instance()

    private val stateObserver = Observer<AlbumListViewModel.ViewState> {
        albumAdapter.albums = it.albums

        binding.progressBar.visible = it.isLoading
        binding.errorAnimation.visible = it.isError
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = requireContext()

        albumAdapter.setOnDebouncedClickListener {
            viewModel.navigateToAlbumDetails(it.artist, it.name, it.mbId)
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            val columnWidth = context.resources.getDimension(R.dimen.image_size).toInt()
            layoutManager =
                GridAutofitLayoutManager(
                    context,
                    columnWidth
                )
            adapter = albumAdapter
        }

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }
}
