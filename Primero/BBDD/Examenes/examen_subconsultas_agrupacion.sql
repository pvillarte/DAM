-- 1. Mostrar el nombre de los autores, título de sus libros y fecha de publicación de los mismos. 
-- Sólo libros cuya fecha de publicación sea anterior al año 2000 ordenados por fecha de publicación. 
-- Limitar la consulta a 5 resultados.
SELECT a.nombre, a.apellido, l.titulo, l.fecha_publicacion 
FROM autores a, libros l 
WHERE year(l.fecha_publicacion) < 2000
	AND a.autor_id =l.autor_id 
ORDER BY l.fecha_publicacion ASC
LIMIT 5

-- 2. Mostrar el número de autores nacidos entre 1800 y 1900. De estos lo que sean de sexo femenino 
-- o de los estados unidos USA. Tener en cuenta el tipo de dato de la fecha de nacimiento para usar la función correcta.
SELECT count(a.autor_id) AS CANTIDAD
FROM autores a 
WHERE (year(a.fecha_nacimiento) BETWEEN 1800 AND 1900
	AND a.genero = "F")
	OR (year(a.fecha_nacimiento) BETWEEN 1800 AND 1900
		AND a.pais_origen = "USA")

-- 3. Mostrar el nombre de usuario (username) y su fecha de creación de los usuarios con cuenta de correo (email)
--  perteneciente al dominio codigo facilito. Ordenados por fecha de creación.
SELECT u.username, u.fecha_creacion 
FROM usuarios u 
WHERE u.email REGEXP "codigofacilito.com$"
ORDER BY u.fecha_creacion ASC

-- 4. Mostrar el título, fecha de publicación y seudónimo del autor de los libros de harry potter ordenados por fecha de publicación.
SELECT l.titulo, l.fecha_publicacion, a.seudonimo 
FROM libros l, autores a 
WHERE l.autor_id = a.autor_id 
	AND l.titulo REGEXP "harry potter"
ORDER BY l.fecha_publicacion DESC

-- 5. Mostrar todos los autores que no hayan escrito ningún libro. De los autores queremos: 
-- - El nombre
-- - La segunda letra del apellido concatenado con la tercera del nombre, campo que denominaremos ‘pass’
-- - Un campo denominado “sexo”, con el valor “mujer” o “hombre” dependiendo de la información del campo género. 
SELECT DISTINCT a.nombre,
	concat(substring(a.apellido, 2, 1), substring(a.nombre, 3, 1)) AS pass, 
	CASE 
		WHEN a.genero = "M" THEN "hombre"
		WHEN a.genero = "F" THEN "mujer"
	END AS sexo
FROM autores a
WHERE a.autor_id not in(
	SELECT l.autor_id 
	FROM libros l)

-- 6. Dame el usuario_id de todos aquellos usuarios que tengan información en libros_usuarios siempre y cuando la fecha de 
-- creación de los usuarios sea superior a hace 3 meses desde hoy. 
SELECT DISTINCT u.usuario_id 
FROM usuarios u 
WHERE (DATEDIFF(now(), u.fecha_creacion)>90)
	AND u.usuario_id IN (SELECT lu.usuario_id 
		FROM libros_usuarios lu) 

-- 7. Mostrar el título del libro que ha sido comprado una sola vez. 
SELECT l.titulo
FROM libros l
WHERE l.libro_id in (SELECT lu.libro_id
	FROM libros_usuarios lu
	GROUP BY lu.libro_id
	HAVING count(lu.libro_id)  = 1)

-- 8. Dame la media de las páginas de los libros que hay en stock. 
SELECT avg(l.paginas) AS MEDIA_PAGINAS
FROM libros l 
WHERE l.stock > 0

-- 9. Muestra cuantos usuarios se han creado por mes y año. Debes sacar la información ordenada por año, mes y número
--  de usuario.
SELECT year(u.fecha_creacion) AS AÑO, month(u.fecha_creacion) AS MES, count(u.usuario_id) AS NUEVOS_USUARIOS  
FROM usuarios u 
GROUP BY year(u.fecha_creacion), month(u.fecha_creacion)
ORDER BY AÑO, MES, NUEVOS_USUARIOS

-- 10. Muestra cuantos libros de más de 10 páginas hay en stock.
SELECT count(l.libro_id) AS CANT_LIB_MASDE10PAGS
FROM libros l 
WHERE l.stock>0
	AND l.paginas>10

