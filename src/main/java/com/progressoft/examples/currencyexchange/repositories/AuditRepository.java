package com.progressoft.examples.currencyexchange.repositories;

import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRequestAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<ExchangeRequestAuditEntity, Long> {
}
