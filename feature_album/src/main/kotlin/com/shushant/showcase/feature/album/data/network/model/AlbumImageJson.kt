package com.shushant.showcase.feature.album.data.network.model

import com.shushant.showcase.feature.album.data.database.model.AlbumImageEntity
import com.shushant.showcase.feature.album.data.network.enum.AlbumImageSizeJson
import com.shushant.showcase.feature.album.data.network.enum.toDomainModel
import com.shushant.showcase.feature.album.data.network.enum.toEntityEnum
import com.shushant.showcase.feature.album.domain.model.AlbumImage
import com.squareup.moshi.Json

internal data class AlbumImageJson(
    @field:Json(name = "#text") val url: String,
    @field:Json(name = "size") val size: AlbumImageSizeJson
)

internal fun AlbumImageJson.toDomainModel() = AlbumImage(
    url = this.url,
    size = this.size.toDomainModel()
)

internal fun AlbumImageJson.toEntity() =
    this.size.toEntityEnum()?.let { AlbumImageEntity(this.url, it) }
