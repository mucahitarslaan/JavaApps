package com.mucahitarslan.application.rest.postalcode.mapper;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Mapper(implementationName = "PostalCodeInfoMapper", componentModel = "spring")
public interface IPostalCodeInfoMapper {
    PostalCodeInfoDTO toPostalCodeInfoDTO(PostalCodeInfo postalCodeInfo);
    PostalCodeInfo toPostalCodeInfo(PostalCodeInfoDTO postalCodeInfoDTO);
}
