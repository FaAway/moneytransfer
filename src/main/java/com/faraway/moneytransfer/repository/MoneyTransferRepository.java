package com.faraway.moneytransfer.repository;

import com.faraway.moneytransfer.model.MoneyTransfer;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * User: mterentyev
 * Date: 14.08.2018
 */
public interface MoneyTransferRepository {

    MoneyTransfer save(MoneyTransfer moneyTransfer);

    MoneyTransfer get(int id);

    // ORDERED dateTime
    Collection<MoneyTransfer> getAll(int accountId);

    // ORDERED dateTime
    Collection<MoneyTransfer> getBetween(LocalDateTime startDate, LocalDateTime endDate, int accountId);

}
