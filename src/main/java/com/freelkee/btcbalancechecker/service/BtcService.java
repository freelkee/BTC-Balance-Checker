package com.freelkee.btcbalancechecker.service;



import com.freelkee.btcbalancechecker.model.TickerResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface BtcService {

    public double getBalance(String address) throws IOException;

    double getTickerValue(TickerResponse ticker, String currency) throws NoSuchFieldException, IllegalAccessException;

    public double getBtcBalanceInCurrency(String address, String currency) throws IOException, NoSuchFieldException, IllegalAccessException;
}
