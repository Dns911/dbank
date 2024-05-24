-- Create table accounts
CREATE TABLE IF NOT EXISTS operation_service.t_account
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_id        BIGINT,
    account_number BIGINT UNIQUE NOT NULL,
    currency       VARCHAR(5),
    balance        DECIMAL(15, 4) default 0.0,
    is_default     BOOLEAN,
    account_status VARCHAR(32),
    created_at     TIMESTAMP     NOT NULL,
    updated_at     TIMESTAMP
);

-- Create table cards
CREATE TABLE IF NOT EXISTS operation_service.t_card
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    card_number     BIGINT UNIQUE NOT NULL,
    account_id      BIGINT,
    expire_date     TIMESTAMP     NOT NULL,
    card_profile_id BIGINT,
    card_status     VARCHAR(32),
    created_at      TIMESTAMP     NOT NULL,
    updated_at      TIMESTAMP
);

-- Create table payments
CREATE TABLE IF NOT EXISTS operation_service.t_payment
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_id                  BIGINT,
    card_id                  BIGINT,
    currency                 VARCHAR(5),
    amount                   DECIMAL(10, 2),
    account_currency         VARCHAR(5),
    account_amount           DECIMAL(10, 2),
    payment_date             TIMESTAMP NOT NULL,
    recipient_account_number VARCHAR(64),
    recipient_details        VARCHAR(255),
    payment_status           VARCHAR(32),
    payment_details          VARCHAR(255),
    created_at               TIMESTAMP NOT NULL,
    updated_at               TIMESTAMP
);

-- Create table card type
CREATE TABLE IF NOT EXISTS operation_service.t_card_profile
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    profile_name   VARCHAR(32),
    monthly_amount DECIMAL(10, 2),
    valid_period   INT,
    is_active      BOOLEAN,
    created_at     TIMESTAMP NOT NULL,
    updated_at     TIMESTAMP
);