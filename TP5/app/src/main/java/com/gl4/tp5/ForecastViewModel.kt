package com.gl4.tp5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastViewModel(): ViewModel() {

    val forecast : MutableLiveData<ForecastResponse>by lazy { MutableLiveData<ForecastResponse> ()}
    var ville: String=""

     fun getForecast(ville: String) {
        RetrofitHelper.retrofitService.getForecast(ville, "16").enqueue(object : Callback<ForecastResponse> {
            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                if(response.isSuccessful)
                    forecast.value = response.body()

            }
            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        })
    }
}