CREATE TABLE transaction (
                             id SERIAL PRIMARY KEY,
                             date TIMESTAMP NOT NULL,
                             wallet_address VARCHAR(255) NOT NULL,
                             currency VARCHAR(10) ,
                             amount NUMERIC(20,8) ,
                             note TEXT,
                             amount_in_currency NUMERIC(20,8)
    );