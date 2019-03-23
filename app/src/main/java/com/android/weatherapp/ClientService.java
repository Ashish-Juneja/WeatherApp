package com.android.weatherapp;

import com.android.weatherapp.Models.CombinedWeatherModel;

import rx.Observable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ClientService {

    final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    final String API_KEY = "a9e2eb22a3303644f250340f568b8d71";
    final String units="metric";
    static ClientService cs;
    WeatherApiService was;

    private ClientService(){
        Retrofit rf = new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        was = rf.create(WeatherApiService.class);
    }

    public static ClientService getInstance(){
        if(cs==null){
            cs= new ClientService();
        }
        return cs;
    }

    public Observable<CombinedWeatherModel> getWeatherStatus(String city){
        return was.getWeather(city,API_KEY,units);
    }
}
