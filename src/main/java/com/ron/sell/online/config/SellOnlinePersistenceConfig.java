package com.ron.sell.online.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration

public class SellOnlinePersistenceConfig {

    @Resource
    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource sellOnlineDataSource() {

        DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean sellOnlineEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sellOnlineDataSource());
        em.setPackagesToScan("com.ron.sell.online.entity");
        em.setPersistenceUnitName("sellonline");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("spring.jpa.properties.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getProperty("spring.jpa.properties.hibernate.format_sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager sellOnlineTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return sellOnlineEntityManagerFactory().getObject();

    }
}
