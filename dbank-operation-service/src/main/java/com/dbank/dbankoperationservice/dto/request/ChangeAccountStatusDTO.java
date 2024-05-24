package com.dbank.dbankoperationservice.dto.request;

import com.dbank.dbankoperationservice.entity.enums.AccountStatus;


public record ChangeAccountStatusDTO(
        long accountId,
        AccountStatus accountStatus) {
}
