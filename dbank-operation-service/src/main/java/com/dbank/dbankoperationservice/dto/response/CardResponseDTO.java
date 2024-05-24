package com.dbank.dbankoperationservice.dto.response;

import com.dbank.dbankoperationservice.entity.enums.CardStatus;
import com.dbank.dbankoperationservice.entity.enums.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CardResponseDTO(
        long cardNumber,
        long accountNumber,
        BigDecimal balance,
        CurrencyType currency,
        LocalDateTime expireDate,
        CardStatus cardStatus,
        String cardProfileName) {
}
