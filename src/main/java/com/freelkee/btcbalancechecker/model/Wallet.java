package com.freelkee.btcbalancechecker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount_in_currency")
    private double amountInCurrency;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_wallet")
    public List<Tx> txs;

    @PrePersist
    public void setCreatedAt() {
        this.date = new Timestamp(System.currentTimeMillis());
    }

}
