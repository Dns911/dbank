package com.dbank.dbankoperationservice.dto.request;

import com.dbank.dbankoperationservice.entity.enums.CurrencyType;

public record CreateCardDTO(
        long cardProfileId,
        long accountId,
        CurrencyType currency

) {
}
