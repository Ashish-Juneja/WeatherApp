package com.android.weatherapp;

import com.android.weatherapp.Models.CombinedWeatherModel;

import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("weather")
    Observable<CombinedWeatherModel> getWeather(@Query("q") String city, @Query("appid") String api_key, @Query("units") String unit);
}
