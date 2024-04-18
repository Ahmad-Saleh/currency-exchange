package com.progressoft.examples.currencyexchange.mappers;

import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRequestAuditEntity;
import com.progressoft.examples.currencyexchange.services.model.ExchangeRequest;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ExchangeRequestMapper {

    ExchangeRequestAuditEntity toEntity(ExchangeRequest exchangeRequest);
}
