-- 36. Selecciona el Titulo y el Precio de las películas cuyo precio supere al precio medio de
-- todas las películas.
SELECT p.TITULO, p.PRECIO 
FROM Peliculas p
WHERE p.PRECIO >
	(SELECT avg(p.PRECIO)
	FROM Peliculas p) 

-- 37. Selecciona el Titulo de las películas que nunca han sido alquiladas.
SELECT p.*
FROM Peliculas p 
WHERE p.TITULO NOT IN(
	SELECT p.TITULO 
	FROM Peliculas p, Alquileres a 
	WHERE a.CODIGOPELICULA = p.CODIGOPELICULA)
	
-- 38. Selecciona el Titulo de aquellas películas que superen el precio mas bajo de las películas
-- del género Terror
SELECT p.TITULO 
FROM Peliculas p 
WHERE p.PRECIO >
	(SELECT min(p.PRECIO) 
	FROM Peliculas p, Generos g 
	WHERE p.GENERO = g.CODIGOGENERO 
	AND g.NOMBREGENERO = "terror")
	
-- 39. Seleccionar el Titulo de las películas que tengan como inicial una letra diferente a las
-- iniciales de las películas del género comedia.
SELECT p.TITULO 
FROM Peliculas p
WHERE LEFT(p.TITULO, 1) NOT IN
	(SELECT LEFT (p.TITULO, 1)
	FROM Peliculas p, Generos g 
	WHERE p.GENERO = g.CODIGOGENERO 
		AND g.NOMBREGENERO = "comedia")
	
-- 40. Seleccionar el Título de las películas que contengan las letras ‘el’ o que hayan sido
-- alquiladas por personas cuyo nombre contenga las letras ‘el’
SELECT p.TITULO 
FROM Peliculas p
WHERE p.TITULO REGEXP "el" 
	OR p.TITULO IN (
		SELECT p.TITULO 
		FROM Peliculas p, Alquileres a, Clientes c 
		WHERE p.CODIGOPELICULA = a.CODIGOPELICULA 
			AND a.CODIGOCLIENTE = c.CODIGOCLIENTE 
			AND c.NOMBRECLIENTE REGEXP "el")






	


		
		
		
		
		