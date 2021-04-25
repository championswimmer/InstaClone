package com.scaler.libimgur

import com.scaler.libimgur.apis.ImgurApiV3
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurClient {
    companion object {
        const val BASE_URL = "https://api.imgur.com/3/"
        const val API_KEY = "16abb74c6e5c7e8" // TODO: take this from app side
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val oldRequest = chain.request()
            val newRequest = oldRequest.newBuilder()
                .addHeader("Authorization", "Client-ID $API_KEY")
                .build()
            chain.proceed(newRequest)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(ImgurApiV3::class.java)



}