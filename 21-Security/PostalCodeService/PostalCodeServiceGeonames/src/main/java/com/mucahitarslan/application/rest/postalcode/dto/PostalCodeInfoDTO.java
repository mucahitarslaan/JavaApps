package com.mucahitarslan.application.rest.postalcode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;

public class PostalCodeInfoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminName1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adminCode1;
    public String placeName;
    @JsonProperty("lat")
    public double latitude;
    @JsonProperty("lng")
    public double longitude;

    @Override
    public String toString()
    {
        return String.format("%s %s %s %f %f", adminCode1,adminName1,placeName,longitude,latitude);
    }
}
