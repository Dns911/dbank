package com.dbank.dbankoperationservice.controller;

import com.dbank.dbankoperationservice.dto.request.ChangeAccountStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.dto.response.AccountResponseDTO;
import com.dbank.dbankoperationservice.exception.UserNotFoundException;

import java.util.List;

public interface AccountControllerDoc {

    List<AccountResponseDTO> getUserAccounts(long userId) throws UserNotFoundException;
    AccountResponseDTO createNewUserAccount(long userId, CreateAccountDTO createAccountDTO);
    AccountResponseDTO changeUserAccountStatus(long userId, ChangeAccountStatusDTO changeAccountStatusDTO) throws Exception;

}
