package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeInfoGeoNames;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeMapper", componentModel = "spring")
public interface IPostalCodeMapper {
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfo postalCodeInfo);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoDTO postalCodeInfoDTO);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoGeoNames postalCodeInfoGeoNames);
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfoGeoNames postalCodeGeoNames);
}
