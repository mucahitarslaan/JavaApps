package com.mucahitarslan.application.rest.postalcode.service;

import com.mucahitarslan.application.rest.postalcode.data.dal.PostalCodeServiceHelper;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeInfoJSON;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeJSON;
import com.mucahitarslan.application.rest.postalcode.mapper.IPostalCodeInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostalCodeAppService {
    private final PostalCodeServiceHelper postalCodeServiceHelper;
    private final RestTemplate restTemplate;
    private final IPostalCodeInfoMapper postalCodeInfoMapper;

    public PostalCodeAppService(PostalCodeServiceHelper postalCodeServiceHelper, RestTemplate restTemplate, IPostalCodeInfoMapper postalCodeInfoMapper) {
        this.postalCodeServiceHelper = postalCodeServiceHelper;
        this.restTemplate = restTemplate;
        this.postalCodeInfoMapper = postalCodeInfoMapper;
    }

    @Value("${geonames.url}")
    private String urlTemplete;

    public List<PostalCodeJSON> findPostalCodeInfoByPostalCode(int postalCode)
    {
        String url = String.format(urlTemplete,postalCode);

        return restTemplate.getForObject(url, PostalCodeInfoJSON.class).postalCodesJSONS;
    }
}
