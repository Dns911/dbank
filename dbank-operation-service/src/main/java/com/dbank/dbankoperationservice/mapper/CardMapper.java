package com.dbank.dbankoperationservice.mapper;

import com.dbank.dbankoperationservice.dto.response.CardResponseDTO;
import com.dbank.dbankoperationservice.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CardMapper {
    @Mapping(target="accountNumber", expression = "java(card.getAccount().getAccountNumber())")
    @Mapping(target="currency", expression = "java(card.getAccount().getCurrency())")
    @Mapping(target="balance", expression = "java(card.getAccount().getBalance())")
    @Mapping(target="cardProfileName", expression = "java(card.getCardProfile().getProfileName())")
    CardResponseDTO mapTo(Card card);
}
