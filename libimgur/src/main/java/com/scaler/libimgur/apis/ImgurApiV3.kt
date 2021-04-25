package com.scaler.libimgur.apis

import com.scaler.libimgur.models.GalleryResponse
import com.scaler.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ImgurApiV3 {
    @GET("gallery/{section}")
    fun getGallery(
        @Path("section") section: String
    ): Call<GalleryResponse>

    @GET("tags")
    fun getTags(): Call<TagsResponse>


}