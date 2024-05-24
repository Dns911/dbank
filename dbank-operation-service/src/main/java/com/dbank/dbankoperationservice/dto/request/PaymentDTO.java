package com.dbank.dbankoperationservice.dto.request;

public record PaymentDTO(
        long cardId,
        long recipientAccountNumber,
        String recipientDetails,
        double amount,
        String currency,
        double accountAmount,
        String accountCurrency
) {
}
