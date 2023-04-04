package com.freelkee.btcbalancechecker.controller;

import com.freelkee.btcbalancechecker.service.BtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController    //контроллер, управляющий рест запросами и ответами
//@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private BtcService btcService;

    @GetMapping("/balance/{address}")
    public double showBtcBalance(@PathVariable String address) throws IOException {
        return btcService.getBalance(address);
    }
    @GetMapping("/balance/{currency}/{address}")
    public double showBtcBalanceInCurrency(@PathVariable String address, @PathVariable String currency) throws IOException, NoSuchFieldException, IllegalAccessException {
        return btcService.getBtcBalanceInCurrency(address,currency);
    }
}
