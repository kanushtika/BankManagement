package com.example.bankManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankManagement.dto.AccountDto;
import com.example.bankManagement.dto.CustomerDto;
import com.example.bankManagement.dto.TransactionDto;
import com.example.bankManagement.repository.BankManagementRepository;

@Service
public class BankManagementServiceImpl implements BankManagementService {

  @Autowired
  BankManagementRepository bankManagementRepositoty;

  @Override
  public CustomerDto createCustomer(CustomerDto customer) {
    return bankManagementRepositoty.createCustomer(customer);
  }

  @Override
  public AccountDto createAccount(AccountDto account) {
    return bankManagementRepositoty.createAccount(account);
  }

  @Override
  public List<AccountDto> fetchAccountDetailsByCustomer(int customerId) {
    return bankManagementRepositoty.fetchAccountDetailsByCustomer(customerId);
  }

  @Override
  public List<TransactionDto> fetchAccountDetailsByCustomerAndAccount(int customerId, int accountId) {
    return bankManagementRepositoty.fetchAccountDetailsByCustomerAndAccount(customerId, accountId);
  }

  @Override
  public List<CustomerDto> fetchAllCustomers() {
    return bankManagementRepositoty.fetchAllCustomers();
  }

  @Override
  public TransactionDto addTransaction(TransactionDto transaction) {
    return bankManagementRepositoty.addTransaction(transaction);
  }

  @Override
  public List<AccountDto> fetchAllAccounts() {
    return bankManagementRepositoty.fetchAllAccounts();
  }

  @Override
  public List<TransactionDto> fetchallTransactionSummary() {
    return bankManagementRepositoty.fetchallTransactionSummary();
  }
}
