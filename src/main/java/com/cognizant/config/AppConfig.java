package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;

import com.cognizant.dao.CustomerDao;
import com.cognizant.dao.CustomerDaoImpl;

@Configuration
@ComponentScan("com.cognizant")
@PropertySource("classpath:database.properties")
public class AppConfig {


	@Autowired
	Environment environment;

	private final String DEV_URL = "DEV_URL";
	private final String DEV_USER = "DEV_USERNAME";
	private final String DEV_DRIVER = "DEV_DRIVER_CLASS";
	private final String DEV_PASSWORD = "DEV_PASSWORD";

	@Bean("dataSource")
	public DataSource getDataSourceDev() {
	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty(DEV_URL));
		dataSource.setUsername(environment.getProperty(DEV_USER));
		dataSource.setPassword(environment.getProperty(DEV_PASSWORD));
		dataSource.setDriverClassName(environment.getProperty(DEV_DRIVER));
		return dataSource;

	}



}
