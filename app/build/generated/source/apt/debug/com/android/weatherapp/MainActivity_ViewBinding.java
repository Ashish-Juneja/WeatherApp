// Generated code from Butter Knife. Do not modify!
package com.android.weatherapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.curTemp = Utils.findRequiredViewAsType(source, R.id.cur_temp, "field 'curTemp'", TextView.class);
    target.tempHI = Utils.findRequiredViewAsType(source, R.id.temp_hi, "field 'tempHI'", TextView.class);
    target.tempLOW = Utils.findRequiredViewAsType(source, R.id.temp_low, "field 'tempLOW'", TextView.class);
    target.humidity = Utils.findRequiredViewAsType(source, R.id.humidity, "field 'humidity'", TextView.class);
    target.windSpeed = Utils.findRequiredViewAsType(source, R.id.wind_speed, "field 'windSpeed'", TextView.class);
    target.weatherIcon = Utils.findRequiredViewAsType(source, R.id.weather_icon, "field 'weatherIcon'", ImageView.class);
    target.nameCity = Utils.findRequiredViewAsType(source, R.id.city_name, "field 'nameCity'", TextInputEditText.class);
    target.getWeather = Utils.findRequiredViewAsType(source, R.id.get_weather, "field 'getWeather'", Button.class);
    target.weatherDetails = Utils.findRequiredViewAsType(source, R.id.weather_details, "field 'weatherDetails'", LinearLayout.class);
    target.weatherOverview = Utils.findRequiredViewAsType(source, R.id.weather_overview, "field 'weatherOverview'", TextView.class);
    target.pressure = Utils.findRequiredViewAsType(source, R.id.pressure, "field 'pressure'", TextView.class);
    target.city = Utils.findRequiredViewAsType(source, R.id.city, "field 'city'", TextView.class);
    target.counttry = Utils.findRequiredViewAsType(source, R.id.country, "field 'counttry'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.curTemp = null;
    target.tempHI = null;
    target.tempLOW = null;
    target.humidity = null;
    target.windSpeed = null;
    target.weatherIcon = null;
    target.nameCity = null;
    target.getWeather = null;
    target.weatherDetails = null;
    target.weatherOverview = null;
    target.pressure = null;
    target.city = null;
    target.counttry = null;
  }
}
