package com.freelkee.btcbalancechecker.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "date")
    private Timestamp date;

    @Column(name = "wallet_address")
    private String address;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private double amount;

    @Column(name = "amount_in_currency")
    private double amountInCurrency;

    @Column(name = "note")
    private String note;


    public Transaction() {
    }

    @PrePersist
    public void setCreatedAt() {
        this.date = new Timestamp(System.currentTimeMillis());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getAmountInCurrency() {
        return amountInCurrency;
    }

    public void setAmountInCurrency(double amountInCurrency) {
        this.amountInCurrency = amountInCurrency;
    }
}
