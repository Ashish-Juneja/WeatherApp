
package com.android.weatherapp.Models;

import com.android.weatherapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    public String icon;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param id
     * @param icon
     * @param description
     * @param main
     */
    public Weather(Integer id, String main, String description, String icon) {
        super();
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        switch(icon.trim()){
            case "1d":
                return R.drawable.day1 ;

            case "01n" : return R.drawable.night1;
            case "02d" : return R.drawable.day2;
            case "02n" : return R.drawable.night2;
            case "03d" : return R.drawable.day3;
            case "03n" : return R.drawable.night3;
            case "04d ":
            case "04n": return R.drawable.day_night4;
            case "09d" : return R.drawable.day9;
            case "09n" : return R.drawable.night9;
            case "10d" : return R.drawable.day10;
            case "10n" : return R.drawable.night10;
            case "11d" :
            case "11n":return R.drawable.day_night11;
            case "13d":
            case"13n":return R.drawable.day_night13;
            case "50d":
            case"50n":return R.drawable.day_night50;
            default:
                return 0;
        }
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
