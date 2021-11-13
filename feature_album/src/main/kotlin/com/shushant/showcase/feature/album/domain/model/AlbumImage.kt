package com.shushant.showcase.feature.album.domain.model

import com.shushant.showcase.feature.album.domain.enum.AlbumDomainImageSize

internal data class AlbumImage(
    val url: String,
    val size: AlbumDomainImageSize
)
