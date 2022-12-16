interface WeatherAPI {

    @GET("weather?q=Tunis&APPID=17db59488cadcad345211c36304a9266")
    fun getWeather() : Call<WeatherResponse>
}
