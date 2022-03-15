-- 41. Cantidad de personas de cada país.
SELECT count(v.IdVoluntarios) AS POBLACION_PAIS, p2.pais 
FROM voluntarios v, localidades l, provincias p, paises p2
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.idPais = p2.idPais 
GROUP BY p2.pais 

-- 42. Cantidad de personas de las diferentes provincias de España.
SELECT count(v.IdVoluntarios) AS POBLACION_PROVINCIA, p.provincia 
FROM voluntarios v, localidades l, provincias p, paises p2
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.idPais = p2.idPais 
	AND p2.pais = "España"
GROUP BY p.provincia

-- 43. Cantidad de personas de las tres provincias de Aragón.
SELECT count(v.IdVoluntarios) AS POBLACION_PROVINCIA, p.provincia 
FROM voluntarios v, localidades l, provincias p
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND (p.provincia = "Zaragoza"
		OR p.provincia = "Huesca"
		OR p.provincia = "Teruel")
		GROUP BY p.provincia

-- 44. Cantidad de personas de las diferentes poblaciones de Huesca.
SELECT count(v.IdVoluntarios) AS POBLACION_LOCALIDAD, l.localidad 
FROM voluntarios v, localidades l, provincias p
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.provincia = "Huesca"
		GROUP BY l.localidad
		
-- 45(a). Cantidad de personas que se llaman igual.
SELECT count(v.IdVoluntarios) AS MISMO_NOMBRE, v.nombre 
FROM voluntarios v
GROUP BY v.nombre
ORDER BY MISMO_NOMBRE DESC  

-- 45(b). Cantidad de personas que se llaman igual.(Nombre más común)
SELECT count(v.IdVoluntarios) AS MISMO_NOMBRE, v.nombre 
FROM voluntarios v
GROUP BY v.nombre
ORDER BY MISMO_NOMBRE DESC  
LIMIT 1

-- 45(c). Cantidad de personas que se llaman igual. Mostrar los que se repiten entre 5 y 10
SELECT count(v.IdVoluntarios) AS MISMO_NOMBRE, v.nombre 
FROM voluntarios v
GROUP BY v.nombre
HAVING MISMO_NOMBRE BETWEEN 5 AND 10
ORDER BY MISMO_NOMBRE

-- 46. Cantidad de personas por edades.
SELECT count(v.IdVoluntarios) AS TOTAL_MISMA_EDAD,
	floor(datediff(CURRENT_DATE(), v.fNacimiento)/365) AS EDAD
FROM voluntarios v
GROUP BY EDAD
ORDER BY EDAD DESC

-- 46. Cantidad de personas por edades.
SELECT count(v.IdVoluntarios) AS TOTAL_MISMA_EDAD,
	floor((datediff(CURRENT_DATE(), v.fNacimiento)-((floor(datediff(CURRENT_DATE(), v.fNacimiento)/365))/4))/365) AS EDAD
FROM voluntarios v
GROUP BY EDAD
ORDER BY EDAD DESC

-- 47. Cantidad de personas por tallas.
SELECT count(v.IdVoluntarios) AS MISMA_TALLA, v.talla AS TALLA
FROM voluntarios v
GROUP BY v.talla

-- 48. Cantidad de personas por profesion.
SELECT count(v.IdVoluntarios) AS MISMA_PROFESION, l.labor AS PROFESION
FROM voluntarios v, laboral l
WHERE l.idlabor = v.idLabor 
GROUP BY v.idLabor 

-- 49. Cantidad de personas por sexo.
SELECT count(v.IdVoluntarios) AS MISMO_SEXO, vo.Sexo AS SEXO
FROM voluntarios v, Voluntarios_OLD vo 
WHERE v.IdVoluntarios = vo.Idvoluntario 
GROUP BY vo.Sexo

-- 50. Cantidad de personas nacidas en cada mes.
SELECT count(v.IdVoluntarios) AS MISMO_MES, MONTHNAME(v.fNacimiento) AS MES_NACIMIENTO
FROM voluntarios v
GROUP BY MES_NACIMIENTO
ORDER BY MONTH(v.fNacimiento)

-- 51. Cantidad de personas nacidas en cada trimestre.
SELECT count(v.IdVoluntarios) AS MISMO_TRIMESTRE, QUARTER(v.fNacimiento) AS TRIMESTRE_NACIMIENTO
FROM voluntarios v
GROUP BY TRIMESTRE_NACIMIENTO

-- 52. Cantidad de personas nacidas en cada trimestre, pero solo de aquellos trimestres
-- que tengan más de 110 personas.
SELECT count(v.IdVoluntarios) AS MISMO_TRIMESTRE, QUARTER(v.fNacimiento) AS TRIMESTRE_NACIMIENTO
FROM voluntarios v
GROUP BY TRIMESTRE_NACIMIENTO
HAVING MISMO_TRIMESTRE > 110

-- 53. Cantidad de personas de los diferentes niveles de italiano hablado.
SELECT count(v.IdVoluntarios) AS MISMO_NIVEL, n.hablado AS NIVEL_HABLADO, i.idioma 
FROM voluntarios v, idiomas i , nivel n
WHERE v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "Italiano"
GROUP BY NIVEL_HABLADO

-- 54. Cantidad de personas de los diferentes niveles de frances hablado
SELECT count(v.IdVoluntarios) AS MISMO_NIVEL, n.hablado AS NIVEL_HABLADO, i.idioma 
FROM voluntarios v, idiomas i , nivel n
WHERE v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "Francés"
GROUP BY NIVEL_HABLADO

-- 55. Cantidad de personas de los diferentes niveles de ingles hablado.
SELECT count(v.IdVoluntarios) AS MISMO_NIVEL, n.hablado AS NIVEL_HABLADO, i.idioma 
FROM voluntarios v, idiomas i , nivel n
WHERE v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "Inglés"
GROUP BY NIVEL_HABLADO

-- 56. Cantidad de personas de los diferentes niveles de ingles hablado y por edades.
SELECT count(v.IdVoluntarios) AS MISMO_NIVEL,
n.hablado AS NIVEL_HABLADO,
i.idioma,
(YEAR(CURRENT_DATE())-YEAR(v.fNacimiento)) AS EDAD
FROM voluntarios v, idiomas i , nivel n
WHERE v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "Inglés" 
GROUP BY NIVEL_HABLADO, EDAD
ORDER BY EDAD 

-- 57. Promedio de edades, Más viejo, Más Joven
SELECT AVG(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS PROMEDIO_EDAD,
	MIN(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS MIN_EDAD,
	MAX(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS MAX_EDAD
FROM voluntarios v

-- 58. Promedio de edades de cada provincia.
SELECT AVG(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS PROMEDIO_EDAD,
	p.provincia 
FROM voluntarios v, localidades l, provincias p, paises p2
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.idPais = p2.idPais 
	AND p2.pais = "España"
GROUP BY p.provincia

-- 59. Edad de la persona más viejo y más joven de cada pais.
SELECT MAX(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS MAX_EDAD,
	MIN(FLOOR(DATEDIFF(CURRENT_DATE(), v.fNacimiento)/365)) AS MIN_EDAD,
	p2.pais
FROM voluntarios v, localidades l, provincias p, paises p2
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.idPais = p2.idPais
GROUP BY p2.pais 
