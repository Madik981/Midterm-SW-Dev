CREATE TABLE t_category (
    id BIGSERIAL PRIMARY KEY,
    category VARCHAR(255) NOT NULL
);
CREATE TABLE t_country (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(10) NOT NULL,
    country VARCHAR(255) NOT NULL
);
CREATE TABLE t_item (
    id BIGSERIAL primary key,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price INT,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES t_category(id)
);

CREATE TABLE t_item_countries (
    item_id BIGINT NOT NULL,
    countries_id BIGINT NOT NULL,
    PRIMARY KEY (item_id, countries_id),
    FOREIGN KEY (item_id) REFERENCES t_item(id),
    FOREIGN KEY (countries_id) REFERENCES t_country(id)
);

