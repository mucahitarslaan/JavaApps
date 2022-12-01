package com.mucahitarslan.application.rest.postalcode.data.repository;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.springframework.data.repository.CrudRepository;

public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, Long> {

    Iterable<PostalCodeInfo> findPostalCodeInfoByPostalCode(int postalCodeRequest);
}
