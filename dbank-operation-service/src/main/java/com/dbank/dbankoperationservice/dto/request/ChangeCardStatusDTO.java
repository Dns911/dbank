package com.dbank.dbankoperationservice.dto.request;

import com.dbank.dbankoperationservice.entity.enums.CardStatus;

public record ChangeCardStatusDTO(long cardId, CardStatus status) {
}
