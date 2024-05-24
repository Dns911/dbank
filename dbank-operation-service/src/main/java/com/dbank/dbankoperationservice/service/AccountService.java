package com.dbank.dbankoperationservice.service;

import com.dbank.dbankoperationservice.dto.request.ChangeAccountStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.entity.Account;
import com.dbank.dbankoperationservice.exception.UserAccountNotFoundException;

import java.util.List;

public interface AccountService {
    List<Account> getAllByUserId(long userId);

    Account getById(long accountId) throws UserAccountNotFoundException;

    Account createNew(long userId, CreateAccountDTO createAccountDTO);

    Account changeStatus(long userId, ChangeAccountStatusDTO changeAccountStatusDTO) throws UserAccountNotFoundException;
}
