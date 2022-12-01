package com.mucahitarslan.application.rest.postalcode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;

public class PostalCodeInfoDTO {
    private PostalCode postalCode;
    public String adminName1;
    public String adminCode1;
    public String placeName;
    @JsonProperty("lat")
    public double latitude;
    @JsonProperty("lng")
    public double longitude;
}
