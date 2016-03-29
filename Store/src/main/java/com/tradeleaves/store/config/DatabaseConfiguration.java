package com.tradeleaves.store.config;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * DatabaseConfiguration for the application store.
 * </p>
 *
 * @author generator
 * @version 1.0
 */
@Configuration
@EnableJpaRepositories("com.tradeleaves.store.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

   private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
	
	@Bean
	public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/store");
	    dataSource.setUsername("tradeleaves");
	    dataSource.setPassword("tradeleaves");
	    return dataSource;
	}

	@Bean
	public EntityManager entityManager() {
	    return entityManagerFactory().getObject().createEntityManager();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	    em.setDataSource(dataSource());
	    em.setPackagesToScan(new String[] {"com.tradeleaves.store.domain"});
	    
	    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());

	    return em;
	}
    
	 @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	   
	   Properties additionalProperties() {
		         return new Properties() {
		            {  // Hibernate Specific:
		               setProperty("database-platform", "org.hibernate.dialect.MySQL5Dialect");
		               setProperty("hibernate.hbm2ddl.auto", "update");
		               setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		            }
		         };
	   }
}
