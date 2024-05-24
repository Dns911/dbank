package com.dbank.dbankoperationservice.service.impl;

import com.dbank.dbankoperationservice.entity.CardProfile;
import com.dbank.dbankoperationservice.exception.CardProfileNotFoundException;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;
import com.dbank.dbankoperationservice.repository.CardProfileRepository;
import com.dbank.dbankoperationservice.service.CardProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardProfileServiceImpl implements CardProfileService {
    private final CardProfileRepository cardProfileRepository;

    @Override
    public CardProfile getById(long cardProfileId) throws EntityNotFoundException {
        return cardProfileRepository.findById(cardProfileId)
                .orElseThrow(CardProfileNotFoundException::new);
    }
}
