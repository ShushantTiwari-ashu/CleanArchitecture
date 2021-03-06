package com.shushant.showcase.feature.album.domain

import com.shushant.showcase.feature.album.MODULE_NAME
import com.shushant.showcase.feature.album.domain.usecase.GetAlbumUseCase
import com.shushant.showcase.feature.album.domain.usecase.GetAlbumListUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule") {

    bind() from singleton { GetAlbumListUseCase(instance()) }

    bind() from singleton { GetAlbumUseCase(instance()) }
}
