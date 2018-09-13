/*package com.marc2web.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.marc2web.demo.services.SuccessHandler;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true)

public  class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private SuccessHandler successHandler;
	
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;
	
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
		.authorizeRequests()
			.antMatchers("/","/home","/logout","/register","/login").permitAll()
			.antMatchers("/showuser/**","/success/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/success/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.anyRequest().authenticated()
			.and().formLogin()
	        .loginPage("/login")
	        .loginProcessingUrl("/login")
	        .failureUrl("/login").permitAll()
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .successHandler(successHandler)
			.and().logout()    
			.logoutUrl("/logout") 
			.logoutSuccessUrl("/login")
			.deleteCookies("JSESSIONID")
			.and().exceptionHandling() 
			.accessDeniedPage("/errorpage");
			
			http.csrf().disable();
		} 
		
@Autowired
	 
	   	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        	
        	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            auth.userDetailsService(myAppUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
}*/