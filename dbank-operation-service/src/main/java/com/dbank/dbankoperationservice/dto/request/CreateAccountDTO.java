package com.dbank.dbankoperationservice.dto.request;

import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import lombok.Builder;

@Builder
public record CreateAccountDTO(
        CurrencyType currency) {

}
