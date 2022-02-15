package com.example.bankManagement.service;

import java.util.List;

import com.example.bankManagement.dto.AccountDto;
import com.example.bankManagement.dto.CustomerDto;
import com.example.bankManagement.dto.TransactionDto;

public interface BankManagementService {

  CustomerDto createCustomer(CustomerDto customer);

  AccountDto createAccount(AccountDto account);

  List<AccountDto> fetchAccountDetailsByCustomer(int customerId);

  List<TransactionDto> fetchAccountDetailsByCustomerAndAccount(int customerId, int accountId);

  List<CustomerDto> fetchAllCustomers();

  TransactionDto addTransaction(TransactionDto transaction);

  List<AccountDto> fetchAllAccounts();

  List<TransactionDto> fetchallTransactionSummary();
}
