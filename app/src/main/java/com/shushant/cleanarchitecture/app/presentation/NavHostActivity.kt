package com.shushant.cleanarchitecture.app.presentation

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.shushant.cleanarchitecture.R
import com.shushant.cleanarchitecture.base.delegate.viewBinding
import com.shushant.cleanarchitecture.base.extension.navigateSafe
import com.shushant.cleanarchitecture.base.presentation.activity.BaseActivity
import com.shushant.cleanarchitecture.base.presentation.navigation.NavManager
import com.shushant.cleanarchitecture.databinding.ActivityNavHostBinding
import org.kodein.di.generic.instance

class NavHostActivity : BaseActivity() {

    private val binding: ActivityNavHostBinding by viewBinding()

    private val navController get() = findNavController(this, R.id.navHostFragment)

    private val navManager: NavManager by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initBottomNavigation()
        initNavManager()
    }

    private fun initBottomNavigation() {
        binding.bottomNav.setupWithNavController(navController)

        // Disables reselection of bottom menu item, so fragments are not recreated when clicking on the same menu item
        binding.bottomNav.setOnNavigationItemReselectedListener { }
    }

    private fun initNavManager() {
        navManager.setOnNavEvent {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

            currentFragment?.navigateSafe(it)
        }
    }
}
