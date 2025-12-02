INSERT INTO t_category (category) VALUES ('Smartphones');
INSERT INTO t_category (category) VALUES ('Headphones');

INSERT INTO t_country (code, country) VALUES ('US', 'United States');
INSERT INTO t_country (code, country) VALUES ('KR', 'South Korea');
INSERT INTO t_country (code, country) VALUES ('KZ', 'Kazakhstan');

INSERT INTO t_item (name, description, price, category_id) VALUES ('iPhone 15 Pro', 'Powerful flagship smartphone', 639980, 1);
INSERT INTO t_item (name, description, price, category_id) VALUES ('HyperX Cloud II', 'Popular Gaming Headphones', 30000, 2);

INSERT INTO t_item_countries (item_id, countries_id) VALUES (1, 1);
INSERT INTO t_item_countries (item_id, countries_id) VALUES (1, 3);
INSERT INTO t_item_countries (item_id, countries_id) VALUES (2, 2);