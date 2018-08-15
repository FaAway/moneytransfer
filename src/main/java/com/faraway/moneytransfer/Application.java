package com.faraway.moneytransfer;

import com.faraway.moneytransfer.resource.ResourceFactory;
import com.faraway.moneytransfer.util.DBUtil;
import com.faraway.moneytransfer.util.EmbeddedServer;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * User: mterentyev
 * Date: 13.08.2018
 */
public class Application {
    public static void main(final String[] args) throws ServletException, ClassNotFoundException, IOException, SQLException {

        Properties properties = DBUtil.initDBProperties();

        DBUtil.initDatabase(properties);

        DBUtil.populateDatabase(properties);

        new EmbeddedServer("0.0.0.0", 8080)
                .contextPath("/money-transfer")
                .deploymentName("money-transfer")
                .appPath("/api")
                .resourcesClass(ResourceFactory.class)
                .start();
    }
}
