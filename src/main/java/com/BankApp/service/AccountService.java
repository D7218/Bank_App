package com.BankApp.service;

import com.BankApp.dto.AccountDto;

public interface AccountService {


	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);

	AccountDto deposit(Long id, double amount);

	AccountDto withdrow(Long id, double amount);

}
