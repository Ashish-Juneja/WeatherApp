
package com.android.weatherapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;

    public String getDegrees() {
        if(degrees==0 || degrees==360)
            return "N";
        if(degrees>0 && degrees<90)
            return "NE";
        if(degrees==90)
            return "E";
        if(degrees>90 && degrees<180)
            return "SE";
        if(degrees==180)
            return "S";
        if(degrees>180 && degrees<270)
            return "SW";
        if(degrees==270)
            return "W";
        if(degrees>270 && degrees<360)
            return "NW";
        else
            return null;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    @SerializedName("deg")
    @Expose
    private Double degrees;


    /**
     * No args constructor for use in serialization
     * 
     */
    public Wind() {
    }

    /**
     * 
     * @param speed
     */
    public Wind(Double speed,Double deg) {
        super();
        this.speed = speed;
        this.degrees=deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

}
