package com.faraway.moneytransfer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final String PERSISTENT_UNIT_NAME = "MONEYTRANSFER";

    private static final EntityManagerFactory emf;

    static {
        try {
            // load jdbc driver
            Class.forName("org.hsqldb.jdbcDriver");
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}