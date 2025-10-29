CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    amount NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL REFERENCES users(id)
);

CREATE INDEX idx_orders_user_id ON orders(user_id);

