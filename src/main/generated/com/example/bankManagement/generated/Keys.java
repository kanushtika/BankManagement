/*
 * This file is generated by jOOQ.
 */
package com.example.bankManagement.generated;


import com.example.bankManagement.generated.tables.Account;
import com.example.bankManagement.generated.tables.BankTransaction;
import com.example.bankManagement.generated.tables.Customer;
import com.example.bankManagement.generated.tables.FlywaySchemaHistory;
import com.example.bankManagement.generated.tables.records.AccountRecord;
import com.example.bankManagement.generated.tables.records.BankTransactionRecord;
import com.example.bankManagement.generated.tables.records.CustomerRecord;
import com.example.bankManagement.generated.tables.records.FlywaySchemaHistoryRecord;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>bankmanagement</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Identities0.IDENTITY_ACCOUNT;
    public static final Identity<BankTransactionRecord, Integer> IDENTITY_BANK_TRANSACTION = Identities0.IDENTITY_BANK_TRANSACTION;
    public static final Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = Identities0.IDENTITY_CUSTOMER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = UniqueKeys0.KEY_ACCOUNT_PRIMARY;
    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_ACCOUNT_UNIQUE = UniqueKeys0.KEY_ACCOUNT_ACCOUNT_UNIQUE;
    public static final UniqueKey<BankTransactionRecord> KEY_BANK_TRANSACTION_PRIMARY = UniqueKeys0.KEY_BANK_TRANSACTION_PRIMARY;
    public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = UniqueKeys0.KEY_CUSTOMER_PRIMARY;
    public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_CUSTOMER_UNIQUE = UniqueKeys0.KEY_CUSTOMER_CUSTOMER_UNIQUE;
    public static final UniqueKey<FlywaySchemaHistoryRecord> KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY = UniqueKeys0.KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AccountRecord, CustomerRecord> FK_ACCOUNT_CUSTOMER_ID = ForeignKeys0.FK_ACCOUNT_CUSTOMER_ID;
    public static final ForeignKey<BankTransactionRecord, AccountRecord> FK_BANK_TRANSACTION_ACCOUNT_ID = ForeignKeys0.FK_BANK_TRANSACTION_ACCOUNT_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Internal.createIdentity(Account.ACCOUNT, Account.ACCOUNT.ID);
        public static Identity<BankTransactionRecord, Integer> IDENTITY_BANK_TRANSACTION = Internal.createIdentity(BankTransaction.BANK_TRANSACTION, BankTransaction.BANK_TRANSACTION.ID);
        public static Identity<CustomerRecord, Integer> IDENTITY_CUSTOMER = Internal.createIdentity(Customer.CUSTOMER, Customer.CUSTOMER.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = Internal.createUniqueKey(Account.ACCOUNT, "KEY_account_PRIMARY", new TableField[] { Account.ACCOUNT.ID }, true);
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_ACCOUNT_UNIQUE = Internal.createUniqueKey(Account.ACCOUNT, "KEY_account_account_unique", new TableField[] { Account.ACCOUNT.ACCOUNT_NUMBER }, true);
        public static final UniqueKey<BankTransactionRecord> KEY_BANK_TRANSACTION_PRIMARY = Internal.createUniqueKey(BankTransaction.BANK_TRANSACTION, "KEY_bank_transaction_PRIMARY", new TableField[] { BankTransaction.BANK_TRANSACTION.ID }, true);
        public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_PRIMARY = Internal.createUniqueKey(Customer.CUSTOMER, "KEY_customer_PRIMARY", new TableField[] { Customer.CUSTOMER.ID }, true);
        public static final UniqueKey<CustomerRecord> KEY_CUSTOMER_CUSTOMER_UNIQUE = Internal.createUniqueKey(Customer.CUSTOMER, "KEY_customer_customer_unique", new TableField[] { Customer.CUSTOMER.IDENTITY_CARD_NO }, true);
        public static final UniqueKey<FlywaySchemaHistoryRecord> KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "KEY_flyway_schema_history_PRIMARY", new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AccountRecord, CustomerRecord> FK_ACCOUNT_CUSTOMER_ID = Internal.createForeignKey(Keys.KEY_CUSTOMER_PRIMARY, Account.ACCOUNT, "fk_account_customer_id", new TableField[] { Account.ACCOUNT.CUSTOMER_ID }, true);
        public static final ForeignKey<BankTransactionRecord, AccountRecord> FK_BANK_TRANSACTION_ACCOUNT_ID = Internal.createForeignKey(Keys.KEY_ACCOUNT_PRIMARY, BankTransaction.BANK_TRANSACTION, "fk_bank_transaction_account_id", new TableField[] { BankTransaction.BANK_TRANSACTION.ACCOUNT_ID }, true);
    }
}
