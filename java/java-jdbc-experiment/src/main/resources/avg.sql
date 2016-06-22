select 
    p.id_pursishnoma, m.surname, s.name, avg(baho) as avg1
from
    pursishnoma as p
        inner join
    muallim as m
        inner join
    savol s ON (p.id_savol = s.id_savol)
        and (p.id_muallim = m.id_muallim)
group by p.id_savol
order by p.id_savol; 