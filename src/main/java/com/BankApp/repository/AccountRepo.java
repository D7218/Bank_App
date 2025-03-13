package com.BankApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankApp.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	

}
