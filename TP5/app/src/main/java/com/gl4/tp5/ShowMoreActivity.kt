package com.gl4.tp5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt


class ShowMoreActivity : AppCompatActivity() {

    private val forecastModel : ForecastViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_more)

        var ville = intent.getStringExtra("ville").toString()

        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@ShowMoreActivity)


        var forecastList = arrayListOf<com.gl4.tp5.List>()
        forecastModel.ville = ville


        forecastModel.getForecast(ville)
        forecastModel.forecast.observe(this) {

            forecastList = it.list
            Toast.makeText(applicationContext, ville.toString(), Toast.LENGTH_LONG).show()



            val forecastListAdapter = ForecastListAdapter(forecastList)

            recyclerView.adapter = forecastListAdapter
        }




    }
}

