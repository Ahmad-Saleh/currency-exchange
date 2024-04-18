package com.progressoft.examples.currencyexchange.controllers;

import com.progressoft.examples.currencyexchange.repositories.AuditRepository;
import com.progressoft.examples.currencyexchange.repositories.entities.ExchangeRequestAuditEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuditController {

    private final AuditRepository auditRepository;

    @GetMapping("/audit")
    public List<ExchangeRequestAuditEntity> get(){
        return auditRepository.findAll();
    }
}
