package com.gl4.tp5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val country : TextView by lazy { findViewById(R.id.country) }
        val degree : TextView by lazy { findViewById(R.id.degree) }
        val description : TextView by lazy { findViewById(R.id.description) }
        val humidity : TextView by lazy { findViewById(R.id.humidity) }
        val pressure : TextView by lazy { findViewById(R.id.pressure) }
        val weather_pic : ImageView by lazy { findViewById(R.id.imageView) }
        var selectedVille : String = ""


        val spinner : Spinner by lazy { findViewById(R.id.spinner) }
        var villes = listOf<String>("Japan","Spain", "Tunisia", "Qatar")
        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, villes)

        viewModel.ville.observe(this) {
            viewModel.getWeather(it)
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when(position) {
                    0 -> {
                        viewModel.ville.value = villes[0]
                        selectedVille = villes[0]
                    }
                    1 -> {
                        viewModel.ville.value = villes[1]
                        selectedVille = villes[1]
                    }
                    2 -> {
                        viewModel.ville.value = villes[2]
                        selectedVille = villes[2]
                    }
                    3 -> {
                        viewModel.ville.value = villes[3]
                        selectedVille = villes[3]
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                showToast(message = "Nothing selected")
            }
            private fun showToast(context: Context = applicationContext, message: String, duration: Int = Toast.LENGTH_LONG) {
                Toast.makeText(context, message, duration).show()
            }
        }

        viewModel.weather.observe(this) {
            country.text = it.name.toString()
            degree.text = (it.main?.temp?.minus(273.15))?.roundToInt().toString() + " °C"
            description.text = it.weather[0].description.toString()
            humidity.text ="Humidity " + it.main?.humidity.toString()
            pressure.text ="Pressure " +  it.main?.pressure.toString()
            Glide.with(this).load("https://openweathermap.org/img/wn/"+ it.weather[0].icon+"@4x.png").into(weather_pic)

        }

        var button: Button = findViewById(R.id.button)


        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ShowMoreActivity::class.java)
            intent.putExtra("ville",selectedVille)
            startActivity(intent)
        }

    }



}
