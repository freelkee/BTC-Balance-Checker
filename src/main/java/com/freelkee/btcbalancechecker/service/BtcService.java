package com.freelkee.btcbalancechecker.service;

import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.TickerResponse;
import com.freelkee.btcbalancechecker.model.Wallet;

import java.io.IOException;

public interface BtcService {

    BlockchainInfoResponse getResponse(String address, int offset) throws IOException;

    double getTickerValue(TickerResponse ticker, String currency) throws NoSuchFieldException, IllegalAccessException;

    void saveWallet(Wallet wallet);

    Wallet getWallet(String currency, String bitcoinAddress) throws IOException;
}
