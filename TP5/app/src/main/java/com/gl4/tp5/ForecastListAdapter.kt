package com.gl4.tp5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ForecastListAdapter(private val data: ArrayList<List>)  :
    RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val weatherDescr: TextView
        val day: TextView


        init {
            weatherDescr = itemView.findViewById(R.id.weather)
            day = itemView.findViewById(R.id.day)

        }

    }
    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastListAdapter.ViewHolder, position: Int) {
        var item = data[position]
        holder.weatherDescr.text = item.weather[0].description.toString()
        holder.day.text = "day "+(position+1).toString()+":"

    }

    override fun getItemCount(): Int {
        return data.size
    }
}