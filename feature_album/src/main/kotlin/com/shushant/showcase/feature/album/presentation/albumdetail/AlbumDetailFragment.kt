package com.shushant.showcase.feature.album.presentation.albumdetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.shushant.cleanarchitecture.base.presentation.extension.observe
import com.shushant.cleanarchitecture.base.presentation.fragment.InjectionFragment
import com.shushant.showcase.feature.album.R
import com.shushant.showcase.feature.album.databinding.FragmentAlbumDetailBinding
import org.kodein.di.generic.instance

internal class AlbumDetailFragment : InjectionFragment(R.layout.fragment_album_detail) {

    companion object {
        const val imageSize = 800
    }

    private val binding: FragmentAlbumDetailBinding by viewBinding()

    private val viewModel: AlbumDetailViewModel by instance()

    private val stateObserver = Observer<AlbumDetailViewModel.ViewState> {
        binding.progressBar.visible = it.isLoading

        binding.nameTextView.text = it.albumName
        binding.nameTextView.visible = it.albumName.isNotBlank()

        binding.artistTextView.text = it.artistName
        binding.artistTextView.visible = it.artistName.isNotBlank()

        binding.errorAnimation.visible = it.isError

        binding.coverImageView.load(it.coverImageUrl) {
            size(imageSize, imageSize)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.loadData()
    }
}
