select count(*) as all_rows from employee;

select count(distinct firstName) as distinct_first_names from employee;

select count(*) - count(distinct firstName) as duplicate_first_names from employee;

select count(*) as repetitions, firstName
   from employee
   group by firstName
   having repetitions > 2;