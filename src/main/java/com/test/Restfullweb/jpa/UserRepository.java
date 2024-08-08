package com.test.Restfullweb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
