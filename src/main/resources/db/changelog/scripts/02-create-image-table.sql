-- Create image table
CREATE TABLE image
(
    id         SERIAL PRIMARY KEY,
    shopify_id numeric,
    src        text,
    position   numeric,
    product_id INTEGER,
    CONSTRAINT fk_product
        FOREIGN KEY (product_id)
            REFERENCES product (id)
            ON DELETE CASCADE
);

-- Alter product table to add image_id and create a foreign key constraint
ALTER TABLE product
    add column
        image_id INTEGER;

ALTER TABLE product
    ADD
        CONSTRAINT fk_primary_image
            FOREIGN KEY (image_id)
                REFERENCES image (id)
                ON DELETE SET NULL;