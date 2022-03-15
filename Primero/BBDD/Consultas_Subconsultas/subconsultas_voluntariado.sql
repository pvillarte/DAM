-- 60. Mostrar voluntarios de la provincia de Madrid cuya edad supere la media de
-- edades de los voluntarios de Zaragoza.
SELECT v.*
FROM voluntarios v, provincias p, localidades l 
WHERE v.idLocalidad = l.idLocalidad
	AND l.idProvincia = p.idProvincia
	AND p.provincia = "madrid"
	AND (year(NOW())-year(v.fNacimiento)) >(
		SELECT avg(year(NOW())-year(v.fNacimiento))
		FROM voluntarios v, localidades l, provincias p 
		WHERE v.idLocalidad = l.idLocalidad
			AND l.idProvincia = p.idProvincia
			AND p.provincia = "zaragoza")

-- 61. Mostrar voluntarios y edad que superen a todas las edades de los voluntarios
-- de la provincia de Madrid.
SELECT v.*, (year(NOW())-year(v.fNacimiento)) AS EDAD
FROM voluntarios v
HAVING EDAD > (
		SELECT max(year(NOW())-year(v.fNacimiento))
		FROM voluntarios v, localidades l, provincias p 
		WHERE v.idLocalidad = l.idLocalidad
			AND l.idProvincia = p.idProvincia
			AND p.provincia = "madrid")
				
-- 62. Mostrar voluntarios y altura, que superen el peso más alto de los voluntarios de
-- Barcelona.
SELECT v.nombre, v.altura
FROM voluntarios v 
WHERE v.peso > (
		SELECT max(v.peso)
		FROM voluntarios v, localidades l
		WHERE v.idLocalidad = l.idLocalidad
			AND l.localidad = "Barcelona")
			
-- 63. Mostrar voluntarios y altura cuyo altura sea inferior a cualquier altura de los
-- voluntarios de Burgos.
SELECT v.nombre, v.altura
FROM voluntarios v 
WHERE v.altura < (
		SELECT min(v.altura)
		FROM voluntarios v, localidades l
		WHERE v.idLocalidad = l.idLocalidad
			AND l.localidad = "Burgos")

-- 64. Mostrar nombre de voluntarios y altura cuya altura coincida con alturas de
-- voluntarios de Valencia
SELECT v.nombre, v.altura
FROM voluntarios v 
WHERE v.altura IN (
		SELECT v.altura
		FROM voluntarios v, localidades l, provincias p 
		WHERE v.idLocalidad = l.idLocalidad
			AND l.idProvincia = p.idProvincia 
			AND p.provincia = "Valencia/València")

			
			
			
			

			
			
			