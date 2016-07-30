DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
  id         INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_person  INT UNSIGNED NOT NULL,
  experiance INT,
  salary     DOUBLE,
  KEY key_person (id_person),
  CONSTRAINT fk_person FOREIGN KEY (id_person) REFERENCES person (id)
)
  ENGINE = innodb
  CHARSET = utf8
  AUTO_INCREMENT = 1;