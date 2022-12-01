package com.mucahitarslan.application.rest.postalcode.runner;

import com.mucahitarslan.application.rest.postalcode.service.PostalCodeAppService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GeonamesResRunner implements ApplicationRunner {
    private final PostalCodeAppService postalCodeAppService;

    public GeonamesResRunner(PostalCodeAppService postalCodeAppService) {
        this.postalCodeAppService = postalCodeAppService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        var pc = postalCodeAppService.findPostalCodeInfoByPostalCode(34387);

        if (!pc.isEmpty())
        {
            pc.forEach(System.out::println);
        }
    }
}
