package com.android.weatherapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.weatherapp.Models.CombinedWeatherModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {


     @BindView(R.id.cur_temp) TextView curTemp;
     @BindView(R.id.temp_hi) TextView tempHI;
     @BindView(R.id.temp_low) TextView tempLOW;
     @BindView(R.id.humidity) TextView humidity;
     @BindView(R.id.wind_speed) TextView windSpeed;
     @BindView(R.id.weather_icon) ImageView weatherIcon;
     @BindView(R.id.city_name) TextInputEditText nameCity;
     @BindView(R.id.get_weather) Button getWeather;
    @BindView(R.id.weather_details) LinearLayout weatherDetails;
    @BindView(R.id.weather_overview) TextView weatherOverview;
    @BindView(R.id.pressure) TextView pressure;
    @BindView(R.id.city) TextView city;
    @BindView(R.id.country) TextView counttry;
    Subscription sub;
    String cityName;
    String imgUrl = "http://api.openweathermap.org/img/w/%s.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName = nameCity.getText().toString().trim();
                if(!TextUtils.isEmpty(cityName)) {
                    sub = ClientService.getInstance().getWeatherStatus(cityName).subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CombinedWeatherModel>() {
                                @Override
                                public void onCompleted() {
                                    weatherDetails.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    e.printStackTrace();
                                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onNext(CombinedWeatherModel combinedWeatherModel) {
                                    {
                                        pressure.setText(combinedWeatherModel.getMain().getPressure()+" Pa");
                                        weatherOverview.setText(combinedWeatherModel.getWeather().get(0).getDescription().toUpperCase());
                                        windSpeed.setText(combinedWeatherModel.getWind().getSpeed() + " km/h "+combinedWeatherModel.getWind().getDegrees());
                                        tempHI.setText(combinedWeatherModel.getMain().getTempMax() + "°C");
                                        curTemp.setText(combinedWeatherModel.getMain().getTemp() + "°C");
                                        tempLOW.setText(combinedWeatherModel.getMain().getTempMin() + "°C");
                                        humidity.setText(combinedWeatherModel.getMain().getHumidity() + "%");
                                        city.setText(combinedWeatherModel.getName()+",");
                                        counttry.setText(combinedWeatherModel.getSys().getCountry());
                                        Log.d("Current Weather", ""+combinedWeatherModel.getWeather().get(0).icon);
                                        Picasso.get().load(combinedWeatherModel.getWeather().get(0).getIcon()).into(weatherIcon);
                                    }

                                }
                            });
                }
                else{
                    nameCity.setError("No City");
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(sub!=null && !sub.isUnsubscribed()){
            sub.unsubscribe();
        }
    }
}
