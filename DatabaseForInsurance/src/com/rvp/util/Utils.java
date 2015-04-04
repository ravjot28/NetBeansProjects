/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rvp.util;

/**
 *
 * @author Rav
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static final SessionFactory sessionFactory;
    final static Logger logger = LoggerFactory.getLogger(Utils.class);

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            logger.info("Exception in HibernateUtil");
            logger.error(null, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
