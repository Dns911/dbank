package com.dbank.dbankoperationservice.dto.response;

import com.dbank.dbankoperationservice.entity.enums.AccountStatus;
import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AccountResponseDTO(
        long accountNumber,
        BigDecimal balance,
        LocalDateTime createdAt,
        CurrencyType currency,
        AccountStatus accountStatus) {

}
