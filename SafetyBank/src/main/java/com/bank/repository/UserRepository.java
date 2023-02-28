package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByEmail(String email); 

}
