package com.shushant.showcase.feature.album.data.network.service

import com.shushant.showcase.feature.album.data.network.response.GetAlbumInfoResponse
import com.shushant.showcase.feature.album.data.network.response.SearchAlbumResponse
import retrofit2.http.POST
import retrofit2.http.Query

internal interface AlbumRetrofitService {

    @POST("./?method=album.search")
    suspend fun searchAlbumAsync(
        @Query("album") phrase: String,
        @Query("limit") limit: Int = 60
    ): SearchAlbumResponse

    @POST("./?method=album.getInfo")
    suspend fun getAlbumInfoAsync(
        @Query("artist") artistName: String,
        @Query("album") albumName: String,
        @Query("mbid") mbId: String?
    ): GetAlbumInfoResponse?
}
