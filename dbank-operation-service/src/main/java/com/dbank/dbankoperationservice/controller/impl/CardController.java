package com.dbank.dbankoperationservice.controller.impl;

import com.dbank.dbankoperationservice.controller.CardControllerDoc;
import com.dbank.dbankoperationservice.dto.request.ActivateCardDTO;
import com.dbank.dbankoperationservice.dto.request.BlockCardDTO;
import com.dbank.dbankoperationservice.dto.request.ChangeCardStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateCardDTO;
import com.dbank.dbankoperationservice.dto.response.CardResponseDTO;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;
import com.dbank.dbankoperationservice.exception.UserNotFoundException;
import com.dbank.dbankoperationservice.mapper.CardMapper;
import com.dbank.dbankoperationservice.service.CardService;
import com.dbank.dbankoperationservice.service.UserCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/{userId}/cards")
@RequiredArgsConstructor
public class CardController implements CardControllerDoc {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final UserCheckService userCheckService;
    @Override
    @PostMapping("/new")
    public CardResponseDTO createNewCard(
            @PathVariable long userId,
            @RequestBody CreateCardDTO cardDTO) throws EntityNotFoundException{
        return cardMapper.mapTo(cardService.createNewCard(userId, cardDTO));
    }

    @Override
    @PostMapping("/block")
    public CardResponseDTO blockCard(
            @PathVariable long userId,
            @RequestBody BlockCardDTO cardDTO) throws EntityNotFoundException {
        userCheckService.check(userId);
        return cardMapper.mapTo(cardService.blockCard(userId, cardDTO));
    }

    @Override
    @PostMapping("/activate")
    public CardResponseDTO activateCard(
            @PathVariable long userId,
            @RequestBody ActivateCardDTO cardDTO) throws EntityNotFoundException {
        userCheckService.check(userId);
        return cardMapper.mapTo(cardService.activateCard(userId, cardDTO));
    }

    @Override
    @PostMapping("/change-status")
    public CardResponseDTO changeStatusCard(
            @PathVariable long userId,
            @RequestBody ChangeCardStatusDTO cardStatusDTO) throws EntityNotFoundException {
        userCheckService.check(userId);
        return cardMapper.mapTo(cardService.changeCardStatus(userId, cardStatusDTO));
    }

    @Override
    @GetMapping
    public List<CardResponseDTO> getAllUserCards(@PathVariable long userId) throws UserNotFoundException {
        userCheckService.check(userId);
        return cardService.getAllCards(userId).stream()
                .map(cardMapper::mapTo).toList();
    }
}
