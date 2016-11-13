package com.arun.events.producer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by arunnair on 06/11/2016.
 */
public class Attributes implements Serializable{

    @SerializedName("Account Number")
    private String accountNumber;
    @SerializedName("Transaction Amount")
    private String transactionAmount;
    @SerializedName("Name")
    private String name;
    @SerializedName("Product")
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

