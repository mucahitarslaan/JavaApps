package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-01T05:28:46+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class PostalCodeMapper implements IPostalCodeMapper {

    @Override
    public PostalCodeDTO toPostalCodeInfoDTO(PostalCode postalCodeInfo) {
        if ( postalCodeInfo == null ) {
            return null;
        }

        PostalCodeDTO postalCodeDTO = new PostalCodeDTO();

        return postalCodeDTO;
    }

    @Override
    public PostalCode toPostalCodeInfo(PostalCodeDTO postalCodeInfoDTO) {
        if ( postalCodeInfoDTO == null ) {
            return null;
        }

        PostalCode postalCode = new PostalCode();

        return postalCode;
    }
}
