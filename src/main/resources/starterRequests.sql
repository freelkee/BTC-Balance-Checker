CREATE TABLE IF NOT EXISTS wallet
(
    address            VARCHAR(255) NOT NULL PRIMARY KEY,
    date               TIMESTAMP    NOT NULL,
    currency           VARCHAR(10),
    amount             NUMERIC(20, 8),
    amount_in_currency NUMERIC(20, 8)
);
CREATE TABLE IF NOT EXISTS txs
(
    id     INTEGER PRIMARY KEY,
    date   TIMESTAMP,
    amount DOUBLE PRECISION
);
ALTER TABLE txs
    ADD COLUMN fk_wallet VARCHAR references wallet (address)