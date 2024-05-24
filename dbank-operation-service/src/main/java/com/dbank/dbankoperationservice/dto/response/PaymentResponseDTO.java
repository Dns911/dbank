package com.dbank.dbankoperationservice.dto.response;

import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import com.dbank.dbankoperationservice.entity.enums.PaymentStatus;

import java.time.LocalDateTime;

public record PaymentResponseDTO(
        LocalDateTime paymentDate,
        CurrencyType currency,
        double amount,
        CurrencyType accountCurrency,
        double accountCurrencyAmount,
        long recipientAccountNumber,
        String recipientDetails,
        PaymentStatus paymentStatus,
        String paymentDetails
) {
}
