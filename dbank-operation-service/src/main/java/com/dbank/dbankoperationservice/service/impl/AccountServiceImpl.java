package com.dbank.dbankoperationservice.service.impl;

import com.dbank.dbankoperationservice.dto.request.ChangeAccountStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.entity.Account;
import com.dbank.dbankoperationservice.exception.UserAccountNotFoundException;
import com.dbank.dbankoperationservice.repository.AccountRepository;
import com.dbank.dbankoperationservice.service.AccountService;
import com.dbank.dbankoperationservice.util.AccountUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    final AccountRepository accountRepository;

    final AccountUtils accountUtils;

    @Override
    public List<Account> getAllByUserId(long userId) {
        return accountRepository
                .findAllByUserId(userId);
    }

    @Override
    public Account getById(long accountId) throws UserAccountNotFoundException {
        return accountRepository.findById(accountId)
                .orElseThrow(UserAccountNotFoundException::new);
    }

    @Override
    public Account createNew(long userId, CreateAccountDTO createAccountDTO) {
        List<Account> list = accountRepository.findAllByUserId(userId);
        int orderNumber = list.size();
        Account account = accountUtils.createNewAccount(userId,createAccountDTO, orderNumber);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account changeStatus(long userId, ChangeAccountStatusDTO changeAccountStatusDTO) throws UserAccountNotFoundException {
        Account account = accountRepository.findById(changeAccountStatusDTO.accountId())
                .orElseThrow(UserAccountNotFoundException::new);
        accountRepository.save(account);
        return account;
    }
}
