package com.dbank.dbankoperationservice.repository;

import com.dbank.dbankoperationservice.entity.Account;

import java.util.List;

public interface AccountRepository extends AbstractRepository<Account>{
    List<Account> findAllByUserId(Long userId);
}
