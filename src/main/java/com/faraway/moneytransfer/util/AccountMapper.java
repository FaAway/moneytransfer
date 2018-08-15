package com.faraway.moneytransfer.util;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
 
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
 
    AccountDto accountAsAccountDto(Account account);

    Account accountDtoAsAccount(AccountDto accountTo);
}