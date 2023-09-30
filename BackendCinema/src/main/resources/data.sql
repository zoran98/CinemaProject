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
	VALUES (1, 'The Shawshank Redemption', 'Frank Darabont', 'Morgan Freeman, Tim Robbins', 'Drama, Crime', 120, 'Warner Bros', 'Engleska', 1994, 'Andy Dufresne, a successful banker, is arrested for the murders of his wife and her lover, and is sentenced to life imprisonment at the Shawshank prison.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (2, 'Batman: Begins', 'Christopher Nolan', 'Christian Bale, Cillian Murphy, Katie Holmes', 'Action, Adventure', 150, 'Film Fleks, Warner Bros', 'Engleska', 2005, 'After witnessing his parents` death, Bruce learns the art of fighting to confront injustice. When he returns to Gotham as Batman, he must stop a secret society that intends to destroy the city.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (3, 'Batman: The Dark Knight', 'Christopher Nolan', 'Christian Bale, Heath Ledger, Gary Oldman', 'Action, Adventure', 130, 'Film Fleks, Warner Bros', 'Engleska', 2008, 'After Gordon, Dent and Batman begin an assault on Gothams organised crime, the mobs hire the Joker, a psychopathic criminal mastermind who offers to kill Batman and bring the city to its knees.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (4, 'The Godfather', 'Francis Ford Coppola', 'Marlon Brando, Al Pacino, James Caan', 'Crime, Drama', 180, 'Paramount Pictures, American Zoetrope', 'USA', 1972, 'The films follow the trials of the fictional Italian American mafia Corleone family whose patriarch, Vito Corleone, rises to be a major figure in American organized crime.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (5, 'The Pianist', 'Roman Polanski', 'Adrien Brody, Thomas Kretschmann, Emilia Fox', 'War, Drama', 150, 'BAC Films, Tobis StudioCanal', 'France', 2002, 'During the WWII, acclaimed Polish musician Wladyslaw faces various struggles as he loses contact with his family. As the situation worsens, he hides in the ruins of Warsaw in order to survive.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (6, 'Forrest Gump', 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise', 'Romance, Drama', 142, 'Paramount Pictures', 'USA', 1994, 'Forrest, a man with low IQ, recounts the early years of his life when he found himself in the middle of key historical events. All he wants now is to be reunited with his childhood sweetheart, Jenny.');
INSERT INTO filmovi (id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemlja_porekla, godina_proizvodnje, opis) 
	VALUES (7, 'Schindler`s List', 'Steven Spielberg', 'Liam Neeson, Ralph Fiennes, Ben Kingsley', 'War, Drama', 195, 'Universal Pictures', 'USA', 1994, 'Oskar Schindler, a German industrialist and member of the Nazi party, tries to save his Jewish employees after witnessing the persecution of Jews in Poland.');

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

	
	
	