CREATE TABLESPACE tbs_learner
  datafile 'learner.dat'
  size 20M
  reuse
  autoextend ON;
  
CREATE TEMPORARY TABLESPACE temp_tbs_learner
  tempfile 'temp_learner.dat'
  size 10M
  reuse
  autoextend ON;


CREATE USER learner
  IDENTIFIED BY passwd
  DEFAULT TABLESPACE tbs_learner
  quota 10M ON tbs_learner
  TEMPORARY TABLESPACE temp_tbs_learner;
  

SELECT * FROM DBA_TAB_PRIVS where GRANTABLE = 'YES';

GRANT
  CREATE session,
  create table,
  create view,
  create synonym
  TO learner;