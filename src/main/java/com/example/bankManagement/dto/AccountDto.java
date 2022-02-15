package com.example.bankManagement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountDto {
  int id;

  int customerId;

  String accountNumber;

  String accountType;

  LocalDateTime createdAt;

}
