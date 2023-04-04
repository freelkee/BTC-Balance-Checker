package com.freelkee.btcbalancechecker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public Currency getARS() {
        return ARS;
    }

    public void setARS(Currency ARS) {
        this.ARS = ARS;
    }

    public Currency getAUD() {
        return AUD;
    }

    public void setAUD(Currency AUD) {
        this.AUD = AUD;
    }

    public Currency getBRL() {
        return BRL;
    }

    public void setBRL(Currency BRL) {
        this.BRL = BRL;
    }

    public Currency getCAD() {
        return CAD;
    }

    public void setCAD(Currency CAD) {
        this.CAD = CAD;
    }

    public Currency getCHF() {
        return CHF;
    }

    public void setCHF(Currency CHF) {
        this.CHF = CHF;
    }

    public Currency getCLP() {
        return CLP;
    }

    public void setCLP(Currency CLP) {
        this.CLP = CLP;
    }

    public Currency getCNY() {
        return CNY;
    }

    public void setCNY(Currency CNY) {
        this.CNY = CNY;
    }

    public Currency getCZK() {
        return CZK;
    }

    public void setCZK(Currency CZK) {
        this.CZK = CZK;
    }

    public Currency getDKK() {
        return DKK;
    }

    public void setDKK(Currency DKK) {
        this.DKK = DKK;
    }

    public Currency getGBP() {
        return GBP;
    }

    public void setGBP(Currency GBP) {
        this.GBP = GBP;
    }

    public Currency getHKD() {
        return HKD;
    }

    public void setHKD(Currency HKD) {
        this.HKD = HKD;
    }

    public Currency getHRK() {
        return HRK;
    }

    public void setHRK(Currency HRK) {
        this.HRK = HRK;
    }

    public Currency getHUF() {
        return HUF;
    }

    public void setHUF(Currency HUF) {
        this.HUF = HUF;
    }

    public Currency getINR() {
        return INR;
    }

    public void setINR(Currency INR) {
        this.INR = INR;
    }

    public Currency getISK() {
        return ISK;
    }

    public void setISK(Currency ISK) {
        this.ISK = ISK;
    }

    public Currency getJPY() {
        return JPY;
    }

    public void setJPY(Currency JPY) {
        this.JPY = JPY;
    }

    public Currency getKRW() {
        return KRW;
    }

    public void setKRW(Currency KRW) {
        this.KRW = KRW;
    }

    public Currency getNZD() {
        return NZD;
    }

    public void setNZD(Currency NZD) {
        this.NZD = NZD;
    }

    public Currency getPLN() {
        return PLN;
    }

    public void setPLN(Currency PLN) {
        this.PLN = PLN;
    }

    public Currency getRON() {
        return RON;
    }

    public void setRON(Currency RON) {
        this.RON = RON;
    }

    public Currency getSEK() {
        return SEK;
    }

    public void setSEK(Currency SEK) {
        this.SEK = SEK;
    }

    public Currency getSGD() {
        return SGD;
    }

    public void setSGD(Currency SGD) {
        this.SGD = SGD;
    }

    public Currency getTHB() {
        return THB;
    }

    public void setTHB(Currency THB) {
        this.THB = THB;
    }

    public Currency getTRY() {
        return TRY;
    }

    public void setTRY(Currency TRY) {
        this.TRY = TRY;
    }

    public Currency getTWD() {
        return TWD;
    }

    public void setTWD(Currency TWD) {
        this.TWD = TWD;
    }

    public Currency getUSD() {
        return USD;
    }

    public void setUSD(Currency USD) {
        this.USD = USD;
    }

    public Currency getRUB() {
        return RUB;
    }

    public void setRUB(Currency RUB) {
        this.RUB = RUB;
    }

    public Currency getEUR() {
        return EUR;
    }

    public void setEUR(Currency EUR) {
        this.EUR = EUR;
    }
    // inner class for currency object

    public static class Currency {
        @JsonProperty("15m")
        private String m15;

        private String last;
        private String buy;
        private String sell;
        private String symbol;

        // getters and setters

        public String getLast() {
            return last;
        }

        public String getM15() {
            return m15;
        }

        public void setM15(String m15) {
            this.m15 = m15;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getBuy() {
            return buy;
        }

        public void setBuy(String buy) {
            this.buy = buy;
        }

        public String getSell() {
            return sell;
        }

        public void setSell(String sell) {
            this.sell = sell;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }
}