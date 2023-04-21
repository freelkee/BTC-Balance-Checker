package com.freelkee.btcbalancechecker.controller;

import com.freelkee.btcbalancechecker.model.Wallet;
import com.freelkee.btcbalancechecker.service.BtcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class MyController {
    @Autowired
    private BtcService btcService;

    @GetMapping("/")
    public String showStartPage() {
        return "start";
    }

    @PostMapping("/process")
    public String processForm(@RequestParam("currency") String currency,
                              @RequestParam("bitcoinAddress") String bitcoinAddress,
                              Model model) throws IOException {

        Wallet wallet = btcService.getWallet(currency, bitcoinAddress);
        model.addAttribute("transaction", wallet);
        return "result";
    }

    @GetMapping("/info")
    public String showInfoPage() {
        return "info";
    }

    @GetMapping("/contacts")
    public String showContactsPage() {
        return "contacts";
    }


}
