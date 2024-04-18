package com.progressoft.examples.currencyexchange.services;

import com.progressoft.examples.currencyexchange.mappers.ExchangeRequestMapper;
import com.progressoft.examples.currencyexchange.repositories.AuditRepository;
import com.progressoft.examples.currencyexchange.repositories.ExchangeRateRepository;
import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRateEntity;
import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRequestAuditEntity;
import com.progressoft.examples.currencyexchange.services.exceptions.InvalidRequestException;
import com.progressoft.examples.currencyexchange.services.model.ExchangeRequest;
import com.progressoft.examples.currencyexchange.services.model.ExchangeType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRequestMapper exchangeRequestMapper;
    private final AuditRepository auditRepository;
    private final ExchangeRateRepository exchangeRateRepository;

    @Value("${exchange-rate.audit.enabled}")
    private boolean auditEnabled;

    public BigDecimal calculateExchangeRate(ExchangeRequest exchangeRequest) {
        if(auditEnabled) {
            logUserRequest(exchangeRequest);
        }
        validateRequest(exchangeRequest);
        return doCalculateExchangeRate(exchangeRequest);
    }

    private void validateRequest(ExchangeRequest exchangeRequest) {
        if (exchangeRequest.getBaseCurrency() == null) {
            throw new InvalidRequestException("baseCurrency", "base currency cannot be null");
        }
        if (exchangeRequest.getQuotedCurrency() == null) {
            throw new InvalidRequestException("quotedCurrency", "quoted currency cannot be null");
        }
        if (exchangeRequest.getExchangeType() == null) {
            throw new InvalidRequestException("exchangeType", "exchange type cannot be null");
        }
        if (exchangeRequest.getAmount() == null) {
            throw new InvalidRequestException("amount", "amount cannot be null");
        }
    }

    private void logUserRequest(ExchangeRequest exchangeRequest) {
        ExchangeRequestAuditEntity auditEntity = exchangeRequestMapper.toEntity(exchangeRequest);
        auditEntity.setRequestTime(LocalDateTime.now());
        auditEntity.setInternalReference(UUID.randomUUID().toString());
        auditRepository.save(auditEntity);
    }

    private BigDecimal doCalculateExchangeRate(ExchangeRequest exchangeRequest) {
        ExchangeRateEntity exchangeRate = exchangeRateRepository.findByBaseCurrencyAndQuotedCurrency(
                exchangeRequest.getBaseCurrency().getCurrencyCode(), exchangeRequest.getQuotedCurrency().getCurrencyCode());

        return exchangeRequest.getExchangeType() == ExchangeType.BUY ?
                exchangeRequest.getAmount().multiply(exchangeRate.getBuyRate()) :
                exchangeRequest.getAmount().divide(exchangeRate.getSellRate(), 3, RoundingMode.HALF_UP);
    }
}
