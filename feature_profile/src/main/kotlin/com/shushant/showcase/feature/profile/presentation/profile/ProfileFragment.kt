package com.shushant.showcase.feature.profile.presentation.profile

import com.shushant.cleanarchitecture.base.presentation.fragment.InjectionFragment
import com.shushant.showcase.feature.profile.R
import com.shushant.showcase.feature.profile.databinding.FragmentProfileBinding

class ProfileFragment : InjectionFragment(R.layout.fragment_profile) {

    private val binding: FragmentProfileBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }
}
