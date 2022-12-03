package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeInfoGeoNames;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T03:17:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class PostalCodeMapper implements IPostalCodeMapper {

    @Override
    public PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfo postalCodeInfo) {
        if ( postalCodeInfo == null ) {
            return null;
        }

        PostalCodeInfoDTO postalCodeInfoDTO = new PostalCodeInfoDTO();

        postalCodeInfoDTO.adminName1 = postalCodeInfo.adminName1;
        postalCodeInfoDTO.adminCode1 = postalCodeInfo.adminCode1;
        postalCodeInfoDTO.placeName = postalCodeInfo.placeName;
        postalCodeInfoDTO.latitude = postalCodeInfo.latitude;
        postalCodeInfoDTO.longitude = postalCodeInfo.longitude;

        return postalCodeInfoDTO;
    }

    @Override
    public PostalCodeInfo toPostalCodeInfo(PostalCodeInfoDTO postalCodeInfoDTO) {
        if ( postalCodeInfoDTO == null ) {
            return null;
        }

        PostalCodeInfo postalCodeInfo = new PostalCodeInfo();

        postalCodeInfo.adminName1 = postalCodeInfoDTO.adminName1;
        postalCodeInfo.adminCode1 = postalCodeInfoDTO.adminCode1;
        postalCodeInfo.placeName = postalCodeInfoDTO.placeName;
        postalCodeInfo.latitude = postalCodeInfoDTO.latitude;
        postalCodeInfo.longitude = postalCodeInfoDTO.longitude;

        return postalCodeInfo;
    }

    @Override
    public PostalCodeInfo toPostalCodeInfo(PostalCodeInfoGeoNames postalCodeInfoGeoNames) {
        if ( postalCodeInfoGeoNames == null ) {
            return null;
        }

        PostalCodeInfo postalCodeInfo = new PostalCodeInfo();

        postalCodeInfo.adminName1 = postalCodeInfoGeoNames.adminName1;
        postalCodeInfo.adminCode1 = postalCodeInfoGeoNames.adminCode1;
        postalCodeInfo.placeName = postalCodeInfoGeoNames.placeName;
        postalCodeInfo.latitude = postalCodeInfoGeoNames.latitude;
        postalCodeInfo.longitude = postalCodeInfoGeoNames.longitude;

        return postalCodeInfo;
    }

    @Override
    public PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfoGeoNames postalCodeGeoNames) {
        if ( postalCodeGeoNames == null ) {
            return null;
        }

        PostalCodeInfoDTO postalCodeInfoDTO = new PostalCodeInfoDTO();

        postalCodeInfoDTO.adminName1 = postalCodeGeoNames.adminName1;
        postalCodeInfoDTO.adminCode1 = postalCodeGeoNames.adminCode1;
        postalCodeInfoDTO.placeName = postalCodeGeoNames.placeName;
        postalCodeInfoDTO.latitude = postalCodeGeoNames.latitude;
        postalCodeInfoDTO.longitude = postalCodeGeoNames.longitude;

        return postalCodeInfoDTO;
    }
}
