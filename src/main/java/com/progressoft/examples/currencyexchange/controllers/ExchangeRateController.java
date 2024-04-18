package com.progressoft.examples.currencyexchange.controllers;

import com.progressoft.examples.currencyexchange.services.ExchangeRateService;
import com.progressoft.examples.currencyexchange.services.model.ExchangeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @PostMapping("/api/v1/calculate-exchange-rate")
    public String calculateExchangeRate(@RequestBody ExchangeRequest exchangeRequest){
        return exchangeRateService.getExchangeRate(exchangeRequest).toString();
    }
}
