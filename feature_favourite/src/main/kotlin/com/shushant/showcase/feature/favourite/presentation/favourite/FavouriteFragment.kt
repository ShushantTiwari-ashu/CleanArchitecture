package com.shushant.showcase.feature.favourite.presentation.favourite

import com.shushant.cleanarchitecture.base.presentation.fragment.InjectionFragment
import com.shushant.showcase.feature.favourite.R
import com.shushant.showcase.feature.favourite.databinding.FragmentFavouritesBinding

class FavouriteFragment : InjectionFragment(R.layout.fragment_favourites) {

    private val binding: FragmentFavouritesBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }
}
