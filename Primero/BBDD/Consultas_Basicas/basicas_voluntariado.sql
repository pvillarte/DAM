-- 1. Extranjeros que vienen al FOJE
SELECT v.nombre, p2.pais 
FROM voluntarios v, localidades l, provincias p, paises p2 
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.idPais = p2.idPais 
	AND p2.pais <> "españa"

-- 2. Personas de fuera de Aragón
SELECT v.nombre, p.provincia 
FROM voluntarios v, localidades l, provincias p 
WHERE v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND !(p.provincia IN ("Zaragoza", "Huesca", "Teruel"))
	
-- 3. Personas de Jaca
SELECT v.nombre, l.localidad 
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad 
	AND l.localidad = "Jaca"
	
-- 4. Personas que no tengan alojamiento durante el FOJE
SELECT v.nombre, v.alojamiento 
FROM voluntarios v
WHERE v.alojamiento = "false"

-- 5. Personas entre 18 y 25 años que pesen más de 70Kg y lleven la talla M o L
SELECT v.nombre, year(CURRENT_DATE())-year(v.fNacimiento) AS EDAD, v.peso, v.talla 
FROM voluntarios v
WHERE v.alojamiento = "false"
	AND v.talla IN ("M", "L")
	AND v.peso >70
HAVING EDAD BETWEEN 18 AND 25

-- 6. Personas entre 26 y 40 años de Zaragoza o Personas entre 41 y 55 años de huesca
SELECT year(CURRENT_DATE())-year(v.fNacimiento) AS EDAD, v.nombre, l.localidad
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad 
HAVING (EDAD BETWEEN 26 AND 40
		AND l.localidad ="Zaragoza")
	OR (EDAD BETWEEN 41 AND 55
		AND l.localidad ="Huesca")

-- 7. Personas mayores a 55 años
SELECT year(CURRENT_DATE())-year(v.fNacimiento) AS EDAD, v.nombre
FROM voluntarios v
HAVING EDAD>55

-- 8. Personas con una talla XXL y cuya altura sea inferior a 175cm
SELECT v.nombre, v.altura , v.talla 
FROM voluntarios v
WHERE v.talla = "XXL"
	AND v.altura < 175
	
-- 9. Personas estudiantes con nivel ALTO en informatica
SELECT v.nombre, v.nivelInformatica, l.labor 
FROM voluntarios v, laboral l 
WHERE l.IdLabor = v.idLabor 
	AND l.labor ="estudiante"
	AND v.nivelInformatica = "alto"

-- 10. Personas estudiantes con un nivel ALTO en ingles hablado y escrito
SELECT v.nombre, l.labor, i.idioma, n.hablado , n.escrito 
FROM voluntarios v, laboral l, idiomas i, nivel n 
WHERE l.IdLabor = v.idLabor 
	AND l.labor ="estudiante"
	AND n.IdIdioma = i.Ididioma 
	AND n.IdVoluntario = v.IdVoluntarios 
	AND n.hablado = "alto"
	AND n.escrito = "alto"
	AND i.idioma = "ingles"
	
-- 11. Personas jubiladas con un nivel ALTO en frances hablado y escrito o con un nivel
-- ALTO en inglés hablado y escrito
SELECT v.nombre, l.labor, i.idioma, n.hablado , n.escrito 
FROM voluntarios v, laboral l, idiomas i, nivel n 
WHERE l.IdLabor = v.idLabor 
	AND l.labor ="jubilado"
	AND ((n.IdIdioma = i.Ididioma 
			AND n.IdVoluntario = v.IdVoluntarios 
			AND n.hablado = "alto"
			AND n.escrito = "alto"
			AND i.idioma = "ingles")
		OR  (n.IdIdioma = i.Ididioma 
			AND n.IdVoluntario = v.IdVoluntarios 
			AND n.hablado = "alto"
			AND n.escrito = "alto"
			AND i.idioma = "frances"))

-- 12. Personas que practiquen esquí en cualquiera de sus modalidades
SELECT v.nombre, d.deporte 
FROM voluntarios v, deportes d, practicar p 
WHERE v.IdVoluntarios =p.IdVoluntarios 
	AND p.IdDeportes = d.IdDeporte 
	AND d.deporte REGEXP "esquí"

-- 13. Personas que cumplen años hoy
SELECT v.nombre, v.fNacimiento 
FROM voluntarios v
WHERE month(v.fNacimiento)=month(CURRENT_DATE())
	AND day(v.fNacimiento)=day(CURRENT_DATE())

-- 14. Personas que cumplen años en el mes de diciembre
SELECT v.nombre, v.fNacimiento 
FROM voluntarios v
WHERE month(v.fNacimiento)=12

-- 15. Personas que cumplen años en invierno 21dec 21 mar
SELECT v.nombre, v.fNacimiento 
FROM voluntarios v
WHERE(month(v.fNacimiento)=12
		AND day(v.fNacimiento>21))
	OR(month(v.fNacimiento)<3)
	OR(month(v.fNacimiento)=3
		AND day(v.fNacimiento<22))

-- 16. Personas que cumplen años en el primer trimestre del año
SELECT v.nombre, v.fNacimiento 
FROM voluntarios v
WHERE month(v.fNacimiento)<4

-- 17. Personas que tengan preferencia 1 en tareas de informática o preferencia 1 en tareas
-- de conducción
SELECT v.nombre, p.Preferencia, t.nombre 
FROM voluntarios v, preferencias p, tareas t 
WHERE v.IdVoluntarios =p.IdVoluntario
	AND p.IdTarea = t.IdTarea 
	AND (t.nombre = "conduccion"
		OR t.nombre = "informatica")
	AND p.Preferencia = 1

-- 18. Personas que tengan preferencia 1 en tareas de interprete y que tengan un nivel
-- hablado alto en cualquiera de los idiomas
SELECT v.nombre, i.idioma, n.hablado, t.nombre, p.Preferencia 
FROM voluntarios v, idiomas i, nivel n, tareas t, preferencias p 
WHERE v.IdVoluntarios =p.IdVoluntario
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "interprete"
	AND p.Preferencia = 1
	AND n.IdIdioma = i.Ididioma 
	AND n.IdVoluntario = v.IdVoluntarios 
	AND n.hablado = "alto"

-- 19. Personas que tengan preferencia 1 en tareas de informatica y tengan un nivel medio o
-- alto en informatica
SELECT v.nombre, t.nombre as Tarea, p.Preferencia, v.nivelInformatica 
FROM voluntarios v, tareas t, preferencias p 
WHERE v.IdVoluntarios =p.IdVoluntario
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informatica"
	AND p.Preferencia = 1
	AND v.nivelInformatica = "alto"
	
-- 20. Personas que tengan preferencia 1 en tareas de conducción, tengan un nivel medio o
-- alto de ingles hablado, sean mayores de 26 años, tengan carnet de conducir B y sean
-- de Huesca.
SELECT v.nombre, p.Preferencia, t.nombre, i.idioma, n.hablado, (year(CURRENT_DATE())- year(v.fNacimiento)) AS EDAD, l.localidad 
FROM voluntarios v, preferencias p, idiomas i, nivel n, tareas t, localidades l 
WHERE v.IdVoluntarios = p.IdVoluntario
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "conduccion"
	AND p.Preferencia = 1
	AND v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "ingles"
	AND (n.hablado = "medio" OR n.hablado = "alto")
	AND v.carnetB = "true"
	AND v.idLocalidad = l.idLocalidad
	AND l.localidad = "huesca"
	HAVING EDAD>26
	
	
-- 21. Personas que tengan preferencia 2 en tareas administrativas, tengan un nivel medio o
-- alto de ingles hablado y sean mayores de 40 años.
SELECT v.nombre, p.Preferencia, t.nombre, i.idioma, n.hablado, (year(CURRENT_DATE())- year(v.fNacimiento)) AS EDAD
FROM voluntarios v, preferencias p, idiomas i, nivel n, tareas t
WHERE v.IdVoluntarios = p.IdVoluntario
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "administrativas"
	AND p.Preferencia = 2
	AND v.IdVoluntarios = n.IdVoluntario 
	AND n.IdIdioma = i.Ididioma 
	AND i.idioma = "ingles"
	AND (n.hablado = "medio" OR n.hablado = "alto")
	HAVING EDAD>40

-- 22. Personas cuyo nombre comience por A y que sean de Cataluña
SELECT v.nombre, p.provincia 
FROM voluntarios v, localidades l, provincias p 
WHERE v.idLocalidad = l.idLocalidad
	AND l.idProvincia = p.idProvincia 
	AND p.provincia IN ("Barcelona", "Tarragona", "lleida", "girona")
	AND v.nombre LIKE "A%"
	
-- 23. Personas cuyo codigo postal comience por 2 y termine en 6
SELECT vo.Nombre, vo.Cp 
FROM Voluntarios_OLD vo 
WHERE Cp LIKE "2%6"

-- 24. Personas cuya población comience por CAN
SELECT v.nombre, l.localidad 
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad
	AND l.localidad LIKE "can%"
	
-- 25. Personas cuyo nombre comience por cualquiera de las siguientes letras
-- F,G.H,I,J,K,L,M
SELECT v.nombre
FROM voluntarios v
WHERE v.nombre REGEXP "^[F-M]"

-- 26. Personas cuya cuarta letra del nombre tenga una de las siguientes letras P,Q,R,S,T
-- y además sean aragonesas.
SELECT v.nombre, p.provincia 
FROM voluntarios v, localidades l, provincias p 
WHERE v.nombre REGEXP "[P-T]"
	AND v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.provincia IN ("zaragoza", "huesca", "teruel")

-- 27. Personas cuyo nombre comience por cualquiera de las siguientes letras
-- A,B,C,D,E,F,G,H,I,J,K,L sean varones y residan en Galicia
SELECT v.nombre, p.provincia, vo.Sexo 
FROM voluntarios v, localidades l, provincias p, Voluntarios_OLD vo 
WHERE v.nombre REGEXP "^[A-L]"
	AND v.idLocalidad = l.idLocalidad 
	AND l.idProvincia = p.idProvincia 
	AND p.provincia IN ("lugo", "ourense", "pontevedra", "a coruña")
	AND vo.Sexo = "M"
	AND v.IdVoluntarios = vo.Idvoluntario
	
-- 28. Personas cuyo nombre comience y termine por una vocal
SELECT v.nombre
FROM voluntarios v
WHERE v.nombre REGEXP "^[AEIOU]"
	AND v.nombre REGEXP "[AEIOU]$"

-- 29. Personas cuyo nombre tenga 3 letras o tenga 10 letras
SELECT v.nombre
FROM voluntarios v
WHERE length(v.nombre)=3
	OR length(v.nombre)=10
	
-- 30. Personas en cuya población aparezca la palabra VILLANUEVA
SELECT v.nombre, l.localidad 
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad
	AND l.localidad REGEXP "villanueva"
	
-- 31. Personas en cuya población aparezca la letra Ñ
SELECT v.nombre, l.localidad 
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad
	AND l.localidad REGEXP "ñ"
	
-- 32. Personas en cuya población aparezca una vocal acentuada
SELECT v.nombre, l.localidad 
FROM voluntarios v, localidades l
WHERE v.idLocalidad = l.idLocalidad
	AND l.localidad REGEXP "[áéíóú]"
	
-- 33. Seleccionar el campo nombre, otro que contenga las tres primeras posiciones del
-- nombre, otro que contenga las dos últimas posiciones del nombre.
SELECT v.nombre,
	SUBSTRING(v.nombre, 1, 3) AS Tres_primeras, 
	SUBSTRING(v.nombre, (length(v.nombre)-1), 2) AS Dos_últimas
FROM voluntarios v

-- 34. Seleccionar el campo nombre, población, otro que contenga las posiciones 2 y 3 del
-- nombre, y otro que contenga la posición primera y última de la población.
SELECT v.nombre,
	SUBSTRING(v.nombre, 2, 2) AS Posiciones_2_3, 
	l.localidad,
	concat(SUBSTRING(l.localidad, 1, 1), SUBSTRING(l.localidad, length(l.localidad), 1)) AS Primera_ultima
FROM voluntarios v, localidades l 
WHERE v.idLocalidad = l.idLocalidad 

-- 35. Seleccionar el campo nombre, población, otro al que llamaremos usuario, que
-- contenga las tres primeras posiciones del nombre junto con las tres ultimas posiciones
-- de la población y el idvoluntario y otro al que llamaremos clave que contenga los
-- dígitos 3 y 4 del codigo postal junto con el idvoluntario y el mes de nacimiento.
SELECT v.nombre,
	l.localidad,
	concat(SUBSTRING(v.nombre, 1, 3), SUBSTRING(l.localidad, length(l.localidad)-2, 3), v.IdVoluntarios) AS usuario,
	concat(SUBSTRING(vo.Cp, 3, 2), IdVoluntarios, monthname(v.fNacimiento)) AS clave
FROM voluntarios v, localidades l, Voluntarios_OLD vo

-- 36.Seleccionar el campo nombre y otro llamado Dias Vividos donde muestre la diferencia
-- de dias entre la fecha actual y la de su nacimiento.
SELECT v.nombre, 
	datediff(NOW(), v.fNacimiento) AS Dias_Vividos
FROM voluntarios v 

-- 37. Seleccionar el campo de nombre, fecha, otro llamado Dia Nacimiento en el que se
-- muestre el día de la semana en el que nació, otro llamado Trimestre en el que se
-- muestre el trimestre correspondiente a la fecha de nacimiento.
SELECT v.nombre, 
	now() AS Fecha,
	v.fNacimiento AS Fecha_nacimiento,
	dayname(v.fNacimiento) AS Dia_nacimiento,
	quarter(v.fNacimiento) AS Trimestre
FROM voluntarios v 

-- 38. Seleccionar el campo de nombre, provincia y otro al que llamaremos comunidad y el
-- cual llevará ARAGONES si la persona reside en cualquier provincia de Aragón,
-- ANDALUZ si reside en cualquier provincia de Andalucía y guiones (--------) en caso
-- contrario.
SELECT v.nombre, p.provincia,
	 CASE  
	 	WHEN p.provincia IN("zaragoza", "huesca", "teruel") THEN 'ARAGONES'
	 	WHEN p.provincia IN("cadiz", "sevilla", "granada", "jaen", "almeria", "cordoba", "huelva", "malaga") THEN 'ANDALUZ'
	 	ELSE '--------' END AS Comunidad
FROM voluntarios v, provincias p, localidades l 
WHERE v.idLocalidad = l.idLocalidad 
	 AND p.idProvincia = l.idProvincia 

-- 39. Selecciona el campo de nombre, fecha, edad y prepara un campo llamado Edad
-- Exacta que contenga la edad exacta de la persona.
SELECT v.nombre,
	NOW() AS Fecha,
	v.fNacimiento AS FechaNacimiento,
	year(NOW())-year(v.fNacimiento) AS EDAD,
	if ((month(v.fNacimiento)<month(NOW()))OR ((month(v.cfNacimiento)=month(NOW()))AND day(v.fNacimiento)<day(NOW())),
		year(NOW())-year(v.fNacimiento),
		year(NOW())-year(v.fNacimiento)-1) AS EdadExacta
FROM voluntarios v

