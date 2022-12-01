package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeMapper", componentModel = "spring")
public interface IPostalCodeMapper {
    PostalCodeDTO toPostalCodeInfoDTO(PostalCode postalCodeInfo);
    PostalCode toPostalCodeInfo(PostalCodeDTO postalCodeInfoDTO);
}
