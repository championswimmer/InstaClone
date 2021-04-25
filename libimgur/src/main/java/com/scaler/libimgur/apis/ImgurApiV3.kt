package com.scaler.libimgur.apis

import com.scaler.libimgur.models.GalleryResponse
import com.scaler.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ImgurApiV3 {
    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path("section") section: String
    ): GalleryResponse

    @GET("tags")
    suspend fun getTags(): TagsResponse


}