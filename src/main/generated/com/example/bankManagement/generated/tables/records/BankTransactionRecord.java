/*
 * This file is generated by jOOQ.
 */
package com.example.bankManagement.generated.tables.records;


import com.example.bankManagement.generated.tables.BankTransaction;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankTransactionRecord extends UpdatableRecordImpl<BankTransactionRecord> implements Record6<Integer, Integer, Double, String, LocalDateTime, Double> {

    private static final long serialVersionUID = 166689809;

    /**
     * Setter for <code>bankmanagement.bank_transaction.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bankmanagement.bank_transaction.account_id</code>.
     */
    public void setAccountId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.account_id</code>.
     */
    public Integer getAccountId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>bankmanagement.bank_transaction.transaction_amount</code>.
     */
    public void setTransactionAmount(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.transaction_amount</code>.
     */
    public Double getTransactionAmount() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>bankmanagement.bank_transaction.transaction_type</code>.
     */
    public void setTransactionType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.transaction_type</code>.
     */
    public String getTransactionType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bankmanagement.bank_transaction.transaction_date</code>.
     */
    public void setTransactionDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.transaction_date</code>.
     */
    public LocalDateTime getTransactionDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>bankmanagement.bank_transaction.balance</code>.
     */
    public void setBalance(Double value) {
        set(5, value);
    }

    /**
     * Getter for <code>bankmanagement.bank_transaction.balance</code>.
     */
    public Double getBalance() {
        return (Double) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, Double, String, LocalDateTime, Double> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Integer, Double, String, LocalDateTime, Double> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return BankTransaction.BANK_TRANSACTION.ID;
    }

    @Override
    public Field<Integer> field2() {
        return BankTransaction.BANK_TRANSACTION.ACCOUNT_ID;
    }

    @Override
    public Field<Double> field3() {
        return BankTransaction.BANK_TRANSACTION.TRANSACTION_AMOUNT;
    }

    @Override
    public Field<String> field4() {
        return BankTransaction.BANK_TRANSACTION.TRANSACTION_TYPE;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return BankTransaction.BANK_TRANSACTION.TRANSACTION_DATE;
    }

    @Override
    public Field<Double> field6() {
        return BankTransaction.BANK_TRANSACTION.BALANCE;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getAccountId();
    }

    @Override
    public Double component3() {
        return getTransactionAmount();
    }

    @Override
    public String component4() {
        return getTransactionType();
    }

    @Override
    public LocalDateTime component5() {
        return getTransactionDate();
    }

    @Override
    public Double component6() {
        return getBalance();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getAccountId();
    }

    @Override
    public Double value3() {
        return getTransactionAmount();
    }

    @Override
    public String value4() {
        return getTransactionType();
    }

    @Override
    public LocalDateTime value5() {
        return getTransactionDate();
    }

    @Override
    public Double value6() {
        return getBalance();
    }

    @Override
    public BankTransactionRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public BankTransactionRecord value2(Integer value) {
        setAccountId(value);
        return this;
    }

    @Override
    public BankTransactionRecord value3(Double value) {
        setTransactionAmount(value);
        return this;
    }

    @Override
    public BankTransactionRecord value4(String value) {
        setTransactionType(value);
        return this;
    }

    @Override
    public BankTransactionRecord value5(LocalDateTime value) {
        setTransactionDate(value);
        return this;
    }

    @Override
    public BankTransactionRecord value6(Double value) {
        setBalance(value);
        return this;
    }

    @Override
    public BankTransactionRecord values(Integer value1, Integer value2, Double value3, String value4, LocalDateTime value5, Double value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BankTransactionRecord
     */
    public BankTransactionRecord() {
        super(BankTransaction.BANK_TRANSACTION);
    }

    /**
     * Create a detached, initialised BankTransactionRecord
     */
    public BankTransactionRecord(Integer id, Integer accountId, Double transactionAmount, String transactionType, LocalDateTime transactionDate, Double balance) {
        super(BankTransaction.BANK_TRANSACTION);

        set(0, id);
        set(1, accountId);
        set(2, transactionAmount);
        set(3, transactionType);
        set(4, transactionDate);
        set(5, balance);
    }
}
