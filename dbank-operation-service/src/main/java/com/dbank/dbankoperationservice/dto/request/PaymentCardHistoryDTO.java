package com.dbank.dbankoperationservice.dto.request;

import java.time.LocalDateTime;

public record PaymentCardHistoryDTO(
        long cardId,
        LocalDateTime from,
        LocalDateTime to,
        double amountFrom,
        double amountTo
) {
}
