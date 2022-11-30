package com.mucahitarslan.application.rest.postalcodes.runner;

import com.mucahitarslan.application.rest.postalcodes.geonames.dto.PostalCodeInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeonamesRestRunner implements ApplicationRunner {

    private final RestTemplate restTemplate;

    public GeonamesRestRunner(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${geonames.url}")
    private String uri;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var urlStr = String.format(uri,34387);

        restTemplate.getForObject(urlStr, PostalCodeInfo.class).getPostalcodes().forEach(System.out::println);
    }
}
