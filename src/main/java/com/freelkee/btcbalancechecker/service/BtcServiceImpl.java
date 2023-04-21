package com.freelkee.btcbalancechecker.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelkee.btcbalancechecker.entity.Transaction;
import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.TickerResponse;
import com.freelkee.btcbalancechecker.model.Wallet;
import com.freelkee.btcbalancechecker.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

@Service
public class BtcServiceImpl implements BtcService {
    @Autowired
    private TransactionalRepository transactionalRepository;

    @Override
    public BlockchainInfoResponse getResponse(String address, int offset) throws IOException {
        String url = "https://blockchain.info/rawaddr/" + address + "?offset=" + offset;
        return new ObjectMapper().readValue(new URL(url), BlockchainInfoResponse.class);
    }


    @Override
    public double getTickerValue(TickerResponse ticker, String currency) throws NoSuchFieldException, IllegalAccessException {
        Field field = ticker.getClass().getDeclaredField(currency);
        field.setAccessible(true);
        TickerResponse.Currency currencyValue = (TickerResponse.Currency) field.get(ticker);
        return Double.parseDouble(currencyValue.getLast());
    }


    public void saveTransaction(Wallet wallet) {
        Transaction existingTransaction = transactionalRepository.findByAddress(wallet.getAddress()).orElse(null);
        if (existingTransaction == null) {
            existingTransaction = new Transaction();
            existingTransaction.setAmount(wallet.getAmount());
            existingTransaction.setAddress(wallet.getAddress());
            transactionalRepository.save(existingTransaction);
        }
    }

    @Override
    public Wallet getWallet(String currency, String bitcoinAddress, int offset) throws IOException {
        String mainUrl = "http://localhost:8080/balance/";
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(currency.equals("") ?
                new URL(mainUrl + bitcoinAddress + "?offset=" + offset) :
                new URL(mainUrl + currency + "/" + bitcoinAddress + "?offset=" + offset), Wallet.class);
    }
}
