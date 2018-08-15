package com.faraway.moneytransfer.util;

import com.faraway.moneytransfer.dto.MoneyDto;
import com.faraway.moneytransfer.model.Money;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MoneyMapper {
 
    MoneyMapper INSTANCE = Mappers.getMapper(MoneyMapper.class);
 
    MoneyDto moneyAsMoneyDto(Money account);

    Money moneyDtoAsMoney(MoneyDto accountTo);
}