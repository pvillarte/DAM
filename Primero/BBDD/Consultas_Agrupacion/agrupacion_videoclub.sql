-- Realiza una consulta que nos agrupe las películas por género.
SELECT p.GENERO , p.TITULO, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO 
GROUP BY p.GENERO 

-- Realiza una consulta que nos muestre cuantas películas existen de cada género. (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.TITULO) AS TOTAL_PELICULAS, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO 
GROUP BY p.GENERO 

-- Realiza una consulta que nos muestre cuantas películas existen de cada género que superen 10 películas (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.TITULO) AS TOTAL_PELICULAS, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO 
GROUP BY g.NOMBREGENERO 
HAVING  TOTAL_PELICULAS>10

-- Realiza una consulta que nos muestre cuantas películas existen de los géneros INFANTIL y MUSICAL. (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.GENERO) AS TOTAL_PELICULAS, g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE g.NOMBREGENERO IN ("Musical", "Infantil")
	AND p.GENERO = g.CODIGOGENERO
GROUP BY g.NOMBREGENERO

-- Realiza una consulta que nos agrupe las películas por fecha de publicación.
SELECT p.*
FROM Peliculas p
GROUP BY p.FECHAPUBLICACION 

-- Realiza una consulta que nos muestre cuantas películas existen de cada fecha de publicación . (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.GENERO) AS TOTAL_PELICULAS, p.FECHAPUBLICACION 
FROM Peliculas p
GROUP BY p.FECHAPUBLICACION 

-- Realiza una consulta que nos muestre cuantas películas existen de cada fecha de publicación mostrando sólo aquellas fechas que tengan 1 película. (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.GENERO) AS TOTAL_PELICULAS, p.FECHAPUBLICACION 
FROM Peliculas p
GROUP BY p.FECHAPUBLICACION 
HAVING  TOTAL_PELICULAS=1

-- Realiza una consulta que nos agrupe las películas por  genero y fecha de publicación.
SELECT p.*
FROM Peliculas p
GROUP BY p.FECHAPUBLICACION, p.GENERO

-- Realiza una consulta que nos muestre cuantas películas existen de cada género y fecha de  publicación. (Mostrar como título de columna TOTAL PELICULAS)
SELECT count(p.GENERO) AS TOTAL_PELICULAS,
	g.NOMBREGENERO,
	p.FECHAPUBLICACION 
FROM Peliculas p, Generos g
WHERE g.CODIGOGENERO = p.GENERO 
GROUP BY p.FECHAPUBLICACION, p.GENERO 

-- Añadir a la consulta anterior, la suma del precio.  (Mostrar como título de columna TOTAL)
SELECT count(p.GENERO) AS TOTAL_PELICULAS,
	g.NOMBREGENERO,
	p.FECHAPUBLICACION, 
	sum(p.PRECIO) AS SUMATORIO_PRECIOS
FROM Peliculas p, Generos g
WHERE g.CODIGOGENERO = p.GENERO 
GROUP BY p.FECHAPUBLICACION, p.GENERO

-- Realiza una consulta que nos muestre el sumatorio de los precios de las películas publicadas en el año 2017 y al lado el sumatorio de los precios con un incremento del 21% de IVA .  (Mostrar como título de columnas TOTAL  AÑO 2017 y TOTAL AÑO 2017 con IVA)
SELECT year(p.FECHAPUBLICACION) AS AÑO, 
	sum(p.PRECIO) AS TOTAL_AÑO,
	sum(p.PRECIO)*1.21 AS TOTAL_AÑO_MAS_IVA	
FROM Peliculas p
GROUP BY YEAR(p.FECHAPUBLICACION)

-- Realiza una consulta que nos muestre por cada fecha de publicación, el promedio de los precios de las películas.  (Mostrar como título de columna  PROMEDIO)
SELECT AVG(p.PRECIO) AS PROMEDIO,
	p.FECHAPUBLICACION 
FROM Peliculas p
GROUP BY p.FECHAPUBLICACION 

-- Realiza una consulta que nos muestre de cada tipo de película la primera y la última fecha de publicación.
SELECT MIN(p.FECHAPUBLICACION) AS PRIMERA,
	MAX(p.FECHAPUBLICACION)AS ULTIMA,
	p.TIPOPELICULA, 
	t.MODALIDAD 
FROM Peliculas p, Tipopeliculas t
WHERE p.TIPOPELICULA = t.CODIGOENTREGA 
GROUP BY p.TIPOPELICULA 

-- Realiza una consulta que nos muestre por cada género, el precio más barato, el precio más 
-- caro y el promedio de precios de las películas.
SELECT MIN(p.PRECIO) AS PRECIO_MIN,
	MAX(p.PRECIO)AS PRECIO_MAX, 
	AVG(p.PRECIO),
	g.NOMBREGENERO 
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO 
GROUP BY p.GENERO 


