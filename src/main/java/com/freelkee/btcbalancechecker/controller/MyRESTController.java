package com.freelkee.btcbalancechecker.controller;

import com.freelkee.btcbalancechecker.model.Transaction;
import com.freelkee.btcbalancechecker.service.BtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController    //контроллер, управляющий рест запросами и ответами
public class MyRESTController {

    @Autowired
    private BtcService btcService;

    @GetMapping("/balance/{address}")
    public Transaction showBtcBalance(@PathVariable String address) throws IOException {
        Transaction transaction = new Transaction();
        double balance = btcService.getBalance(address);
        transaction.setAddress(address);
        transaction.setAmount(balance);
        btcService.saveTransaction(transaction);
        return transaction;

    }

    @GetMapping("/balance/{currency}/{address}")
    public Transaction showBtcBalanceInCurrency(@PathVariable String address, @PathVariable String currency) throws IOException, NoSuchFieldException, IllegalAccessException {
        Transaction transaction = new Transaction();
        double balance = btcService.getBalance(address);
        double balanceInCurrency = btcService.getBtcBalanceInCurrency(address, currency);
        transaction.setCurrency(currency);
        transaction.setAmountInCurrency(balanceInCurrency);
        transaction.setAddress(address);
        transaction.setAmount(balance);
        btcService.saveTransaction(transaction);
        return transaction;

    }
}
