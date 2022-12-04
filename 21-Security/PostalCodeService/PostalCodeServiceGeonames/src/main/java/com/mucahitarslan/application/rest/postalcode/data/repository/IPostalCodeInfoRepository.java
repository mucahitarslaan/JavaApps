package com.mucahitarslan.application.rest.postalcode.data.repository;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPostalCodeInfoRepository extends CrudRepository<PostalCodeInfo, Long> {

    @Query("select pci from PostalCodeInfo pci where pci.postalCode.postalCode=:postalCodeRequest")
    Iterable<PostalCodeInfo> findPostalCodeInfoByPostalCode(int postalCodeRequest);
}
