package com.progressoft.examples.currencyexchange.services.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class ExchangeRequest {

    private Currency baseCurrency;
    private Currency quotedCurrency;
    private ExchangeType exchangeType;
    private BigDecimal amount;
}
