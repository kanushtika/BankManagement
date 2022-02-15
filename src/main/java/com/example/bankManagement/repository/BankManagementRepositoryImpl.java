package com.example.bankManagement.repository;

import static com.example.bankManagement.generated.tables.Account.ACCOUNT;
import static com.example.bankManagement.generated.tables.BankTransaction.BANK_TRANSACTION;
import static com.example.bankManagement.generated.tables.Customer.CUSTOMER;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bankManagement.dto.AccountDto;
import com.example.bankManagement.dto.CustomerDto;
import com.example.bankManagement.dto.TransactionDto;
import com.example.bankManagement.generated.tables.records.AccountRecord;
import com.example.bankManagement.generated.tables.records.BankTransactionRecord;
import com.example.bankManagement.generated.tables.records.CustomerRecord;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BankManagementRepositoryImpl implements BankManagementRepository {

  @Autowired
  private DSLContext create;

  @Override
  public CustomerDto createCustomer(CustomerDto customer) {
    log.debug("create customer " + customer);

    final CustomerRecord groupRecord = create.insertInto(CUSTOMER)
        .set(CUSTOMER.CUSTOMER_NAME, customer.getCustomerName())
        .set(CUSTOMER.IDENTITY_CARD_NO, customer.getIdentityCardNo()).set(CUSTOMER.EMAIL, customer.getEmail())
        .returning(CUSTOMER.ID).fetchOne();

    customer.setId(groupRecord.getId());

    return customer;
  }

  @Override
  public AccountDto createAccount(AccountDto account) {
    log.debug("create account " + account);

    final AccountRecord accountRecord = create.insertInto(ACCOUNT).set(ACCOUNT.CUSTOMER_ID, account.getCustomerId())
        .set(ACCOUNT.ACCOUNT_NUMBER, account.getAccountNumber()).set(ACCOUNT.ACCOUNT_TYPE, account.getAccountType())
        .returning(ACCOUNT.ID).fetchOne();

    account.setId(accountRecord.getId());

    return account;
  }

  @Override
  public List<AccountDto> fetchAccountDetailsByCustomer(int customerId) {
    log.debug("fetch account deatils by customer " + customerId);

    final List<AccountDto> accounts = create.select().from(ACCOUNT).where(ACCOUNT.CUSTOMER_ID.eq(customerId))
        .orderBy(ACCOUNT.CREATED_AT.desc()).fetchInto(AccountDto.class);

    return accounts;
  }

  @Override
  public List<TransactionDto> fetchAccountDetailsByCustomerAndAccount(int customerId, int accountId) {
    log.debug("fetch account deatils by customer: " + customerId + "account:" + accountId);

    final List<TransactionDto> transactionDetails = create.select().from(BANK_TRANSACTION).join(ACCOUNT)
        .on(BANK_TRANSACTION.ACCOUNT_ID.eq(ACCOUNT.ID)).where(BANK_TRANSACTION.ACCOUNT_ID.eq(accountId))
        .and(ACCOUNT.CUSTOMER_ID.eq(customerId)).orderBy(BANK_TRANSACTION.TRANSACTION_DATE.desc())
        .fetchInto(TransactionDto.class);

    return transactionDetails;
  }

  @Override
  public List<CustomerDto> fetchAllCustomers() {
    log.debug("fetch all customers");

    final List<CustomerDto> customerDetails = create.select().from(CUSTOMER).orderBy(CUSTOMER.CREATED_AT.desc())
        .fetchInto(CustomerDto.class);

    return customerDetails;
  }

  @Override
  public TransactionDto addTransaction(TransactionDto transaction) {
    final List<TransactionDto> transactionDeatils = this
        .fetchAccountDetailsByCustomerAndAccount(transaction.getCustomerId(), transaction.getAccountId());

    final TransactionDto lastTransaction = create.select(BANK_TRANSACTION.BALANCE).from(BANK_TRANSACTION).join(ACCOUNT)
        .on(BANK_TRANSACTION.ACCOUNT_ID.eq(ACCOUNT.ID))
        .where(BANK_TRANSACTION.ACCOUNT_ID.eq(transaction.getAccountId()))
        .and(ACCOUNT.CUSTOMER_ID.eq(transaction.getCustomerId())).orderBy(BANK_TRANSACTION.TRANSACTION_DATE.desc())
        .limit(1).fetchOneInto(TransactionDto.class);

    if (transactionDeatils.size() == 0) {
      final BankTransactionRecord transactionRecord = create.insertInto(BANK_TRANSACTION)
          .set(BANK_TRANSACTION.ACCOUNT_ID, transaction.getAccountId())
          .set(BANK_TRANSACTION.TRANSACTION_AMOUNT, transaction.getTransactionAmount())
          .set(BANK_TRANSACTION.TRANSACTION_TYPE, transaction.getTransactionType())
          .set(BANK_TRANSACTION.BALANCE, transaction.getTransactionAmount())
          .returning(BANK_TRANSACTION.ID, BANK_TRANSACTION.BALANCE).fetchOne();
      transaction.setId(transactionRecord.getId());
      transaction.setBalance(transactionRecord.getBalance());
    } else {
      if (transaction.getTransactionType().equalsIgnoreCase("deposit")) {

        final double debitAmmount = lastTransaction.getBalance() + transaction.getTransactionAmount();
        final BankTransactionRecord transactionRecord = create.insertInto(BANK_TRANSACTION)
            .set(BANK_TRANSACTION.ACCOUNT_ID, transaction.getAccountId())
            .set(BANK_TRANSACTION.TRANSACTION_AMOUNT, transaction.getTransactionAmount())
            .set(BANK_TRANSACTION.TRANSACTION_TYPE, transaction.getTransactionType())
            .set(BANK_TRANSACTION.BALANCE, debitAmmount).returning(BANK_TRANSACTION.ID, BANK_TRANSACTION.BALANCE)
            .fetchOne();
        transaction.setId(transactionRecord.getId());
        transaction.setBalance(transactionRecord.getBalance());
      }

      else if (transaction.getTransactionType().equalsIgnoreCase("withdrawal")) {
        final double creditAmmount = lastTransaction.getBalance() - transaction.getTransactionAmount();
        final BankTransactionRecord transactionRecord = create.insertInto(BANK_TRANSACTION)
            .set(BANK_TRANSACTION.ACCOUNT_ID, transaction.getAccountId())
            .set(BANK_TRANSACTION.TRANSACTION_AMOUNT, transaction.getTransactionAmount())
            .set(BANK_TRANSACTION.TRANSACTION_TYPE, transaction.getTransactionType())
            .set(BANK_TRANSACTION.BALANCE, creditAmmount).returning(BANK_TRANSACTION.ID, BANK_TRANSACTION.BALANCE)
            .fetchOne();
        transaction.setId(transactionRecord.getId());
        transaction.setBalance(transactionRecord.getBalance());
      }
    }

    return transaction;
  }

  @Override
  public List<TransactionDto> fetchallTransactionSummary() {

    final List<TransactionDto> transactionSummary = create.select().from(BANK_TRANSACTION)
        .orderBy(BANK_TRANSACTION.TRANSACTION_DATE.desc()).fetchInto(TransactionDto.class);
    return transactionSummary;
  }

  @Override
  public List<AccountDto> fetchAllAccounts() {
    log.debug("fetch all accounts");

    final List<AccountDto> accountDetails = create.select().from(ACCOUNT).orderBy(ACCOUNT.CREATED_AT.desc())
        .fetchInto(AccountDto.class);

    return accountDetails;
  }
}
