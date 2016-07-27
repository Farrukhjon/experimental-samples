select * from employee;

select e.* from manager m, employee e where m.id = e.id;


SELECT 
    e.firstName,
    e.lastName,
    e.birthDate,
    r.name AS roleName,
    d.name AS depName
FROM
    employee e
        INNER JOIN
    role r ON e.roleId = r.id
        INNER JOIN
    departament d ON e.depId = d.id;
