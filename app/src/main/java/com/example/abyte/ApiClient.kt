package com.example.abyte

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal object APIClient {
    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            val client = OkHttpClient.Builder().build()
            retrofit = Retrofit.Builder()
                .baseUrl("https://91f7b927-de7a-401b-8a73-f0fd9b35764d.mock.pstmn.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit
        }
}