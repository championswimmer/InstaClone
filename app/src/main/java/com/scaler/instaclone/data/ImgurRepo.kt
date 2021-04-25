package com.scaler.instaclone.data

import android.util.Log
import com.scaler.libimgur.ImgurClient
import com.scaler.libimgur.models.Image
import java.lang.IllegalStateException

object ImgurRepo {
    val api by lazy { ImgurClient().api }

    suspend fun getTopGallery(): List<Image>?  {
        return try {
            val response = api.getGallery("top")
            response.data ?: throw IllegalStateException("No data received")
        } catch (e: Exception) {
            Log.e("API", "error fetching top gallery")
            null
        }
    }

    suspend fun getHotGallery(): List<Image>?  {
        return try {
            val response = api.getGallery("hot")
            response.data ?: throw IllegalStateException("No data received")
        } catch (e: Exception) {
            Log.e("API", "error fetching top gallery")
            null
        }
    }
}