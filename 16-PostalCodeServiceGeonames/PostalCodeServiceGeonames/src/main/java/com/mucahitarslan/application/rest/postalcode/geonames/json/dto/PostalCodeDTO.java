package com.mucahitarslan.application.rest.postalcode.geonames.json.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PostalCodeDTO {

    public StatusDTO status;
    public String adminCode1;
    public String adminName1;
    public String placeName;
    @JsonProperty("lat")
    public double latitude;
    @JsonProperty("lng")
    public double longitude;

    @Override
    public String toString() {
        return String.format("%s %s %s %f %f", adminCode1,adminName1,placeName,longitude,latitude);
    }
}
