package com.example.abyte.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Statement{
    @SerializedName("statement")
    @Expose
    var statement: ArrayList<Datos>? = null
}
class Datos{
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("amount")
    @Expose
    var amount: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("currency")
    @Expose
    var currency: String? = null

}