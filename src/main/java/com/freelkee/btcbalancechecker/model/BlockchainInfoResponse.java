package com.freelkee.btcbalancechecker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private List txs;

}

