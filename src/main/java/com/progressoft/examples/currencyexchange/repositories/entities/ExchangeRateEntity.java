package com.progressoft.examples.currencyexchange.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String baseCurrency;
    private String quotedCurrency;

    @Column(scale = 3, precision = 6)
    private BigDecimal sellRate;
    @Column(scale = 3, precision = 6)
    private BigDecimal buyRate;
}
