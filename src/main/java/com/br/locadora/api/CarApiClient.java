package com.br.locadora.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "carModelClient", url = "https://cis-automotive.p.rapidapi.com")
public interface CarApiClient {

    @GetMapping("/getModels")
    CarApiResponse getModelosPorMarca(
            @RequestHeader("x-rapidapi-host") String host,
            @RequestHeader("x-rapidapi-key") String apiKey,
            @RequestParam("brandName") String brandName
    );
}
