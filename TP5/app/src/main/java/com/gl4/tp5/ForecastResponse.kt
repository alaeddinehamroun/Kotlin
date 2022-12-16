package com.gl4.tp5

import com.google.gson.annotations.SerializedName


data class ForecastResponse (

    @SerializedName("city"    ) var city    : City?           = City(),
    @SerializedName("cod"     ) var cod     : String?         = null,
    @SerializedName("message" ) var message : Double?         = null,
    @SerializedName("cnt"     ) var cnt     : Double?            = null,
    @SerializedName("list"    ) var list    : ArrayList<List> = arrayListOf()

)