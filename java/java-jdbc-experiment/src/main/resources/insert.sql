insert into savol(name) values
			('savol1'),
			('savol2'),
			('savol3'),
			('savol4'),
			('savol4');

insert into muallim(surname, name, patronymic) values 
						('Aliev', 'Vali', 'Samievich'),
						('Solieva','Kudbi','Ahmedovna'),
						('Dostov','Bolga','Teshaevich');

insert into pursishnoma(id_muallim, id_savol, baho) values
					(1, 1, 1),
					(1, 2, 4),
					(1, 3, 3),
					(1, 4, 2),
					(2, 1, 4),
					(2, 2, 4),
					(2, 3, 1),
					(2, 4, 1),
					(3, 1, 3),
					(3, 2, 3),
					(3, 3, 3),
					(3, 4, 3);
insert into pursishnoma(id_muallim, id_savol, baho) values 
					(1, 5, 1),
					(2, 5, 2),
					(3, 5, 4);