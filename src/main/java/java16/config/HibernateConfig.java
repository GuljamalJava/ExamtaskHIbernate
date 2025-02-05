package java16.config;

import jakarta.persistence.EntityManagerFactory;

import java16.entities.UserDetail;
import java16.entities.UserProfile;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory getEntityManagerFactory() {

        Properties properties = new Properties();

        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5454/postgres");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "java123");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration;
        configuration = new Configuration().addProperties(properties);
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(UserDetail.class);
        configuration.addAnnotatedClass(UserProfile.class);
        EntityManagerFactory unwrap = configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return unwrap;

    }
}
