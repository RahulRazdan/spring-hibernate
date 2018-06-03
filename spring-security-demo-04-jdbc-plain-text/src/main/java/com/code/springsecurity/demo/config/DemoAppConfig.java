package com.code.springsecurity.demo.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")	
public class DemoAppConfig {

	@Autowired
	Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		
		ComboPooledDataSource  datasource = new ComboPooledDataSource();
		try {
			datasource.setDriverClass(env.getProperty("jdbc.driver"));
			datasource.setJdbcUrl(env.getProperty("jdbc.url"));
			datasource.setUser(env.getProperty("jdbc.user"));
			datasource.setPassword(env.getProperty("jdbc.password"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		 datasource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		 datasource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		 datasource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		 datasource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		return datasource;
		
	}
}
