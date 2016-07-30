SELECT
  p.id_pursishnoma,
  m.surname,
  s.name,
  avg(baho) AS avg1
FROM
  pursishnoma AS p
  INNER JOIN
  muallim AS m
  INNER JOIN
  savol s ON (p.id_savol = s.id_savol)
             AND (p.id_muallim = m.id_muallim)
GROUP BY p.id_savol
ORDER BY p.id_savol; 