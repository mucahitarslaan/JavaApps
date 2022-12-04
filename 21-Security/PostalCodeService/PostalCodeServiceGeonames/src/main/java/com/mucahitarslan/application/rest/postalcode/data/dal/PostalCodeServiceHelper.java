package com.mucahitarslan.application.rest.postalcode.data.dal;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.data.repository.IPostalCodeInfoRepository;
import com.mucahitarslan.application.rest.postalcode.data.repository.IPostalCodeRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
@Component
public class PostalCodeServiceHelper {
    private final IPostalCodeRepository postalCodeRepository;
    private final IPostalCodeInfoRepository postalCodeInfoRepository;

    public PostalCodeServiceHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository) {
        this.postalCodeRepository = postalCodeRepository;
        this.postalCodeInfoRepository = postalCodeInfoRepository;
    }

    public boolean existsPostalCodeById(int postalCode)
    {
        return doWorkForRepository(() -> postalCodeRepository.existsById(postalCode),"PostalCodeServiceHelper.existsPostalCodeById");
    }

    public Iterable<PostalCodeInfo> findPostalCodeInfoByPostalCode(int postalCode)
    {
        return doWorkForRepository(() -> postalCodeInfoRepository.findPostalCodeInfoByPostalCode(postalCode), "PostalCodeServiceHelper.findPostalCodeInfoByPostalCode");
    }

    public PostalCode savePostalCode(PostalCode postalCode)
    {
        return doWorkForRepository(() -> postalCodeRepository.save(postalCode),"PostalCodeServiceHelper.savePostalCode");
    }

    public PostalCodeInfo savePostalCodeInfo(PostalCodeInfo postalCodeInfo)
    {
        return doWorkForRepository(() -> postalCodeInfoRepository.save(postalCodeInfo), "PostalCodeServiceHelper.savePostalCodeInfo");
    }
}
