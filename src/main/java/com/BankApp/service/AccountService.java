package com.BankApp.service;

import com.BankApp.dto.AccountDto;

import java.util.List;

public interface AccountService {


	AccountDto createAccount(AccountDto accountDto);

	AccountDto getAccountById(Long id);

	AccountDto deposit(Long id, double amount);

	AccountDto withdrow(Long id, double amount);

	List<AccountDto> getAllAccounts();

	AccountDto deleteAccount(Long id);

}
