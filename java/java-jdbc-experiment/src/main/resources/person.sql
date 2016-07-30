DROP TABLE IF EXISTS person;
CREATE TABLE IF NOT EXISTS person (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  surname    VARCHAR(100),
  name       VARCHAR(100),
  patronymic VARCHAR(100),
  id_address INT UNSIGNED          DEFAULT NULL,
  KEY key_address(id_address),
  CONSTRAINT fk_address FOREIGN KEY key_address(id_address) REFERENCES address (id)
)
  ENGINE = innodb
  AUTO_INCREMENT = 1
  CHARSET = utf8;
