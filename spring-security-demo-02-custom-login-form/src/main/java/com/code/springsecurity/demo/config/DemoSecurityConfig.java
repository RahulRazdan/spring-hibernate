package com.code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		@SuppressWarnings("deprecation")
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(user.username("John").password("123").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(user.username("Lily").password("123").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(user.username("susan").password("123").roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateLogin").permitAll();
	
	}

}
