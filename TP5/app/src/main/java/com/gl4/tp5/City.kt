package com.gl4.tp5

import com.google.gson.annotations.SerializedName


data class City (

    @SerializedName("id"         ) var id         : Int?    = null,
    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("coord"      ) var coord      : Coord?  = Coord(),
    @SerializedName("country"    ) var country    : String? = null,
    @SerializedName("population" ) var population : Double?    = null,
    @SerializedName("timezone"   ) var timezone   : Double?    = null

)