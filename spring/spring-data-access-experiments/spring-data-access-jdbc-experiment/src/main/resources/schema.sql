CREATE TABLE country (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR,
  popilation INT
);

CREATE TABLE city(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR,
  countryCode VARCHAR,
  district VARCHAR,
  population INT
);

