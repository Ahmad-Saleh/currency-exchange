package com.progressoft.examples.currencyexchange.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ExchangeRequestAuditEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String baseCurrency;
    private String quotedCurrency;
    private String exchangeType;
    private LocalDateTime requestTime;
    private String internalReference;
}
