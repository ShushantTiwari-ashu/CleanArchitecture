package com.shushant.showcase.feature.album.presentation

import androidx.fragment.app.Fragment
import coil.ImageLoader
import com.shushant.cleanarchitecture.base.di.KotlinViewModelProvider
import com.shushant.showcase.feature.album.MODULE_NAME
import com.shushant.showcase.feature.album.presentation.albumdetail.AlbumDetailViewModel
import com.shushant.showcase.feature.album.presentation.albumlist.AlbumListViewModel
import com.shushant.showcase.feature.album.presentation.albumlist.recyclerview.AlbumAdapter
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    // AlbumList
    bind<AlbumListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumListViewModel(instance(), instance()) }
    }

    bind() from singleton { AlbumAdapter() }

    bind() from singleton { ImageLoader(instance()) }

    // AlbumDetails
    bind<AlbumDetailViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumDetailViewModel(instance(), instance()) }
    }
}
