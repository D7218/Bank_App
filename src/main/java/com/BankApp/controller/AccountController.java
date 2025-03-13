package com.BankApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.BankApp.dto.AccountDto;
import com.BankApp.service.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	  private AccountService accountService;
	  
	  public AccountController(AccountService accountService) {
		  this.accountService= accountService;
		  
	  }
	  
	  // add Account Rest api
	  @PostMapping("/")
	  public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		  return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	  }
	  //get account rest api
     @GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		  AccountDto accountDto = accountService.getAccountById(id);
		  return ResponseEntity.ok(accountDto);
	}
	// deposit Rest API
      @PutMapping("/{id}/deposit")
	  public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
					@RequestBody Map<String,Double> request){
		  AccountDto accountDto = accountService.deposit(id, request.get("amount"));
		  return ResponseEntity.ok(accountDto);

	}
	// withdrow REst api
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto>withdrow(@PathVariable Long id,
	  @RequestBody Map<String, Double> request){
		double amount = request.get("amount");
		AccountDto accountDto = accountService.withdrow(id, amount);
		return ResponseEntity.ok(accountDto);

	}
	// Get All Account Rest Api
	@GetMapping("/")
	public ResponseEntity <List<AccountDto>>getAllAccount(){
		List<AccountDto> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	// delete account
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount( @PathVariable Long id){
		AccountDto deleteAccount = accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted success");

	}
	 
}
