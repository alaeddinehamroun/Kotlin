package com.gl4.tp5

import com.google.gson.annotations.SerializedName


data class Sys (

  @SerializedName("type"    ) var type    : Double?    = null,
  @SerializedName("id"      ) var id      : Int?    = null,
  @SerializedName("country" ) var country : String? = null,
  @SerializedName("sunrise" ) var sunrise : Double?    = null,
  @SerializedName("sunset"  ) var sunset  : Double?    = null

)