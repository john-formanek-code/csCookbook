/* 1) a)*/
CREATE TABLE krouzky ( id INT PRIMARY KEY, jmeno_krouzku VARCHAR(40) NOT NULL, pocet_studentu INT NOT NULL );

/*b)*/
INSERT INTO krouzky (id, jmeno_krouzku, pocet_studentu) VALUES (5, 'keramika', 3), (1, 'peceni', 2), (2, 'vareni', 6);

/*c*/
UPDATE krouzky 
SET pocet_studentu = 14 
WHERE jmeno_krouzku = 'keramika';

/*d*/
TRUNCATE TABLE krouzky;

/*e*/
DROP TABLE krouzky;


/*2*/
SELECT COUNT(*) AS pocet_knih FROM kniha WHERE kniha_isbn LIKE '%42%';
/*pocet_knih 27*/

/*3*/
SELECT osoba.osoba_jmeno, osoba.osoba_prijmeni, osoba.osoba_email FROM osoba WHERE osoba.osoba_datumNarozeni BETWEEN '1994-01-01' AND '2007-01-01';
/*130 celkem*/

/*4*/
SELECT film.film_nazev, film.film_rezie FROM film WHERE film.film_zemePuvodu LIKE ('Senegal');
/*
Snezenky a machri po 25 letech
Robert Rodriguez
Mesto duchu
David Yates
Bowling for columbine
Zdenek Podskalsky
Drsny casy
Oldrich Lipsky
*/

/*5*/
SELECT film.film_studio, COUNT(*) AS pocet_filmu FROM film GROUP BY film.film_studio ORDER BY pocet_filmu DESC LIMIT 4;
/*
Universal Studios
34
20th Century Fox
29
Lions Gate Entertainment
29
Paramount Pictures
25
*/

/*6*/
SELECT COUNT(*) AS pocet_autoru FROM ( SELECT kniha_autor FROM kniha GROUP BY kniha_autor HAVING COUNT(*) = 7 ) AS subquery;
/*pocet_autoru 6 */

/*7*/
SELECT COUNT(DISTINCT ma_vypujcenu.maVypujcenu_osoba_id) FROM ma_vypujcenu;
/*COUNT(DISTINCT ma_vypujcenu.maVypujcenu_osoba_id) 97*/
