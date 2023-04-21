package com.freelkee.btcbalancechecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockchainInfoResponse {
    private String hash160;
    private String address;

    @JsonProperty("n_tx")
    private int nTx;
    @JsonProperty("total_received")
    private long totalReceived;
    @JsonProperty("total_sent")
    private long totalSent;
    @JsonProperty("final_balance")
    private long finalBalance;
    private List<BlockchainResponseTx> txs;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BlockchainResponseTx {
        private String hash;
        private long ver;
        private long vin_sz;
        private long vout_sz;
        private long size;
        private long weight;
        private long fee;
        private String relayed_by;
        private long lock_time;
        private long tx_index;
        private long time;
        private long block_height;
        private Input[] inputs;
        private Out[] out;
        private long result;
        private long balance;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Input {
        private long sequence;
        private String witness;
        private String script;
        private int index;
        private PrevOut prev_out;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class PrevOut {
            private String addr;
            private int n;
            private String script;
            private List<SpendingOutpoint> spending_outpoints;
            private boolean spent;
            private long tx_index;
            private int type;
            private long value;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SpendingOutpoint {
            private int n;
            private long tx_index;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Out {
        private int type;
        private boolean spent;
        private long value;
        private List<SpendingOutpoint> spending_outpoints;
        private int n;
        private long tx_index;
        private String script;
        private String addr;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SpendingOutpoint {
            private int n;
            private long tx_index;
        }
    }
}

