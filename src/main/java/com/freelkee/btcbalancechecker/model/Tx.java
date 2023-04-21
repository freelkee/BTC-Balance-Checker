package com.freelkee.btcbalancechecker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "txs")
public class Tx {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "amount")
    private double amount;

}