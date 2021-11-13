package com.shushant.showcase.feature.album.data

import com.shushant.showcase.feature.album.data.database.AlbumDao
import com.shushant.showcase.feature.album.data.database.model.toDomainModel
import com.shushant.showcase.feature.album.data.network.model.toDomainModel
import com.shushant.showcase.feature.album.data.network.model.toEntity
import com.shushant.showcase.feature.album.data.network.service.AlbumRetrofitService
import com.shushant.showcase.feature.album.domain.model.Album
import com.shushant.showcase.feature.album.domain.repository.AlbumRepository
import java.net.UnknownHostException

internal class AlbumRepositoryImpl(
    private val albumRetrofitService: AlbumRetrofitService,
    private val albumDao: AlbumDao
) : AlbumRepository {

    override suspend fun getAlbumInfo(artistName: String, albumName: String, mbId: String?): Album? {
        return try {
            albumRetrofitService.getAlbumInfoAsync(artistName, albumName, mbId)
                ?.album
                ?.toDomainModel()
        } catch (e: UnknownHostException) {
            albumDao.getAlbum(artistName, albumName, mbId).toDomainModel()
        }
    }

    override suspend fun searchAlbum(phrase: String): List<Album> {
        return try {
            val searchAlbumResponse = albumRetrofitService.searchAlbumAsync(phrase)
            val albumList = searchAlbumResponse.results.albumMatches.album

            albumList
                .map { it.toEntity() }
                .let { albumDao.insertAlbums(it) }

            albumList.map { it.toDomainModel() }
        } catch (e: UnknownHostException) {
            albumDao.getAll()
                .map { it.toDomainModel() }
        }
    }
}
