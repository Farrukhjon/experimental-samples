DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
  id          INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_employee INT UNSIGNED NOT NULL,
  username    VARCHAR(100),
  password    VARCHAR(100),
  KEY key_employee(id_employee),
  CONSTRAINT fk_employee FOREIGN KEY key_employee(id_employee) REFERENCES employee (id)
)
  ENGINE = innodb
  CHARSET = utf8
  AUTO_INCREMENT = 1;