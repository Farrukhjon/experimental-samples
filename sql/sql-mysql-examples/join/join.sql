-- Get employees who has also SQL skill.
SELECT
  e.id,
  e.name,
  s.skillName
FROM employee e INNER JOIN employee_skills es ON e.id = es.ManyToManyTest$Employee_id
  INNER JOIN skills s ON es.skills_id = s.id
WHERE s.skillName = 'SQL';