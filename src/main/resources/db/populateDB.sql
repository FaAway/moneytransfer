DELETE FROM account;
DELETE FROM currency;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO currency (id, iso_currency_code, name)
VALUES (100000, 'RUB', 'Российский рубль'),
       (100001, 'USD', 'Доллар США'),
       (100002, 'EUR', 'Евро');

INSERT INTO account (id, name, amount, currency_id)
VALUES (100010, 'Account 1', '150000', '100000'),
       (100011, 'Account 2', '3000000', '100000'),
       (100012, 'Account 3', '0', '100000');
