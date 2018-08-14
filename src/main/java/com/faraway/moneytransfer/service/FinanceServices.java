package com.faraway.moneytransfer.service;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Money;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public interface FinanceServices {
    boolean transferMoney(Account accFrom, Account accTo, Money money);

    Account getAccountById(int id);
}
