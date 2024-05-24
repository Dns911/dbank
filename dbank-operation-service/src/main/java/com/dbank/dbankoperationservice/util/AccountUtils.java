package com.dbank.dbankoperationservice.util;

import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.entity.Account;
import com.dbank.dbankoperationservice.entity.enums.AccountStatus;
import com.dbank.dbankoperationservice.entity.enums.CurrencyType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountUtils {


    public Account createNewAccount(long userId, CreateAccountDTO accountDTO, int orderNumber){

        CurrencyType currency = accountDTO.currency();

        return Account.builder()
                .accountNumber(generateNumber(userId,
                        currency, orderNumber))
                .accountStatus(AccountStatus.ACTIVE)
                .balance(BigDecimal.ZERO)
                .currency(currency)
                .userId(userId)
                .isDefault(orderNumber == 0)
                .build();
    }

    private long generateNumber(long userId, CurrencyType currencyType, int orderNumber){
        return 1_0000_000_00
                + userId % 10_000 * 10_000
                + currencyType.getCurrencyNumber() * 100
                + orderNumber + 1;
    }
}
