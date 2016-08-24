-- List all data from database.
SELECT * FROM INFORMATION_SCHEMA.SCHEMATA;

-- List all databases hosted in the server.
SELECT SCHEMA_NAME as dbs FROM INFORMATION_SCHEMA.SCHEMATA;

-- List all tables from database.
SELECT TABLE_NAME as tables FROM INFORMATION_SCHEMA.TABLES;