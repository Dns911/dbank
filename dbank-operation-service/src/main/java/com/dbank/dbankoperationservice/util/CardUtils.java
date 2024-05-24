package com.dbank.dbankoperationservice.util;

import com.dbank.dbankoperationservice.entity.Account;
import com.dbank.dbankoperationservice.entity.Card;
import com.dbank.dbankoperationservice.entity.CardProfile;
import com.dbank.dbankoperationservice.entity.enums.CardStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class CardUtils {

    private final Random random = new Random();

    public Card createNewCard(Account account, CardProfile cardProfile) {

        long cardNumber = generateNumber(cardProfile, account);
        LocalDate expireDate = LocalDate.now().plusMonths(cardProfile.getValidPeriod());
        LocalDateTime expiredDateTime = LocalDateTime.of(
                expireDate.getYear(),
                expireDate.getMonth().plus(1),
                1,
                0, 0).minusSeconds(1);
        return Card.builder()
                .account(account)
                .cardStatus(CardStatus.NOT_ACTIVE)
                .cardProfile(cardProfile)
                .cardNumber(cardNumber)
                .expireDate(expiredDateTime)
                .build();
    }

    private long generateNumber(CardProfile cardProfile, Account account) {
        long number = 1000_0000_0000_0000L;
        number = cardProfile.getProfileName().contains("VISA") ?
                number * 4 : number * 5;
        number += 345_0000_0000_0000L;
        number += 1_0000_0000L * (account.getUserId() % 10000);
        for (int i = 0; i <= 7; i++) {
            number += (long) (random.nextInt(0, 10) * Math.pow(10, i));
        }
        return number;
    }
}
