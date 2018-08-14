package com.faraway.moneytransfer.service.impl;

import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Money;
import com.faraway.moneytransfer.model.MoneyTransfer;
import com.faraway.moneytransfer.repository.AccountRepository;
import com.faraway.moneytransfer.repository.MoneyTransferRepository;
import com.faraway.moneytransfer.service.FinanceServices;
import com.faraway.moneytransfer.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class FinanceServicesImpl implements FinanceServices {

    private MoneyTransferRepository moneyTransferRepository;
    private AccountRepository accountRepository;

    @Override
    public boolean transferMoney(Account sender, Account recipient, Money money) {

        // TODO: currency converter
        if (!sender.getCurrency().equals(recipient.getCurrency()) || !sender.getCurrency().equals(money.getCurrency())) {
            throw new UnsupportedOperationException("Currency converter is not supported yet");
        }
        // TODO: currency converter
        MoneyTransfer moneyTransfer = new MoneyTransfer(sender, recipient, money.getAmount(), money.getAmount());
        sender.setAmount(sender.getAmount().subtract(moneyTransfer.getSourceCurrencyUnits()));
        recipient.setAmount(recipient.getAmount().add(moneyTransfer.getTargetCurrencyUnits()));

        EntityManager em = HibernateUtil.getEm();
        em.getTransaction().begin();
        moneyTransferRepository.save(moneyTransfer);
        accountRepository.save(sender);
        accountRepository.save(recipient);
        em.getTransaction().commit();
        return true;
    }
}
