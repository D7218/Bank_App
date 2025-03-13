package com.BankApp.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class AccountDto {
	
	private Long id;
	private String accountHolderName;
	private double balance;
}
