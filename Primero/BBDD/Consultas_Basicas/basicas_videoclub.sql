-- 1. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION de todas las
-- películas, ordenado descendentemente por el Título.
SELECT p.TITULO, p.FECHAPUBLICACION
FROM Peliculas p 
ORDER BY p.TITULO DESC 

-- 2. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION y Género de
-- todas las películas, ordenando ascendentemente por FECHAPUBLICACION y
-- descendentemente por Género.
SELECT p.TITULO, p.FECHAPUBLICACION, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO
ORDER BY p.FECHAPUBLICACION ASC, g.NOMBREGENERO DESC

-- 3. Realiza una consulta que nos muestre los campos Título, FECHAPUBLICACION, Género y
-- Tipo de todas las películas, ordenando ascendentemente por Tipo y Título.
SELECT p.TITULO, p.FECHAPUBLICACION, g.NOMBREGENERO, t.MODALIDAD 
FROM Peliculas p, Generos g, Tipopeliculas t 
WHERE p.GENERO = g.CODIGOGENERO
	AND t.CODIGOENTREGA =p.TIPOPELICULA 
ORDER BY t.MODALIDAD ASC, p.TITULO ASC

-- 4. Realiza una consulta que nos muestre el Título y Género de las 7 últimas películas (en orden
-- alfabético) del género Comedia.
SELECT p.TITULO, g.NOMBREGENERO, p.FECHAPUBLICACION 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO
	AND g.NOMBREGENERO = "comedia"
ORDER BY p.FECHAPUBLICACION DESC 
LIMIT 7

-- 5. Realiza una consulta que nos muestre todos los campos de las películas cuyo género sea
-- Drama o Comedia, ordenadas por genero.
SELECT p.*
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO
	AND (g.NOMBREGENERO = "comedia" OR g.NOMBREGENERO = "drama")
ORDER BY g.NOMBREGENERO

-- 6. Realiza una consulta que nos muestre todos los campos de las películas cuyo precio esté
-- entre 15 y 16, ordenadas por título.
SELECT p.*
FROM Peliculas p
WHERE p.PRECIO BETWEEN 15 AND 16
ORDER BY p.TITULO 

-- 7. Realiza una consulta que nos muestre todos los campos de las películas PUBLICADAS en el
-- año 2017.
SELECT p.*
FROM Peliculas p
WHERE year(p.FECHAPUBLICACION)=2017

-- 8. Realiza una consulta que nos muestre todos los campos de las películas PUBLICADAS en el
-- mes de marzo del año 2017.
SELECT p.*
FROM Peliculas p
WHERE year(p.FECHAPUBLICACION)=2017
	AND month(p.FECHAPUBLICACION)=3
	
-- 9. Realiza una consulta que nos muestre el Título de la película y al lado una columna donde
-- aparezca &#39;Para niños&#39; si el género es INFANTIL, o que aparezca &#39;Para adultos&#39; en caso
-- contrario. (El título de la nueva columna se llamará RECOMENDADA).
SELECT p.TITULO,
	if (g.NOMBREGENERO = "infantil", "Para niños" , "Para adultos") AS RECOMENDADA	
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO

SELECT p.TITULO, 
	CASE 
		WHEN g.NOMBREGENERO = "infantil" THEN "Para niños"
		ELSE "Para adultos" 
	END AS RECOMENDADA
FROM Peliculas p, Generos g 
WHERE p.GENERO=g.CODIGOGENERO 

-- 10. Realiza una consulta que nos muestre los Títulos de películas que empiezan por M o P.
SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO LIKE "M%"
	or p.TITULO LIKE "P%"

SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO REGEXP "^[mp]"

-- 11. Realiza una consulta que nos muestre los Títulos de películas que acaben en la letra S.
SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO LIKE "%s"

SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO REGEXP "s$"

-- 12. Realiza una consulta que nos muestre los Títulos de películas que contengan la palabra
-- AMOR.
SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO REGEXP "amor"

-- 13. Realiza una consulta que nos muestre los Títulos y Géneros de películas que tengan 4
-- caracteres en su título.
SELECT p.TITULO, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE length(p.TITULO)=4
	AND p.GENERO = g.CODIGOGENERO 

-- 14. Realiza una consulta que nos muestre los Títulos y Géneros de películas que tengan 4
-- caracteres en su título y sean de género Acción.
SELECT p.TITULO, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE length(p.TITULO)=4
	AND p.GENERO = g.CODIGOGENERO
	AND g.NOMBREGENERO="accion"
	
-- 15. Realiza una consulta que nos muestre los Títulos de películas que tengan por lo menos un
-- carácter numérico.
SELECT p.TITULO
FROM Peliculas p
WHERE p.TITULO  REGEXP "[0-9]"
	
-- 16. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
-- que empiezan por alguno de los siguientes caracteres: C,D,E,F,G,H
SELECT p.TITULO, p.FECHAPUBLICACION 
FROM Peliculas p
WHERE p.TITULO  REGEXP "^[C-H]"

-- 17. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
-- que empiezan por alguno de los siguientes caracteres: C,D,E,F,G,H,P,Q,R,S,T,U,V
SELECT p.TITULO, p.FECHAPUBLICACION 
FROM Peliculas p
WHERE p.TITULO  REGEXP "^[C-H]|^[P-V]"

-- 18. Realiza una consulta que nos muestre los Títulos y la fecha de publicación de las películas
-- que no terminen por alguno de los siguientes caracteres: I,J,K,L,M,N,O,P
SELECT p.TITULO, p.FECHAPUBLICACION 
FROM Peliculas p
WHERE !(p.TITULO  REGEXP "[I-P]$")

-- 19. Realiza una consulta que muestre los Títulos de películas que no contengan la letra a.
SELECT p.TITULO
FROM Peliculas p
WHERE !(p.TITULO  REGEXP "A|Á")

-- 20. Realiza una consulta que nos muestre los Títulos y el género de las películas cuyo género sea
-- TERROR, COMEDIA, INFANTIL ordenadas ascendentemente por el título.
SELECT p.TITULO, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO
	AND g.NOMBREGENERO IN ("terror","comedia", "infantil" )
ORDER BY p.TITULO ASC





