package com.arun.events.consumer.entity;

import java.io.Serializable;

/**
 * Created by arunnair on 06/11/2016.
 */
public class Attributes implements Serializable{

    private String accountNumber;
    private String transactionAmount;
    private String name;
    private String product;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}

