/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static HibernateUtil util = null;
    private static Logger log = Logger.getLogger(HibernateUtil.class);
    private SessionFactory sessionFactory = null;
    private final ThreadLocal<Session> sessions = new ThreadLocal<>();
    private final ThreadLocal<Transaction> transactions = new ThreadLocal<>();

    private HibernateUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            /*.configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));*/
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            System.exit(0);
        }
    }

    public static synchronized HibernateUtil getHibernateUtil() {
        if (util == null) {
            util = new HibernateUtil();
        }
        return util;
    }

    public Session getSession() {
        Session session = sessions.get();
        if (session == null) {
            session = sessionFactory.openSession();
            sessions.set(session);
        }
        return session;
    }

    public void beginTransaction() {
        Transaction transaction = transactions.get();
        if (transaction == null) {
            transaction = getSession().beginTransaction();
            transactions.set(transaction);
        }
    }

    public void commit() {
        Transaction transaction = transactions.get();
        if (transaction != null) {
            transaction.commit();
            transactions.remove();
        }
    }

    public void rollback() {
        Transaction transaction = transactions.get();
        if (transaction != null) {
            transaction.rollback();
            transactions.remove();
        }
    }
}
