package com.scaler.libimgur.apis

import com.scaler.libimgur.models.GalleryResponse
import retrofit2.Call
import retrofit2.http.GET

interface ImgurApiV3 {
    @GET("gallery/top")
    fun getGallery(): Call<GalleryResponse>
}