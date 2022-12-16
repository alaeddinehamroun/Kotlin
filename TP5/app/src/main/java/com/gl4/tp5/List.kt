package com.gl4.tp5

import com.google.gson.annotations.SerializedName


data class List (

    @SerializedName("dt"         ) var dt        : Double?               = null,
    @SerializedName("sunrise"    ) var sunrise   : Double?               = null,
    @SerializedName("sunset"     ) var sunset    : Double?               = null,
    @SerializedName("temp"       ) var temp      : Temp?              = Temp(),
    @SerializedName("feels_like" ) var feelsLike : FeelsLike?         = FeelsLike(),
    @SerializedName("pressure"   ) var pressure  : Double?               = null,
    @SerializedName("humidity"   ) var humidity  : Double?               = null,
    @SerializedName("weather"    ) var weather   : ArrayList<Weather> = arrayListOf(),
    @SerializedName("speed"      ) var speed     : Double?            = null,
    @SerializedName("deg"        ) var deg       : Double?               = null,
    @SerializedName("gust"       ) var gust      : Double?            = null,
    @SerializedName("clouds"     ) var clouds    : Double?               = null,
    @SerializedName("pop"        ) var pop       : Double?               = null

)