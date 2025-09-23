package com.example.pertemuan1.data.network

import com.example.pertemuan1.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: OpenLibraryApi by lazy {
        Retrofit.Builder()
            .baseUrl(  Constants.BASE_URL)
            .addConverterFactory ( GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApi::class.java)
    }
}