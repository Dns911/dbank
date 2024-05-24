package com.dbank.dbankoperationservice.service.impl;

import com.dbank.dbankoperationservice.dto.request.ActivateCardDTO;
import com.dbank.dbankoperationservice.dto.request.BlockCardDTO;
import com.dbank.dbankoperationservice.dto.request.ChangeCardStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.dto.request.CreateCardDTO;
import com.dbank.dbankoperationservice.entity.Account;
import com.dbank.dbankoperationservice.entity.Card;
import com.dbank.dbankoperationservice.entity.CardProfile;
import com.dbank.dbankoperationservice.entity.enums.CardStatus;
import com.dbank.dbankoperationservice.exception.CardNotExistException;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;
import com.dbank.dbankoperationservice.repository.AccountRepository;
import com.dbank.dbankoperationservice.repository.CardRepository;
import com.dbank.dbankoperationservice.service.AccountService;
import com.dbank.dbankoperationservice.service.CardProfileService;
import com.dbank.dbankoperationservice.service.CardService;
import com.dbank.dbankoperationservice.util.CardUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final CardProfileService cardProfileService;
    private final CardUtils cardUtils;

    @Transactional
    @Override
    public Card createNewCard(long userId, CreateCardDTO cardDTO) throws EntityNotFoundException {
        Account account = accountRepository.findById(cardDTO.accountId())
                .orElse(accountService.createNew(
                        userId,
                        CreateAccountDTO.builder().currency(cardDTO.currency()).build()));
        CardProfile cardProfile = cardProfileService.getById(cardDTO.cardProfileId());
        Card card = cardUtils.createNewCard(account, cardProfile);
        cardRepository.save(card);
        return card;
    }

    @Transactional
    @Override
    public Card blockCard(long userId, BlockCardDTO cardDTO) throws CardNotExistException {
        Card card = cardRepository.findById(cardDTO.cardId())
                .orElseThrow(CardNotExistException::new);
        if (card.getCardStatus() != CardStatus.BLOCKED) {
            card.setCardStatus(CardStatus.BLOCKED);
            cardRepository.save(card);
        }
        return card;
    }

    @Override
    public Card activateCard(long userId, ActivateCardDTO cardDTO) throws CardNotExistException {
        return cardRepository.findByCardNumber(cardDTO.cardNumber())
                .orElseThrow(CardNotExistException::new);
    }

    @Override
    public Card changeCardStatus(long userId, ChangeCardStatusDTO cardStatusDTO) throws CardNotExistException {
        return null;
    }

    @Override
    public List<Card> getAllCards(long userId) {
        return accountService.getAllByUserId(userId).stream()
                .flatMap(ac -> ac.getCards().stream()).toList();
    }
}
