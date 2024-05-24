package com.dbank.dbankoperationservice.service;

import com.dbank.dbankoperationservice.dto.request.ActivateCardDTO;
import com.dbank.dbankoperationservice.dto.request.BlockCardDTO;
import com.dbank.dbankoperationservice.dto.request.ChangeCardStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateCardDTO;
import com.dbank.dbankoperationservice.entity.Card;
import com.dbank.dbankoperationservice.exception.CardNotExistException;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;

import java.util.List;

public interface CardService {

    Card createNewCard(long userId, CreateCardDTO cardDTO) throws EntityNotFoundException;

    Card blockCard(long userId, BlockCardDTO cardDTO) throws CardNotExistException;

    Card activateCard(long userId, ActivateCardDTO cardDTO) throws CardNotExistException;

    Card changeCardStatus(long userId, ChangeCardStatusDTO cardStatusDTO) throws CardNotExistException;

    List<Card> getAllCards(long userId);
}
