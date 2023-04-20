package com.freelkee.btcbalancechecker.controller;

import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.Transaction;
import com.freelkee.btcbalancechecker.model.Tx;
import com.freelkee.btcbalancechecker.service.BtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.freelkee.btcbalancechecker.model.BlockchainInfoResponse.BlockchainResponseTx;

@RestController    //контроллер, управляющий рест запросами и ответами
public class MyRESTController {

    @Autowired
    private BtcService btcService;

    @GetMapping("/balance/{address}")
    public Transaction showWalletInfo(@PathVariable String address) throws IOException {
        Transaction transaction = new Transaction();
        BlockchainInfoResponse blockchainInfoResponse = btcService.getResponse(address);
        transaction.setAddress(address);
        transaction.setAmount(blockchainInfoResponse.getFinalBalance() * 0.00000001d);
        List<Tx> txs = new ArrayList<>();
        List<BlockchainResponseTx> oldTxs = blockchainInfoResponse.getTxs();
        for (BlockchainResponseTx oldTx : oldTxs) {
            Tx newTxs = new Tx();
            newTxs.setAmount(oldTx.getResult() * 0.00000001);
            newTxs.setDate(new Timestamp(oldTx.getTime() * 1000));
            txs.add(newTxs);
        }
        transaction.setTxs(txs);
        btcService.saveTransaction(transaction);
        return transaction;
    }

    @GetMapping("/balance/{currency}/{address}")
    public Transaction showBtcBalanceInCurrency(@PathVariable String address, @PathVariable String currency) throws IOException, NoSuchFieldException, IllegalAccessException {
        Transaction transaction = new Transaction();
        BlockchainInfoResponse blockchainInfoResponse = btcService.getResponse(address);
        transaction.setAddress(address);
        transaction.setAmount(((double) blockchainInfoResponse.getFinalBalance()) * 0.00000001);
        List<Tx> txs = new ArrayList<>();
        List<BlockchainResponseTx> oldTxs = blockchainInfoResponse.getTxs();
        for (BlockchainResponseTx oldTx : oldTxs) {
            Tx newTxs = new Tx();
            newTxs.setAmount(oldTx.getResult() * 0.00000001);
            newTxs.setDate(new Timestamp(oldTx.getTime() * 1000));
            txs.add(newTxs);
        }
        transaction.setTxs(txs);

        double balanceInCurrency = btcService.getBtcBalanceInCurrency(address, currency);
        transaction.setCurrency(currency);
        transaction.setAmountInCurrency(balanceInCurrency);

        btcService.saveTransaction(transaction);
        return transaction;

    }
}
