package com.pickdata.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;	
	
	@Autowired
	PickUserService pickUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("##################");
		log.info("security config...");
		log.info("##################");
		
		http.authorizeRequests().antMatchers("/credits/list/**").hasRole("MANAGER");
		http.formLogin().loginPage("/credits/login");
		
		http.exceptionHandling().accessDeniedPage("/credits/list"); 
		
		http.logout().logoutUrl("/credits/list").invalidateHttpSession(true);
//		http.logout().invalidateHttpSession(true);
		
	
	}	
	
	private PersistentTokenRepository getJDBCRepository() {
		
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(datasource);
		
		return repo;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth.userDetailsService(pickUserService).passw 
//
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			
		auth.inMemoryAuthentication().withUser("pickdata").password("pickme").roles("MANAGER");	
//		String query1 = 
//				"select uid username, upw password from tbl_manager where uid = ?";
//		
//		auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(query1);

	}
	
}
