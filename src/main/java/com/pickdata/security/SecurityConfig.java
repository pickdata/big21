package com.pickdata.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("##################");
		log.info("security config...");
		log.info("##################");
		
		http.authorizeRequests().antMatchers("/login/**").permitAll();
//		http.authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
//    .formLogin().loginPage("/login/**")
//    .permitAll()
//        .and()
//    .logout()
//    .permitAll();

		
		http.formLogin();
	}	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		String query1 = 
				"select uid username, upw password from tbl_manager where uid = ?";
		
		auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(query1);
//		auth.jdbcAuthentication().getUserDetailsService().
//		auth.jdbcAuthentication().withUser("pickdata").password("pickme");
//		auth.inMemoryAuthentication().withUser("pickdata").password("pickme");
	}
	
}
