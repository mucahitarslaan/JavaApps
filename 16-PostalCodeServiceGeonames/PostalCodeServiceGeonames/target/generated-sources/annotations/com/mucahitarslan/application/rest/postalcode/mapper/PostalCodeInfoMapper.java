package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-01T18:05:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class PostalCodeInfoMapper implements IPostalCodeInfoMapper {

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
}
