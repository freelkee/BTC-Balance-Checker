package com.freelkee.btcbalancechecker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freelkee.btcbalancechecker.model.BlockchainInfoResponse;
import com.freelkee.btcbalancechecker.model.TickerResponse;
import com.freelkee.btcbalancechecker.model.Wallet;
import com.freelkee.btcbalancechecker.model.Wallet.Tx;
import com.freelkee.btcbalancechecker.service.BtcService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.freelkee.btcbalancechecker.model.BlockchainInfoResponse.BlockchainResponseTx;

@RestController    //контроллер, управляющий рест запросами и ответами
@RequestMapping("/api")
@Tag(name="REST Controller", description="The main REST API controller")

public class MyRESTController {

    @Autowired
    private BtcService btcService;

    @GetMapping("/balance/{address}")
    @Operation(
            summary = "Wallet",
            description = "Get the wallet balance and transactions made"
    )

    public Wallet showWalletInfo(@PathVariable @Parameter(description = "BTC address") String address,
                                 @RequestParam(value = "offset", defaultValue = "0")
                                 @Parameter(description = "how many transactions from the last one to skip") int offset)
            throws IOException, NoSuchFieldException, IllegalAccessException {
        return getTransaction(address, null, offset);
    }

    @GetMapping("/balance/{currency}/{address}")
    @Operation(
            summary = "Wallet in currency",
            description = "Get the wallet balance in the currency and the transactions made"
    )
    public Wallet showBtcBalanceInCurrency(@PathVariable @Parameter(description = "BTC address") String address,
                                           @PathVariable @Parameter(description = "Currency reduction") String currency,
                                           @RequestParam(value = "offset", defaultValue = "0")
                                           @Parameter(description = "How many transactions from the last one to skip") int offset)
            throws IOException, NoSuchFieldException, IllegalAccessException {
        return getTransaction(address, currency, offset);
    }

    private Wallet getTransaction(String address, String currency, int offset) throws IOException, NoSuchFieldException, IllegalAccessException {
        Wallet wallet = new Wallet();
        BlockchainInfoResponse blockchainInfoResponse = btcService.getResponse(address, offset);

        wallet.setAddress(address);
        double amount = blockchainInfoResponse.getFinalBalance() * 0.00000001;
        wallet.setAmount(amount);
        wallet.setDate(new Timestamp(System.currentTimeMillis()));

        List<Tx> txs = new ArrayList<>();
        for (BlockchainResponseTx oldTx : blockchainInfoResponse.getTxs()) {
            Tx newTxs = new Tx();
            newTxs.setId(oldTx.getTx_index());
            newTxs.setAmount(oldTx.getResult() * 0.00000001);
            newTxs.setDate(new Timestamp(oldTx.getTime() * 1000));
            txs.add(newTxs);
        }
        wallet.setTxs(txs);

        if (currency != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String url = "https://www.blockchain.com/ru/ticker";
            TickerResponse response = objectMapper.readValue(new URL(url), TickerResponse.class);
            double roundScale = Math.pow(10, 2);
            double balanceInCurrency = Math.ceil(btcService.getTickerValue(response, currency) *
                    amount * roundScale) / roundScale;

            wallet.setCurrency(currency);
            wallet.setAmountInCurrency(balanceInCurrency);
        }

        btcService.saveTransaction(wallet);
        return wallet;
    }
}
