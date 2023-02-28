package com.bank.UserDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bank.entity.User;
import com.bank.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	 @Autowired private UserRepository repo;
	 
	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = repo.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("No user found with the given email");
	        }
	         
	        return new CustomUserDetails(user);
	    }

}
