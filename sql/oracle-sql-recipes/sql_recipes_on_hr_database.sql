-- Basic selecetion
SELECT * FROM EMPLOYEES;
describe EMPLOYEES;
/** Summaraizing the Values of a Column **/
-- Query Avarage salary of employees using the AVG() Aggregate Function:
SELECT AVG(e.salary) AS avg_salary
FROM EMPLOYEES e;
-- Query Total salary of employees using the SUN() Aggregate Function:
SELECT AVG(e.salary) AS avg_salary
FROM EMPLOYEES e;
-- Query Count of employees using the COUNT() Aggregate Function:
SELECT COUNT(*) AS all_employees
FROM EMPLOYEES e;
/** Summaraizing the Data for Different Groups **/
SELECT e.DEPARTMENT_ID,
  AVG(e.salary) AS avg_salary
FROM EMPLOYEES e
GROUP BY e.DEPARTMENT_ID;
--Summaraizing the Data by Multiple Columns:
SELECT e.DEPARTMENT_ID,
  e.JOB_ID,
  MIN(e.SALARY) AS MIN_SALARY,
  AVG(e.SALARY) AS AVG_SALARY,
  MAX(e.SALARY) AS MAX_SALARY
FROM EMPLOYEES e
GROUP BY e.DEPARTMENT_ID,
  e.JOB_ID;
--Summaraizing the Data by Multiple Columns with Order by departament descending:
SELECT e.DEPARTMENT_ID,
  e.JOB_ID,
  MIN(e.SALARY) AS MIN_SALARY,
  AVG(e.SALARY) AS AVG_SALARY,
  MAX(e.SALARY) AS MAX_SALARY
FROM EMPLOYEES e
GROUP BY e.DEPARTMENT_ID,
  e.JOB_ID
ORDER BY e.DEPARTMENT_ID,
  MIN_SALARY DESC;


-- Using an Inline View formed by subquery
select D.DEPARTMENT_NAME from (select DEPARTMENT_ID, DEPARTMENT_NAME from DEPARTMENTS where LOCATION_ID != 1700) D;
