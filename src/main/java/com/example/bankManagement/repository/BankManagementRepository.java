package com.example.bankManagement.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.bankManagement.dto.AccountDto;
import com.example.bankManagement.dto.CustomerDto;
import com.example.bankManagement.dto.TransactionDto;

public interface BankManagementRepository {

  @Transactional
  CustomerDto createCustomer(CustomerDto customer);

  @Transactional
  AccountDto createAccount(AccountDto account);

  @Transactional
  List<AccountDto> fetchAccountDetailsByCustomer(int customerId);

  @Transactional
  List<TransactionDto> fetchAccountDetailsByCustomerAndAccount(int customerId, int accountId);

  @Transactional
  List<CustomerDto> fetchAllCustomers();

  @Transactional
  TransactionDto addTransaction(TransactionDto transaction);

  @Transactional
  List<AccountDto> fetchAllAccounts();

  @Transactional
  List<TransactionDto> fetchallTransactionSummary();

}
