package com.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
@Order(2)
public class UserSecurityConfig extends WebSecurityConfiguration{
	@SuppressWarnings("deprecation")
	protected void configure(HttpSecurity http) throws Exception {
         
        http.antMatcher("/user/**")
            .authorizeRequests().anyRequest().hasAuthority("Caissier")
            .and()
            .formLogin()
                .loginPage("/user/login")
                .usernameParameter("email")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/user/home")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/");    
    }  
	

}
