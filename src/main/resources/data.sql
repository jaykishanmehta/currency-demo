DROP TABLE IF EXISTS IQ_TAGS;

CREATE TABLE CC_CURRENCY (
  id INT AUTO_INCREMENT PRIMARY KEY,
  code VARCHAR(5) NOT NULL,
  name VARCHAR(64) NOT NULL
);

INSERT INTO CC_CURRENCY (code, name) VALUES
('usd', 'United States dollar'),
('inr', 'Indian rupee')
('eur', 'Euro');