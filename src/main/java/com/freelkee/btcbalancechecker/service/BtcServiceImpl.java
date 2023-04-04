package com.freelkee.btcbalancechecker.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.TickerResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;

@Service
public class BtcServiceImpl implements BtcService {


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
            for (int i = 0; i < diff; i++) {
                stringBuilder.append("0");
            }
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
        return getTickerValue(response,currency) * getBalance(address);
    }
}
