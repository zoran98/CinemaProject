INSERT INTO `user` (id, username, password, date, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','23.02.2021.' ,'ADMIN');
INSERT INTO `user` (id, username, password, date, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','23.05.2021.', 'KORISNIK');
INSERT INTO `user` (id, username, password, date, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','23.08.2021.', 'KORISNIK');

INSERT INTO sale (id, naziv) VALUES (1, 'Sala1');
INSERT INTO sale (id, naziv) VALUES (2, 'Sala2');
INSERT INTO sale (id, naziv) VALUES (3, 'Sala3');
              
INSERT INTO tipovi_projekcija (id, naziv, sala_id) VALUES (1, '2D', 1);
INSERT INTO tipovi_projekcija (id, naziv, sala_id) VALUES (2, '3D', 2);
INSERT INTO tipovi_projekcija (id, naziv, sala_id) VALUES (3, '4D', 3);



INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (1, 'Bekstvo iz Sosenka', 'Pera Peric', 'Marko Nikolic', 'Drama, Triler', 120, 'Warner Bros', 'Srbija', 1994, 'Opis1');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (2, 'Batman: Begins', 'Pera Peric 2', 'Marko Nikolic2', 'Triler', 150, 'FilmFleks', 'Hrvatska', 2005, 'Opis2');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (3, 'Batman: The Dark Knight', 'Pera Peric 3', 'Marko Nikolic3', 'Action', 130, 'FilmFleks', 'Slovenija', 2008, 'Opis3');

INSERT INTO projekcije (id, film_id, tip_projekcije_id, sala_id, datum_i_vreme_prikazivanja, cena_karte, user_id) 
    VALUES (1, 1, 1, 1, '2020-06-21 20:00', 1500.50, 1);
INSERT INTO projekcije (id, film_id, tip_projekcije_id, sala_id, datum_i_vreme_prikazivanja, cena_karte, user_id) 
    VALUES (2, 2, 2, 2, '2020-07-22 21:00', 1600.50, 2);
INSERT INTO projekcije (id, film_id, tip_projekcije_id, sala_id, datum_i_vreme_prikazivanja, cena_karte, user_id) 
    VALUES (3, 3, 3, 3, '2020-06-22 20:00', 1700.50, 3);
    

--INSERT INTO sedista (id, redni_broj, sala_id, karta_id) VALUES (1, 5, 1, 1);
--INSERT INTO sedista (id, redni_broj, sala_id, karta_id) VALUES (2, 6, 2, 2);
--INSERT INTO sedista (id, redni_broj, sala_id, karta_id) VALUES (3, 7, 3, 3);
    
INSERT INTO karte (id, projekcija_id, datum_i_vreme_prodaje, user_id) VALUES (1, 1, '2020-08-10 18:00', 1);
INSERT INTO karte (id, projekcija_id, datum_i_vreme_prodaje, user_id) VALUES (2, 2, '2020-08-12 19:00', 2);
INSERT INTO karte (id, projekcija_id, datum_i_vreme_prodaje, user_id) VALUES (3, 3, '2020-08-14 20:00', 3);

	
	
	