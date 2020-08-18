package com.example.abyte

import com.example.abyte.models.Statement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryStatement {

    fun getData(iDatos: IDatos) {
        val apiInterface = APIClient.client!!.create(APIInterface::class.java)
        val call: Call<Statement?>? = apiInterface.getStatements()
        call!!.enqueue(object : Callback<Statement?> {
            override fun onFailure(call: Call<Statement?>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(call: Call<Statement?>, response: Response<Statement?>) {
                if (response.isSuccessful) {
                    val resource: Statement? = response.body()
                    iDatos.datos(resource!!)

                }
            }

        })
    }
}