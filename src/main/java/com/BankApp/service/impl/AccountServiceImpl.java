package com.BankApp.service.impl;

import org.springframework.stereotype.Service;

import com.BankApp.dto.AccountDto;
import com.BankApp.entity.Account;
import com.BankApp.mapper.AccountMapper;
import com.BankApp.repository.AccountRepo;
import com.BankApp.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

	  private AccountRepo accountRepo;
	
	 public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo= accountRepo;
	  }
	

	 @Override
	 public AccountDto createAccount(AccountDto accountDto) {
		 Account account = AccountMapper.mapToAccount(accountDto);
		 Account savedAccount =accountRepo.save(account);

		 return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));


		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdrow(Long id, double amount) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		if (account.getBalance()< amount){
			throw new RuntimeException("Insufficient amount");
		}
		double total= account.getBalance()- amount;
		account.setBalance(total);
		Account savedAccount = accountRepo.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepo.findAll();
		 return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());


	}

	@Override
	public AccountDto deleteAccount(Long id) {
		Account account = accountRepo
				.findById(id)
				.orElseThrow(() -> new RuntimeException("delete successfully"));
		accountRepo.deleteById(id);

		return null;
	}


}
