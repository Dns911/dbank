package com.dbank.dbankoperationservice.service.impl;

import com.dbank.dbankoperationservice.exception.UserNotFoundException;
import com.dbank.dbankoperationservice.repository.AccountRepository;
import com.dbank.dbankoperationservice.service.UserCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCheckServiceImpl implements UserCheckService {

    private final AccountRepository accountRepository;
    @Override
    public void check(long userId) throws UserNotFoundException {
        if(accountRepository.findAllByUserId(userId).isEmpty()){
            throw new UserNotFoundException();
        }
    }
}
