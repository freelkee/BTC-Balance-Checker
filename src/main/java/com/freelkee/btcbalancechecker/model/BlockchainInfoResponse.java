package com.freelkee.btcbalancechecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockchainInfoResponse {
    private String hash160;
    private String address;
    private int n_tx;
    private long total_received;
    private long total_sent;
    private long final_balance;

    //the implementation of the transaction list will be in the future
    private List txs;

}

