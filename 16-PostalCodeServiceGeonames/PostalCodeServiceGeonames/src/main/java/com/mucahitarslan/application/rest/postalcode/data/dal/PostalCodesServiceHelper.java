package com.mucahitarslan.application.rest.postalcode.data.dal;

import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCode;
import com.mucahitarslan.application.rest.postalcode.data.entity.PostalCodeInfo;
import com.mucahitarslan.application.rest.postalcode.data.repository.IPostalCodeInfoRepository;
import com.mucahitarslan.application.rest.postalcode.data.repository.IPostalCodeRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;
@Component
public class PostalCodesServiceHelper {
    private final IPostalCodeRepository postalCodeRepository;
    private final IPostalCodeInfoRepository postalCodeInfoRepository;

    public PostalCodesServiceHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository) {
        this.postalCodeRepository = postalCodeRepository;
        this.postalCodeInfoRepository = postalCodeInfoRepository;
    }

    public boolean existsByPostalCodeById(int postalCode)
    {
        return doWorkForRepository(() -> postalCodeRepository.existsById(postalCode), "PostalCodesServiceHelper.existsByPostalCodeById");
    }

    public Iterable<PostalCodeInfo> findPostalCodeInfoByPostalCode(String postalCode)
    {
        return doWorkForRepository(() -> postalCodeInfoRepository.findByPostalCode(postalCode),"PostalCodesServiceHelper.findPostalCodeInfoByPostalCode");
    }

    public PostalCode savePostalCode(PostalCode postalCode)
    {
        return doWorkForRepository(() -> postalCodeRepository.save(postalCode),"PostalCodesServiceHelper.savePostalCode");
    }

    public PostalCodeInfo savePostalCodeInfo(PostalCodeInfo postalCodeInfo)
    {
        return doWorkForRepository(() -> postalCodeInfoRepository.save(postalCodeInfo),"PostalCodesServiceHelper.savePostalCodeInfo");
    }

    public void saveDatas(PostalCode postalCode)
    {
        postalCodeRepository.save(postalCode);
    }
}
