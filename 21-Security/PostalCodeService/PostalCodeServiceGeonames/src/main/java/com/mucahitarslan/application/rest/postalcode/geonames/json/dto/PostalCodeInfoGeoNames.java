package com.mucahitarslan.application.rest.postalcode.geonames.json.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PostalCodeInfoGeoNames {
    public String adminName1;
    public String adminCode1;
    public String placeName;
    @JsonProperty("lat")
    public double latitude;
    @JsonProperty("lng")
    public double longitude;
}
