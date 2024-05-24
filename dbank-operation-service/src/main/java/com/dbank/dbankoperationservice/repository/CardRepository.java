package com.dbank.dbankoperationservice.repository;

import com.dbank.dbankoperationservice.entity.Card;

import java.util.Optional;

public interface CardRepository extends AbstractRepository<Card>{

    Optional<Card> findByCardNumber(Long cardNumber);
}
