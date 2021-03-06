/*
 * This file is generated by jOOQ.
 */
package com.example.bankManagement.generated;


import com.example.bankManagement.generated.tables.Account;
import com.example.bankManagement.generated.tables.BankTransaction;
import com.example.bankManagement.generated.tables.Customer;
import com.example.bankManagement.generated.tables.FlywaySchemaHistory;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bankmanagement extends SchemaImpl {

    private static final long serialVersionUID = -333803630;

    /**
     * The reference instance of <code>bankmanagement</code>
     */
    public static final Bankmanagement BANKMANAGEMENT = new Bankmanagement();

    /**
     * The table <code>bankmanagement.account</code>.
     */
    public final Account ACCOUNT = Account.ACCOUNT;

    /**
     * The table <code>bankmanagement.bank_transaction</code>.
     */
    public final BankTransaction BANK_TRANSACTION = BankTransaction.BANK_TRANSACTION;

    /**
     * The table <code>bankmanagement.customer</code>.
     */
    public final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>bankmanagement.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * No further instances allowed
     */
    private Bankmanagement() {
        super("bankmanagement", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Account.ACCOUNT,
            BankTransaction.BANK_TRANSACTION,
            Customer.CUSTOMER,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY);
    }
}
