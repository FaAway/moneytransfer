package com.faraway.moneytransfer.service;

import com.faraway.moneytransfer.TestData;
import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Currency;
import com.faraway.moneytransfer.model.Money;
import com.faraway.moneytransfer.service.impl.FinanceServiceImpl;
import com.faraway.moneytransfer.util.DBUtil;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

/**
 * User: mterentyev
 * Date: 08.08.2018
 */
public class FinanceServiceTest {

    private FinanceService financeService;

    @BeforeTest
    public void init() throws ClassNotFoundException, SQLException, IOException {

        Properties properties = DBUtil.initDBProperties();

        DBUtil.initDatabase(properties);

        DBUtil.populateDatabase(properties);

        initServices();

    }

    @Test
    public void testTransferMoney() throws Exception {
        Account accountFrom = financeService.getAccountById(TestData.ACCOUNT1_ID);
        Account accountTo = financeService.getAccountById(TestData.ACCOUNT2_ID);
        BigDecimal accountFromInitBlance = accountFrom.getAmount();
        BigDecimal accountToInitBlance = accountTo.getAmount();
        Currency currency = accountFrom.getCurrency();
        Money money = new Money(BigDecimal.valueOf(500000), currency);

        assert financeService.transferMoney(accountFrom, accountTo, money);

        accountFrom = financeService.getAccountById(TestData.ACCOUNT1_ID);
        assertEquals(accountFromInitBlance.subtract(money.getAmount()), accountFrom.getAmount(),
                "Check sender account balance");
        accountTo = financeService.getAccountById(TestData.ACCOUNT2_ID);
        assertEquals(accountToInitBlance.add(money.getAmount()), accountTo.getAmount(),
                "Check recipient account balance");
    }

    private void initServices() {
        financeService = new FinanceServiceImpl();
    }

}