package com.musicode.weather

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.musicode.weather.domain.model.Forecast
import com.musicode.weather.domain.model.ForecastList
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.item_forecast.view.*

val View.ctx: Context
    get() = context

class ForecastListAdapter(
        private val weekForecast: ForecastList,
        private val itemClick: (Forecast) -> Unit
    ) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)

        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with (forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)

                itemView.date.text = date.toString()
                itemView.description.text = description

                itemView.maxTemperature.text = high.toString()
                itemView.minTemperature.text = low.toString()

                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

}