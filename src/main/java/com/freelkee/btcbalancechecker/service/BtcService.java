package com.freelkee.btcbalancechecker.service;



import com.freelkee.btcbalancechecker.model.TickerResponse;
import com.freelkee.btcbalancechecker.model.Transaction;

import java.io.IOException;

public interface BtcService {

    double getBalance(String address) throws IOException;

    double getTickerValue(TickerResponse ticker, String currency) throws NoSuchFieldException, IllegalAccessException;

    double getBtcBalanceInCurrency(String address, String currency) throws IOException, NoSuchFieldException, IllegalAccessException;

    void saveTransaction(Transaction transaction);
}
