package com.mucahitarslan.application.rest.postalcode.geonames.json.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PostalCodeInfoDTO {

    @JsonProperty("postalcodes")
    public final List<PostalCodeDTO> postalCodes = new ArrayList<>();
    public StatusDTO status;
}
