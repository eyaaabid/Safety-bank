package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.*;

import com.bank.UserDetails.CustomUserDetailsService;

@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfiguration{
	@Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
     
    @SuppressWarnings("deprecation")
	@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
 
    @SuppressWarnings("deprecation")
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers("/").permitAll();
         
        http.antMatcher("/admin/**")
            .authorizeRequests().anyRequest().hasAuthority("Chef_Agence")
            .and()
            .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("email")
                .loginProcessingUrl("/admin/login")
                .defaultSuccessUrl("/admin/home")
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/");
    }  
	

}
