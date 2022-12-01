package com.mucahitarslan.application.rest.postalcode.runner;

import com.mucahitarslan.application.rest.postalcode.geonames.json.dto.PostalCodeDTO;
import com.mucahitarslan.application.rest.postalcode.service.PostalCodeAppService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

//@Component
public class GeonamesRestRunner implements ApplicationRunner {

    private final PostalCodeAppService postalCodeAppService;

    public GeonamesRestRunner(PostalCodeAppService postalCodeAppService) {
        this.postalCodeAppService = postalCodeAppService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<PostalCodeDTO> pCode = postalCodeAppService.findPostalCodeInfoByPostalCode("");

        if (!pCode.isEmpty())
            pCode.forEach(System.out::println);
    }
}