package com.gl4.tp5


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface WeatherAPI {

    @GET("weather?APPID=17db59488cadcad345211c36304a9266")
    fun getWeather(@Query("q") ville: String?) : Call<WeatherResponse>

    @GET("forecast/daily?APPID=17db59488cadcad345211c36304a9266")
    fun getForecast(@Query("q") ville: String?, @Query("cnt") cnt: String?) : Call<ForecastResponse>
}
