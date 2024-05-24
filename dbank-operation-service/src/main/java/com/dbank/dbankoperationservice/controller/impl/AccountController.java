package com.dbank.dbankoperationservice.controller.impl;

import com.dbank.dbankoperationservice.controller.AccountControllerDoc;
import com.dbank.dbankoperationservice.dto.request.ChangeAccountStatusDTO;
import com.dbank.dbankoperationservice.dto.request.CreateAccountDTO;
import com.dbank.dbankoperationservice.dto.response.AccountResponseDTO;
import com.dbank.dbankoperationservice.exception.EntityNotFoundException;
import com.dbank.dbankoperationservice.exception.UserNotFoundException;
import com.dbank.dbankoperationservice.mapper.AccountMapper;
import com.dbank.dbankoperationservice.service.AccountService;
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
@RequestMapping("/{userId}/accounts")
@RequiredArgsConstructor
public class AccountController implements AccountControllerDoc {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final UserCheckService userCheckService;

    @Override
    @GetMapping
    public List<AccountResponseDTO> getUserAccounts(@PathVariable long userId) throws UserNotFoundException {
        userCheckService.check(userId);
        return accountService.getAllByUserId(userId).stream()
                .map(accountMapper::mapTo).toList();
    }

    @Override
    @PostMapping("/new")
    public AccountResponseDTO createNewUserAccount(
            @PathVariable long userId,
            @RequestBody CreateAccountDTO createAccountDTO) {
        return accountMapper.mapTo(accountService.createNew(userId, createAccountDTO));
    }

    @Override
    @PostMapping("/update")
    public AccountResponseDTO changeUserAccountStatus(
            @PathVariable long userId,
            @RequestBody ChangeAccountStatusDTO changeAccountStatusDTO) throws EntityNotFoundException {
        userCheckService.check(userId);
        return accountMapper.mapTo(accountService.changeStatus(userId, changeAccountStatusDTO));
    }
}
