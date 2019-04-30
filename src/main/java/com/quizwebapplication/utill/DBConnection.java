package com.quizwebapplication.utill;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@Configuration
@ComponentScan(basePackages = "com.quizwebapplication")
@EnableTransactionManagement
public class DBConnection {

	@Bean
	public LocalSessionFactoryBean factoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(getdataSource());
		bean.setPackagesToScan("com.quizwebapplication.bean");
		bean.setHibernateProperties(gethibernateProperties());
		return bean;
	}

	public DataSource getdataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/QuizWebApplication");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public Properties gethibernateProperties() {
		Properties ps = new Properties();
		ps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		ps.put("hibernate.show_sql", "false");
		ps.put("hibernate.format_sql", "false");
		ps.put("hibernate.hbm2ddl.auto", "update");
		return ps;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory s) {
		HibernateTransactionManager hm = new HibernateTransactionManager();
		hm.setSessionFactory(s);
		return hm;

	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(factoryBean().getObject());
	}

}
