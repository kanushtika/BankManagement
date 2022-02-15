package com.example.bankManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankManagement.dto.AccountDto;
import com.example.bankManagement.dto.CustomerDto;
import com.example.bankManagement.dto.TransactionDto;
import com.example.bankManagement.service.BankManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@ComponentScan({ "com.example" })
public class BankManagementController {

  @Autowired
  BankManagementService bankManagementService;

  @PostMapping(path = "/create/customer", produces = "application/json")
  public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customer) {
    log.info("create customer :" + customer);
    final CustomerDto customerDetails = bankManagementService.createCustomer(customer);
    return ResponseEntity.status(HttpStatus.OK).body(customerDetails);

  }

  @PostMapping(path = "/create/account", produces = "application/json")
  public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
    log.info("create account :" + account);
    final AccountDto accountDetails = bankManagementService.createAccount(account);
    return ResponseEntity.status(HttpStatus.OK).body(accountDetails);

  }

  @GetMapping(value = "/accounts")
  public ResponseEntity<List<AccountDto>> fetchAccountDetailsByCustomer(@RequestParam int customerId) {

    return ResponseEntity.status(HttpStatus.OK).body(bankManagementService.fetchAccountDetailsByCustomer(customerId));
  }

  @GetMapping(value = "/transaction")
  public ResponseEntity<List<TransactionDto>> fetchAccountDetailsByCustomerAndAccount(@RequestParam int customerId,
      @RequestParam int accountId) {

    return ResponseEntity.status(HttpStatus.OK)
        .body(bankManagementService.fetchAccountDetailsByCustomerAndAccount(customerId, accountId));
  }

  @GetMapping(value = "/customers")
  public ResponseEntity<List<CustomerDto>> fetchAllCustomers() {

    return ResponseEntity.status(HttpStatus.OK).body(bankManagementService.fetchAllCustomers());
  }

  @PostMapping(path = "/trasfer", produces = "application/json")
  public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transaction) {
    log.info("add transaction :" + transaction);
    final TransactionDto transactionDetails = bankManagementService.addTransaction(transaction);
    return ResponseEntity.status(HttpStatus.OK).body(transactionDetails);

  }

  @GetMapping(value = "/accountDetails")
  public ResponseEntity<List<AccountDto>> fetchAllAccounts() {

    return ResponseEntity.status(HttpStatus.OK).body(bankManagementService.fetchAllAccounts());
  }

  @GetMapping(value = "/transaction/summary")
  public ResponseEntity<List<TransactionDto>> fetchallTransactionSummary() {

    return ResponseEntity.status(HttpStatus.OK).body(bankManagementService.fetchallTransactionSummary());
  }
}
