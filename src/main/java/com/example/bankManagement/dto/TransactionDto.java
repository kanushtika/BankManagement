package com.example.bankManagement.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDto {
  int id;

  int customerId;

  int accountId;

  double transactionAmount;

  String transactionType;

  double balance;

  LocalDateTime transactionDate;
}
