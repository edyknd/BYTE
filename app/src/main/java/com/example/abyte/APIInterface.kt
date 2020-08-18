package com.example.abyte

import com.example.abyte.models.Statement
import retrofit2.Call
import retrofit2.http.GET




interface APIInterface {
    @GET("user/statements")
    fun getStatements(): Call<Statement?>?

}