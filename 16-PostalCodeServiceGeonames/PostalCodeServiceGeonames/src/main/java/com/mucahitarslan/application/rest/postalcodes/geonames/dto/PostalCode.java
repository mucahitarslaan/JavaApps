package com.mucahitarslan.application.rest.postalcodes.geonames.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class PostalCode
{
    private String adminCode1;
    private String adminName1;
    private String placeName;
    private double latitude;
    private double longitude;

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @JsonGetter(value = "lat")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonGetter(value = "lng")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %f %f", adminCode1, adminName1, placeName , latitude, longitude);
    }
}
