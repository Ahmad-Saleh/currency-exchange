package com.progressoft.examples.currencyexchange;

import com.progressoft.examples.currencyexchange.repositories.ExchangeRateRepository;
import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRateEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class CurrencyExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initExchangeRates(ExchangeRateRepository exchangeRateRepository) {
        return args -> {
            if (exchangeRateRepository.count() == 0) {
                exchangeRateRepository.save(ExchangeRateEntity.builder()
                        .baseCurrency("USD")
                        .quotedCurrency("JOD")
                        .buyRate(new BigDecimal("0.7080"))
                        .sellRate(new BigDecimal("0.7090"))
                        .build());

                exchangeRateRepository.save(ExchangeRateEntity.builder()
                        .baseCurrency("AED")
                        .quotedCurrency("JOD")
                        .buyRate(new BigDecimal("0.19255"))
                        .sellRate(new BigDecimal("0.1930"))
                        .build());

                exchangeRateRepository.save(ExchangeRateEntity.builder()
                        .baseCurrency("OMR")
                        .quotedCurrency("JOD")
                        .buyRate(new BigDecimal("1.8340"))
                        .sellRate(new BigDecimal("1.8450"))
                        .build());
            }
        };
    }
}
