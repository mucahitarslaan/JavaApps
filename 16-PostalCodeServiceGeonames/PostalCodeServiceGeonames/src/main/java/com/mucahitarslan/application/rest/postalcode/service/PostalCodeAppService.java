package com.mucahitarslan.application.rest.postalcode.service;

import com.mucahitarslan.application.rest.postalcode.data.dal.PostalCodesServiceHelper;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeDTO;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.mapper.IPostalCodeInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostalCodeAppService {
    private final PostalCodesServiceHelper postalCodesServiceHelper;
    private final IPostalCodeInfoMapper postalCodeInfoMapper;
    private final RestTemplate restTemplate;


    public PostalCodeAppService(PostalCodesServiceHelper postalCodesServiceHelper, IPostalCodeInfoMapper postalCodeInfoMapper, RestTemplate restTemplate) {
        this.postalCodesServiceHelper = postalCodesServiceHelper;
        this.postalCodeInfoMapper = postalCodeInfoMapper;
        this.restTemplate = restTemplate;
    }

    @Value("${geonames.url}")
    private String urlTemplete;

    public List<PostalCodeDTO> findPostalCodeInfoByPostalCode(String postalCode)
    {
        String url = String.format(urlTemplete,postalCode);

        PostalCodeDTO list = RestTemplate.getForObject(url, PostalCodeDTO.class);

        return
    }

    public void saveDatas(com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode postalCode)
    {
        postalCodesServiceHelper.savePostalCode(postalCode);
    }
}
