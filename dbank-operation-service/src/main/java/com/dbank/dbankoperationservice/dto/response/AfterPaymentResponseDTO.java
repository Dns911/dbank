package com.dbank.dbankoperationservice.dto.response;

import com.dbank.dbankoperationservice.entity.enums.PaymentStatus;

public record AfterPaymentResponseDTO(long paymentId, PaymentStatus paymentStatus) {
}
