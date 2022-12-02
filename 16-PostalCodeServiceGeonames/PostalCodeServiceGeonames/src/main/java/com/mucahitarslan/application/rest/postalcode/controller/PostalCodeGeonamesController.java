package com.mucahitarslan.application.rest.postalcode.controller;

import com.mucahitarslan.application.rest.postalcode.dto.PostalCodeInfoDTO;
import com.mucahitarslan.application.rest.postalcode.service.PostalCodeAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/postalcodes")
public class PostalCodeGeonamesController {
    private final PostalCodeAppService postalCodeAppService;

    public PostalCodeGeonamesController(PostalCodeAppService postalCodeAppService) {
        this.postalCodeAppService = postalCodeAppService;
    }

    @GetMapping("postalcode")
    public List<PostalCodeInfoDTO> findPostalCodeInfoByPostalCode(@RequestParam("code") int postalCode)
    {
        return postalCodeAppService.findPostalCodeInfoByPostalCode(postalCode);
    }
}
