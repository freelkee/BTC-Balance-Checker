package com.freelkee.btcbalancechecker.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.TickerResponse;
import com.freelkee.btcbalancechecker.model.Transaction;
import com.freelkee.btcbalancechecker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

@Service
public class BtcServiceImpl implements BtcService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public double getBalance(String address) throws IOException {
        String url = "https://blockchain.info/rawaddr/" + address;
        ObjectMapper objectMapper = new ObjectMapper();
        BlockchainInfoResponse response = objectMapper.readValue(new URL(url), BlockchainInfoResponse.class);
        String balanceStr = String.valueOf(response.getFinal_balance());

        int diff = 8 - balanceStr.length();

        StringBuilder stringBuilder = new StringBuilder();

        if (diff >= 0) {
            stringBuilder.append("0.");
            stringBuilder.append("0".repeat(diff));
            stringBuilder.append(balanceStr);
        } else {
            stringBuilder.append(balanceStr, 0, -diff).append(".").append(balanceStr, -diff, balanceStr.length());
        }
        return Double.parseDouble(stringBuilder.toString());
    }

    @Override
    public double getTickerValue(TickerResponse ticker, String currency) throws NoSuchFieldException, IllegalAccessException {
        Field field = ticker.getClass().getDeclaredField(currency);
        field.setAccessible(true);
        TickerResponse.Currency currencyValue = (TickerResponse.Currency) field.get(ticker);
        return Double.parseDouble(currencyValue.getLast());
    }

    @Override
    public double getBtcBalanceInCurrency(String address, String currency) throws IOException, NoSuchFieldException, IllegalAccessException {
        ObjectMapper objectMapper = new ObjectMapper();
        String url = "https://www.blockchain.com/ru/ticker";
        TickerResponse response = objectMapper.readValue(new URL(url), TickerResponse.class);
        double roundScale = Math.pow(10, 2);
        return Math.ceil(getTickerValue(response, currency) * getBalance(address) * roundScale) / roundScale;
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransaction(String currency, String bitcoinAddress) throws IOException {
        String mainUrl = "http://localhost:8080/balance/";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(currency.equals("") ?
                new URL(mainUrl + bitcoinAddress) :
                new URL(mainUrl  + currency + "/" + bitcoinAddress), Transaction.class);
    }
}
