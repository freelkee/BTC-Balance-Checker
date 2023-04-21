CREATE TABLE IF NOT EXISTS transaction
(
    date               TIMESTAMP    NOT NULL,
    address            VARCHAR(255) NOT NULL PRIMARY KEY,
    amount             NUMERIC(20, 8)
);

