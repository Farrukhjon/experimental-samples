-- Creating tablespace
CREATE TABLESPACE tbs_experimental
  DATAFILE 'tbs_experimental.dat' -- By default the file is created in the ../server/database
    SIZE 20M
  ONLINE;
  
-- Create Temporary tablespace
CREATE TEMPORARY TABLESPACE tmp_tbs_exp
  TEMPFILE 'tmp_tbs_exp.dat'
  size 10M
  AUTOEXTEND ON;

-- Creating user/schema  
CREATE USER usrexp
  IDENTIFIED BY abcpasswd
  DEFAULT TABLESPACE tbs_experimental
  QUOTA 10M ON tbs_experimental
  TEMPORARY TABLESPACE tmp_tbs_exp;

-- Granting privileges
GRANT
CREATE session TO usrexp;

-- Dropping disconnected user and all its objects
DROP USER usrexp CASCADE;
