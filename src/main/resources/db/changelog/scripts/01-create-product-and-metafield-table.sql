-- Create product table
CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    created      timestamp(6),
    updated      timestamp(6),
    body_html    text,
    handle       text,
    shopify_id   text,
    product_type text,
    published_at timestamptz,
    updated_at   timestamptz,
    created_at   timestamptz,
    title        text,
    vendor       text,
    tags         text
);

-- Create metafield table
CREATE TABLE metafield
(
    id         SERIAL PRIMARY KEY,
    created    timestamp(6),
    updated    timestamp(6),
    shopify_id text    NOT NULL,
    namespace  text    NOT NULL,
    key        text    NOT NULL,
    value      text    NOT NULL,
    product_id INTEGER NOT NULL,
    CONSTRAINT fk_product
        FOREIGN KEY (product_id)
            REFERENCES product (id)
            ON DELETE CASCADE
);