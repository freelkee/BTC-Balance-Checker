package com.freelkee.btcbalancechecker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TickerResponse {
    @JsonProperty("USD")
    private Currency USD;
    @JsonProperty("RUB")
    private Currency RUB;
    @JsonProperty("EUR")
    private Currency EUR;
    @JsonProperty("ARS")
    private Currency ARS;
    @JsonProperty("AUD")
    private Currency AUD;
    @JsonProperty("BRL")
    private Currency BRL;
    @JsonProperty("CAD")
    private Currency CAD;
    @JsonProperty("CHF")
    private Currency CHF;
    @JsonProperty("CLP")
    private Currency CLP;
    @JsonProperty("CNY")
    private Currency CNY;
    @JsonProperty("CZK")
    private Currency CZK;
    @JsonProperty("DKK")
    private Currency DKK;
    @JsonProperty("GBP")
    private Currency GBP;
    @JsonProperty("HKD")
    private Currency HKD;
    @JsonProperty("HRK")
    private Currency HRK;
    @JsonProperty("HUF")
    private Currency HUF;
    @JsonProperty("INR")
    private Currency INR;
    @JsonProperty("ISK")
    private Currency ISK;
    @JsonProperty("JPY")
    private Currency JPY;
    @JsonProperty("KRW")
    private Currency KRW;
    @JsonProperty("NZD")
    private Currency NZD;
    @JsonProperty("PLN")
    private Currency PLN;
    @JsonProperty("RON")
    private Currency RON;
    @JsonProperty("SEK")
    private Currency SEK;
    @JsonProperty("SGD")
    private Currency SGD;
    @JsonProperty("THB")
    private Currency THB;
    @JsonProperty("TRY")
    private Currency TRY;
    @JsonProperty("TWD")
    private Currency TWD;


    // inner class for currency object

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Currency {
        @JsonProperty("15m")
        private String m15;
        private String last;
        private String buy;
        private String sell;
        private String symbol;
    }
}