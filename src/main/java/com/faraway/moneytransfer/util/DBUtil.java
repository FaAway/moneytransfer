package com.faraway.moneytransfer.util;

import com.ibatis.common.jdbc.ScriptRunner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class DBUtil {

    public static void initDatabase(Properties dbProperties) throws SQLException, IOException {

        // Initialize object for ScripRunner
        ScriptRunner sr = new ScriptRunner(getConnection(dbProperties), false, false);

        // Give the input file dto Reader
        InputStream initScriptStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("db/" + dbProperties.get("jdbc.initScript"));
        Reader reader = new BufferedReader(new InputStreamReader(initScriptStream, StandardCharsets.UTF_8));

        // Exctute script
        sr.runScript(reader);

    }

    public static void populateDatabase(Properties dbProperties) throws SQLException, IOException {

        // Initialize object for ScripRunner
        ScriptRunner sr = new ScriptRunner(getConnection(dbProperties), false, false);

        // Give the input file dto Reader
        InputStream initScriptStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("db/" + dbProperties.get("jdbc.populateScript"));
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
    private static Connection getConnection(Properties dbProperties) throws SQLException {
        return DriverManager.getConnection(
                (String) dbProperties.get("database.url"),
                (String) dbProperties.get("database.username"),
                (String) dbProperties.get("database.password")
        );
    }

    public static Properties initDBProperties() throws IOException {
        String dbProfile = System.getProperty("db.profile") != null
                ? System.getProperty("db.profile")
                : "hsql";
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db/" + dbProfile + "db.properties"));
        return properties;
    }
}
