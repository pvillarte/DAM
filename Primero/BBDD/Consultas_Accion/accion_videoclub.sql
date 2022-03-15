-- 41. Borrar todos los registros de clientes que residan fuera de Zaragoza.
DELETE c.*
FROM Clientes c 
WHERE c.CIUDAD = 'Zaragoza' 

-- 42. Borrar todos los registros de Peliculas cuyo precio sea inferior a 15 €.
DELETE p.*
FROM Peliculas p 
WHERE p.PRECIO < 15

-- 43. Borrar todos los registros de películas que empiecen por H.
DELETE p.*
FROM Peliculas p 
WHERE p.TITULO REGEXP "^H"

-- 44. Borrar todos los registros de películas cuya modalidad sea ESTRENO
DELETE p.*
FROM Peliculas p, Tipopeliculas t
WHERE p.TIPOPELICULA = t.CODIGOENTREGA 
	AND t.MODALIDAD = "estreno"
	
-- 45. Borrar todos los registros de películas del género de TERROR
DELETE  p.*
FROM Peliculas p, Generos g 
WHERE p.GENERO = g.CODIGOGENERO 
	AND g.NOMBREGENERO = "terror"
	
-- 46. Borrar todos los registros de películas cuyo género sea AVENTURAS y hayan sido
-- adquiridas en el año 98
DELETE  p.*
FROM Peliculas p, Generos g, Alquileres a 
WHERE p.GENERO = g.CODIGOGENERO 
	AND g.NOMBREGENERO = "aventuras"
	AND a.CODIGOPELICULA = p.CODIGOPELICULA
	AND year(a.FECHADESCARGA) = 1998
	
-- 47. Añadir un registro nuevo en Generos cuyo numero sea 14 y se denomine
-- DOCUMENTAL
INSERT INTO Generos (CODIGOGENERO, NOMBREGENERO)
VALUES (14, "DOCUMENTAL")

-- 48. Añadir un registro nuevo en la tabla de clientes cuya información corresponda a
-- vuestros datos personales.
INSERT INTO Clientes (CODIGOCLIENTE,
	NOMBRECLIENTE, APELLIDO1CLIENTE, APELLIDO2CLIENTE, 
	DNI,DIRECCION, CIUDAD, codigopostal, PROVINCIA,
	TELEFONO, FECHALTA, OBSERVACIONES)
VALUES (4, "Pablo", "Villarte", "Diestre", "12345657A", "Calle Don Bosco, 1", "Zaragoza",
	50006,"Zaragoza", 622111222, "10/11/2020", "ameisin")

-- 49. Crear una tabla vacía (llamada CopiaGeneros) con los mismos campos de la tabla de
-- Generos. Traspasar toda la información de Generos a CopiaGeneros.
CREATE TABLE CopiaGeneros LIKE Generos

INSERT INTO CopiaGeneros (CODIGOGENERO, NOMBREGENERO)
SELECT g.CODIGOGENERO, g.NOMBREGENERO 
FROM Generos g 

-- drop table CopiaGeneros
-- show tables

-- 50. Eliminar los registros de la tabla de CopiaGeneros cuyo nombre comience por C
DELETE cg.*
FROM CopiaGeneros as cg
WHERE cg.NOMBREGENERO REGEXP "^C"

-- 51. Añadir a la tabla CopiaGeneros los registros de Generos cuyo nombre comience por C 
INSERT INTO CopiaGeneros 
SELECT g.*
FROM Generos g 
WHERE g.NOMBREGENERO REGEXP "^C"

-- 52. Crear una tabla vacía (llamada Infantiles) con los mismos campos de la tabla de
-- Peliculas. Traspasar todos los registros de la tabla Peliculas a la tabla Infantiles, que
-- tengan como genero Infantil, Aventuras, Ciencia-ficción

CREATE TABLE Infantiles LIKE Peliculas

INSERT INTO Infantiles
SELECT p.*
FROM Peliculas p, Generos g 
WHERE g.CODIGOGENERO = p.GENERO 
	AND g.NOMBREGENERO IN ("Infantil", "Aventuras", "Ciencia-ficción")

-- 53. Dividir la tabla de clientes en dos tablas llamadas Capital y Provincias con la misma
-- estructura, en la primera guardaremos todos los registros de clientes que sean de
-- Zaragoza y en Provincias el resto.
CREATE TABLE Capital LIKE Clientes

CREATE TABLE Provincias LIKE Clientes

INSERT INTO Capital
SELECT c.*
FROM Clientes c
WHERE c.CIUDAD = "Zaragoza"

INSERT INTO Provincias
SELECT c.*
FROM Clientes c
WHERE c.CIUDAD != "Zaragoza"
	
-- 54. Modificar el campo de Codigo Postal de la tabla de clientes para que a todos les
-- aparezca 50900
UPDATE Clientes 
SET codigopostal = 50900

-- 55. Modificar el campo de Observaciones de la tabla de clientes para que a todos les
-- ponga un CODIGO formado por 3 caracteres de la izda del nombre + los 2
-- ultimos del 2 apellido+ 3 digitos centrales del telefono
UPDATE Clientes 
SET OBSERVACIONES = concat(left(NOMBRECLIENTE, 3), right(APELLIDO2CLIENTE , 2), substring(TELEFONO, 4, 3))

-- 56. Modificar el campo de Observaciones de la tabla de clientes para que a todos los que
-- se dieron de alta en el mes de Abril del 99 les aparezca el mensaje de BONIFICADO
UPDATE Clientes 
SET OBSERVACIONES = "BONIFICADO"
WHERE FECHALTA LIKE "__/04/1999"

-- 57. Modificar el campo de Ciudad de la tabla de clientes para que todos los que residan
-- en Zaragoza les aparezca la ciudad en mayúsculas.
UPDATE Clientes
SET CIUDAD = upper(CIUDAD)
WHERE CIUDAD = 'Zaragoza'

-- 58. Modificar el título de películas para que en todas que empiecen por R les aparezca -----
UPDATE Peliculas 
SET TITULO = "-----"
WHERE TITULO REGEXP "^R"

-- 59. Incrementar el precio de cada película un cinco por ciento.
UPDATE Peliculas
SET PRECIO = PRECIO*1.05

-- 60. Acentuar el apellido de López en la tabla de Clientes.
UPDATE Clientes
SET APELLIDO1CLIENTE = "López"
WHERE APELLIDO1CLIENTE  = "Lopez"

UPDATE Clientes
SET APELLIDO2CLIENTE = "López"
WHERE APELLIDO2CLIENTE  = "Lopez"



