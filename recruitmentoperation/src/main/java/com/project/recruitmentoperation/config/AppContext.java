package com.project.recruitmentoperation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
@ComponentScan({"com.project.recruitmentoperation.dao"})
public class AppContext {
	 @Autowired
	    private Environment environment;

	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	    //	System.out.println("************333333333333");
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] {
	            "com.project.recruitmentoperation.entity"
	        });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        System.out.println(sessionFactory);
	        return sessionFactory;
	    }

	    @Bean
	    public DataSource dataSource() {
	  //  	System.out.println("************333333333333");
		    
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	  /*      System.out.println(environment.getRequiredProperty("jdbc.driverClassName"));
	        System.out.println(environment.getRequiredProperty("jdbc.url"));
		     
	        System.out.println(environment.getRequiredProperty("jdbc.username"));
	        System.out.println(environment.getRequiredProperty("jdbc.password"));
			    
	    */    
	        return dataSource;
	    }

	    private Properties hibernateProperties() {
	    //	System.out.println("************333333333333");
		    
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
	        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
	        return properties;
	    }

	    @Bean
	    public HibernateTransactionManager getTransactionManager() {
	  //  	System.out.println("************333333333333");
		    
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	    @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver getCommonsMultipartResolver() {
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	        multipartResolver.setMaxUploadSize(20971520);   // 20MB
	        multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	        return multipartResolver;
	    }

}
