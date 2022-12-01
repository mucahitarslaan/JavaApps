package com.mucahitarslan.application.rest.postalcode.geonames.json.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PostalCodeInfoJSON {
    @JsonProperty("postalcodes")
    public final List<PostalCodeJSON> postalCodesJSONS = new ArrayList<>();
    public StatusJSON statusJSON;
}
