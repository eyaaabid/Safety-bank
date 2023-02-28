package com.bank.repository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.bank.entity.User;
import com.bank.enu.Role;

public  class DatabaseLoader {
	 private UserRepository repo;
     
	    public DatabaseLoader(UserRepository repo) {
	        this.repo = repo;
	    }
	 
	    @Bean
	    public CommandLineRunner initializeDatabase() {
	        return args -> {
	            User user1 = new User("tahabaccouch@gmail.com", "123", Role.Chef_Agence);
	            User user2 = new User("eyaabid@gmail.com", "147", Role.Caissier);
	            User user3 = new User("aaaa@gmail.com", "258", Role.Caissier);
	         
	             
	            repo.saveAll(List.of(user1, user2, user3));
	             
	            System.out.println("Database initialized");
	        };
	    }

}
