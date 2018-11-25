package com.jay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
