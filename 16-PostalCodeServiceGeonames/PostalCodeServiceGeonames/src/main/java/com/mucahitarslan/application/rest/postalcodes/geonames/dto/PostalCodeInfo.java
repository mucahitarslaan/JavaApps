package com.mucahitarslan.application.rest.postalcodes.geonames.dto;

import java.util.ArrayList;
import java.util.List;

public class PostalCodeInfo {
    private final List<PostalCode> postalcodes = new ArrayList<>();

    public List<PostalCode> getPostalcodes()
    {
        return postalcodes;
    }
}
