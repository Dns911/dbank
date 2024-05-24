package com.dbank.dbankoperationservice.mapper;

import com.dbank.dbankoperationservice.dto.response.AccountResponseDTO;
import com.dbank.dbankoperationservice.entity.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    AccountResponseDTO mapTo(Account account);
}