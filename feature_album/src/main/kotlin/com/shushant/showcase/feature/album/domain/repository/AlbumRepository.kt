package com.shushant.showcase.feature.album.domain.repository

import com.shushant.showcase.feature.album.domain.model.Album

internal interface AlbumRepository {

    suspend fun getAlbumInfo(artistName: String, albumName: String, mbId: String?): Album?

    suspend fun searchAlbum(phrase: String): List<Album>
}
