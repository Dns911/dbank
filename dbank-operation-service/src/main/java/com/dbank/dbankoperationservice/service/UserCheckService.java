package com.dbank.dbankoperationservice.service;

import com.dbank.dbankoperationservice.exception.UserNotFoundException;

public interface UserCheckService {
    void check(long userId) throws UserNotFoundException;
}
