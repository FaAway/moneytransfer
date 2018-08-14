package com.faraway.moneytransfer.service;

import com.faraway.moneytransfer.TestData;
import com.faraway.moneytransfer.model.Account;
import com.faraway.moneytransfer.model.Currency;
import com.faraway.moneytransfer.model.Money;
import com.faraway.moneytransfer.service.impl.FinanceServicesImpl;
import com.ibatis.common.jdbc.ScriptRunner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

/**
 * User: mterentyev
 * Date: 08.08.2018
 */
public class FinanceServicesTest {

    private static Properties properties = new Properties();
    private FinanceServices financeServices;

    @BeforeTest
    public void init() throws ClassNotFoundException, SQLException, IOException {

        initProperties();

        initDatabase();

        populateDatabase();

        initServices();

    }

    @Test
    public void testTransferMoney() throws Exception {
        Account accountFrom = financeServices.getAccountById(TestData.ACCOUNT1_ID);
        Account accountTo = financeServices.getAccountById(TestData.ACCOUNT2_ID);
        BigDecimal accountFromInitBlance = accountFrom.getAmount();
        BigDecimal accountToInitBlance = accountTo.getAmount();
        Currency currency = accountFrom.getCurrency();
        Money money = new Money(BigDecimal.valueOf(500000), currency);
        assert financeServices.transferMoney(accountFrom, accountTo, money);
        assertEquals(accountFromInitBlance.subtract(money.getAmount()), accountFrom.getAmount(),
                "Check sender account balance");
        assertEquals(accountToInitBlance.add(money.getAmount()), accountTo.getAmount(),
                "Check recipient account balance");
    }

    private void initProperties() throws IOException {
        String dbProfile = System.getProperty("db.profile");
        properties.load(FinanceServicesTest.class.getClassLoader().getResourceAsStream("db/" + dbProfile + "db.properties"));
    }

    private static void initDatabase() throws SQLException, IOException {

        // Initialize object for ScripRunner
        ScriptRunner sr = new ScriptRunner(getConnection(), false, false);

        // Give the input file to Reader
        InputStream initScriptStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("db/" + properties.get("jdbc.initScript"));
        Reader reader = new BufferedReader(new InputStreamReader(initScriptStream, StandardCharsets.UTF_8));

        // Exctute script
        sr.runScript(reader);

    }

    private void initServices() {
        financeServices = new FinanceServicesImpl();
    }

    private static void populateDatabase() throws SQLException, IOException {

        // Initialize object for ScripRunner
        ScriptRunner sr = new ScriptRunner(getConnection(), false, false);

        // Give the input file to Reader
        InputStream initScriptStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("db/" + properties.get("jdbc.populateScript"));
        Reader reader = new BufferedReader(new InputStreamReader(initScriptStream, StandardCharsets.UTF_8));

        // Exctute script
        sr.runScript(reader);

    }

    /**
     * Create a connection
     *
     * @return connection object
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                (String) properties.get("database.url"),
                (String) properties.get("database.username"),
                (String) properties.get("database.password")
        );
    }

}