package com.progressoft.examples.currencyexchange.repositories;

import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

    ExchangeRateEntity findByBaseCurrencyAndQuotedCurrency(String baseCurrency, String quotedCurrency);
}
