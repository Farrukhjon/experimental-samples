
---get all schemas
select au.username from sys.all_users au;

alter session set current_schema=hr;

select  dbat.TABLE_NAME from dba_tables dbat where dbat.OWNER='HR';

password;