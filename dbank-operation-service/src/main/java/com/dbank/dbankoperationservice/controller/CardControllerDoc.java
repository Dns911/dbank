package com.dbank.dbankoperationservice.controller;

import com.dbank.dbankoperationservice.dto.request.ActivateCardDTO;
import com.dbank.dbankoperationservice.dto.request.BlockCardDTO;
import com.dbank.dbankoperationservice.dto.request.ChangeCardStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateCardDTO;
import com.dbank.dbankoperationservice.dto.response.CardResponseDTO;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;
import com.dbank.dbankoperationservice.exception.UserNotFoundException;

import java.util.List;

public interface CardControllerDoc {

    CardResponseDTO createNewCard(long userId, CreateCardDTO cardDTO) throws EntityNotFoundException;
    CardResponseDTO blockCard(long userId, BlockCardDTO cardDTO) throws EntityNotFoundException;
    CardResponseDTO activateCard(long userId, ActivateCardDTO cardDTO) throws EntityNotFoundException;
    CardResponseDTO changeStatusCard(long userId, ChangeCardStatusDTO cardStatusDTO) throws EntityNotFoundException;
    List<CardResponseDTO> getAllUserCards(long userId) throws UserNotFoundException;
}
