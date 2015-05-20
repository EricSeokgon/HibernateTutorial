package com.hadeslee.util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
/**
 * Project: HibernateTutorial
 * FileName: HibernateTestUtil
 * Date: 2015-05-20
 * Time: 오후 4:08
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class HibernateTestUtil {
    private static SessionFactory sessionFactory;
    private static String configFile = "hibernate.cfg.xml";


    public static SessionFactory getSessionFactory(Class<?> clazz) {
        if(sessionFactory==null){
            try {
                configFile = "/" + clazz.getPackage().getName().replace('.', '/') + "/" + configFile;
                Configuration cfg = new Configuration().configure(configFile);
                StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
                sb.applySettings(cfg.getProperties());
                StandardServiceRegistry standardServiceRegistry = sb.build();
                sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
            } catch (Throwable th) {
                System.err.println("Enitial SessionFactory creation failed" + th);
                throw new ExceptionInInitializerError(th);
            }
        }

        return sessionFactory;
    }

    public void shutdown() {
        sessionFactory.close();
    }
}