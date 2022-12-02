package com.mucahitarslan.application.rest.postalcode.service;

import com.mucahitarslan.application.rest.postalcode.data.dal.PostalCodeServiceHelper;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeGeoNames;
import com.mucahitarslan.application.rest.postalcode.mapper.IPostalCodeMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostalCodeAppService {
    private final PostalCodeServiceHelper postalCodeServiceHelper;
    private final RestTemplate restTemplate;
    private final IPostalCodeMapper postalCodeMapper;

    public PostalCodeAppService(PostalCodeServiceHelper postalCodeServiceHelper, RestTemplate restTemplate, IPostalCodeMapper postalCodeMapper) {
        this.postalCodeServiceHelper = postalCodeServiceHelper;
        this.restTemplate = restTemplate;
        this.postalCodeMapper = postalCodeMapper;
    }

    public void getAndSavePostalCodeForEachCallback(PostalCodeInfo postalCodeInfo,PostalCode postalCode)
    {
        postalCodeInfo.postalCode = postalCode;
        postalCodeServiceHelper.savePostalCodeInfo(postalCodeInfo);
    }
    public List<PostalCodeInfoDTO> getAndSavePostalCodes(int postalCode)
    {
        String url = String.format(urlTemplete, postalCode);
        var postalCodes = Objects.requireNonNull(restTemplate.getForObject(url, PostalCodeGeoNames.class))
                .postalCodeGeoNames;
        var pc = postalCodeServiceHelper.savePostalCode(new PostalCode(postalCode));

        postalCodes.stream().map(postalCodeMapper::toPostalCodeInfo)
                .forEach(pci -> getAndSavePostalCodeForEachCallback(pci,pc));

        return postalCodes.stream().map(postalCodeMapper::toPostalCodeInfoDTO).collect(Collectors.toList());
    }

    public List<PostalCodeInfoDTO> getPostalCodes(int postalCode)
    {
        return StreamSupport.stream(postalCodeServiceHelper.findPostalCodeInfoByPostalCode(postalCode).spliterator(),false)
                .map(postalCodeMapper::toPostalCodeInfoDTO).collect(Collectors.toList());
    }

    @Value("${geonames.url}")
    private String urlTemplete;

    public List<PostalCodeInfoDTO> findPostalCodeInfoByPostalCode(int postalCode)
    {
        return postalCodeServiceHelper.existsPostalCodeById(postalCode) ? getPostalCodes(postalCode)
                : getAndSavePostalCodes(postalCode);
    }
}
