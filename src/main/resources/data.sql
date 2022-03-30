DROP TABLE IF EXISTS CC_CURRENCY_MASTER;

CREATE TABLE CC_CURRENCY_MASTER (
  id INT AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(5) NOT NULL,
  name VARCHAR(64) NOT NULL
);

INSERT INTO CC_CURRENCY_MASTER (code, name) VALUES
('usd', 'United States dollar'),
('inr', 'Indian rupee'),
('eur', 'Euro'),
('zar', 'South African rand');

DROP TABLE IF EXISTS CC_CURRENCY_RATES_MASTER;

CREATE TABLE CC_CURRENCY_RATES_MASTER (
  id INT AUTO_INCREMENT PRIMARY KEY,
  from_currency INT NOT NULL,
  to_currency INT NOT NULL,
  rate NUMBER NOT NULL
);

INSERT INTO CC_CURRENCY_RATES_MASTER (from_currency, to_currency, rate) VALUES
(3, 1, 1.10488),
(1, 3, 0.90494),
(4, 3, 0.06194),
(3, 4, 16.1303),
(4, 1, 0.06843),
(1, 4, 14.5974),
(1, 2, 75.5935),
(2, 1, 0.01321);