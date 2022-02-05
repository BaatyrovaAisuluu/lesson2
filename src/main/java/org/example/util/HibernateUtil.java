package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "1234");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.entity.Person.class);
        cfg.addAnnotatedClass(org.example.entity.Company.class);
        cfg.addAnnotatedClass(org.example.entity.Garage.class);
        cfg.addAnnotatedClass(org.example.entity.Car.class);
        cfg.addAnnotatedClass(org.example.entity.SocialMedia.class);
//        cfg.addAnnotatedClass(org.example.entity.NotEmpty.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSession() {
        return sessionFactory;
    }
    public static void shutDown() {
        getSession().close();
    }
}
