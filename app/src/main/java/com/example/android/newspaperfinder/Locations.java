package com.example.android.newspaperfinder;

import android.content.Loader;

/**
 * Created by epatter1 on 2/4/2017.
 */

public class Locations {

    public String getStyle() {
        return style;
    }

    public Locations(String style, String details, String latitude, String longitude)
    {
        this.setStyle(style);
        this.setDetails(details);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    private String style, details, latitude, longitude;


}
