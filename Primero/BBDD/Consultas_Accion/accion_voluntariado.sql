-- 65. Modificar el campo de sexo para que aparezca H de Hombre dónde
-- actualmente aparece V.
UPDATE Voluntarios_OLD v 
set v.Sexo = 'H'
WHERE v.Sexo = 'V'

-- 66. Modificar la provincia para que aparezca La Rioja dónde actualmente
-- aparece Logroño.
UPDATE Voluntarios_OLD v 
set  v.Provincia = 'La Rioja'
WHERE v.Provincia = 'Logroño'

-- 67. Modificar el campo de laboral para que en todos quede sin información.
UPDATE Voluntarios_OLD v 
set  v.Laboral = NULL

-- 68. Modificar el campo LABORAL y Deporte para que el contenido aparezca
-- en mayúsculas.
UPDATE Voluntarios_OLD v
SET v.Laboral = upper(v.Laboral),
	v.Deporte = upper(v.Deporte)

-- 69. Modificar el campo de Edad para que aparezca la edad exacta de la
-- persona a fecha 13/12/1990.
UPDATE Voluntarios_OLD v 
SET v.Edad = if ((month(v.FechaNacimiento)<month(NOW()))OR ((month(v.FechaNacimiento)=month(NOW()))AND day(v.FechaNacimiento)<day(NOW())),
		year(NOW())-year(v.FechaNacimiento)-1,
		year(NOW())-year(v.FechaNacimiento))
WHERE v.FechaNacimiento = "1990-12-13 00:00:00"

-- 70. Seleccionar el campo de pais mostrando solo aquellos diferentes. Crear la
-- tabla de paises con los registros seleccionados. (Voluntarios_OLD)
CREATE TABLE paises2 (pais varchar(100))
SELECT DISTINCT vo.Pais 
FROM Voluntarios_OLD vo

-- 71. Seleccionar el campo de pais y provincia mostrando sólo aquellas
-- provincias de España (las provincias no tienen que repetirse). Crear una
-- tabla de provincias con los registros seleccionados. Añadir a esta tabla el
-- resto de provincias que no sean de España.
CREATE TABLE provincias2 (Pais varchar(100), provincia varchar(100))
SELECT DISTINCT vo.Pais, vo.Provincia 
FROM Voluntarios_OLD vo
WHERE vo.Pais ="españa"

INSERT INTO provincias2 
SELECT DISTINCT vo.Pais, vo.Provincia 
FROM Voluntarios_OLD vo
WHERE vo.Pais <> "españa"

-- 72. Seleccionar el campo de provincia y población mostrando solo aquellas
-- poblaciones diferentes. Crear la tabla de poblaciones con los registros
-- seleccionados.
CREATE TABLE poblaciones2 (provincia varchar(100), poblacion varchar(100))
SELECT DISTINCT vo.Provincia, vo.Poblacion
FROM Voluntarios_OLD vo

-- 73. Asignar la tarea de Administrativo a :15 personas con conocimientos de
-- ingles ESCRITO o francés ESCRITO Medios o Altos, con nivel medio o
-- alto de informática

UPDATE preferencias p 
set p.IdTarea = 1 
WHERE p.IdVoluntario IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, nivel n, idiomas i 
	WHERE v.IdVoluntarios = n.IdVoluntario 
		AND n.IdIdioma = i.Ididioma
		AND n.escrito IN ('alto', 'medio')
		AND i.idioma IN ('ingles', 'frances')
		AND v.nivelInformatica IN ('medio', 'alto'))
LIMIT 15
	
-- 74. Asignar la tarea de Traducción /Interprete a:
-- a. 39 personas que tengan nivel Alto de inglés HABLADO.
UPDATE preferencias p 
set p.IdTarea = 3 
WHERE p.IdVoluntario IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, nivel n, idiomas i 
	WHERE v.IdVoluntarios = n.IdVoluntario 
		AND n.IdIdioma = i.Ididioma
		AND n.hablado ='alto'
		AND i.idioma = 'ingles')
LIMIT 39

-- b. 10 personas que tengan nivel Alto de francés HABLADO.
UPDATE preferencias p 
set p.IdTarea = 4
WHERE p.IdVoluntario IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, nivel n, idiomas i 
	WHERE v.IdVoluntarios = n.IdVoluntario 
		AND n.IdIdioma = i.Ididioma
		AND n.hablado ='alto'
		AND i.idioma = 'frances')
LIMIT 10

-- c. 2 personas que tengan nivel Alto de alemán HABLADO.
UPDATE preferencias p 
set p.IdTarea = 3 
WHERE p.IdVoluntario IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, nivel n, idiomas i 
	WHERE v.IdVoluntarios = n.IdVoluntario 
		AND n.IdIdioma = i.Ididioma
		AND n.hablado ='alto'
		AND i.idioma = 'aleman')
LIMIT 2

-- d. 2 personas que tengan nivel Alto de italiano HABLADO
UPDATE preferencias p 
set p.IdTarea = 4 
WHERE p.IdVoluntario IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, nivel n, idiomas i 
	WHERE v.IdVoluntarios = n.IdVoluntario 
		AND n.IdIdioma = i.Ididioma
		AND n.hablado ='alto'
		AND i.idioma = 'italiano')
LIMIT 2

-- 75. Asignar en la tabla voluntarios la columna puesto con el valor
-- “Informática” a:15 personas con nivel alto de informática y hayan elegido
-- Tareas Informática con preferencia 1 o 2.
ALTER TABLE voluntarios add puesto varchar(100)

UPDATE voluntarios v 
SET v.puesto = "Informática"
WHERE v.IdVoluntarios IN (
	SELECT DISTINCT v.IdVoluntarios
	FROM voluntarios v, tareas t , preferencias p 
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND t.IdTarea = p.IdTarea 
		AND p.Preferencia IN (1,2)
		AND t.nombre = "informatica"
		AND nivelInformatica = "alto")

-- 76. Asignar en la tabla voluntarios old la columna Puesto con el valor
-- “Protocolo” a: 20 personas que hayan elegido Tareas Protocolo con
-- preferencia 1 o 2, tengan nivel medio escrito de cualquier idioma.
ALTER TABLE Voluntarios_OLD add Puesto varchar(100)

UPDATE Voluntarios_OLD vo
SET vo.Puesto = "Protocolo"
WHERE vo.Idvoluntario IN (
	SELECT DISTINCT v.Idvoluntario 
	FROM Voluntarios_OLD v, tareas t , preferencias p, nivel n, idiomas i 
	WHERE v.IdVoluntario = p.IdVoluntario 
		AND t.IdTarea = p.IdTarea 
		AND p.Preferencia IN (1,2)
		AND t.nombre = "protocolo"
		AND n.escrito = "medio"
		AND n.IdIdioma = i.Ididioma
		)
LIMIT 20

-- 77. Asignar en la tabla voluntarios old la columna puesto con el valor
-- “Conducción” a:
-- a. 10 personas con carnet de conducir tipo C.
UPDATE Voluntarios_OLD v 
set v.Puesto = "Conduccion"
WHERE v.Idvoluntario IN (
	SELECT DISTINCT v.Idvoluntario 
	FROM Voluntarios_OLD v 
	WHERE v.CarnetC = "si")
LIMIT 10

-- b. 60 personas con carnet de conducir tipo B que tengan nivel hablado
-- bajo o medio de algún idioma y que preferiblemente sean de Jaca o
-- Huesca o Zaragoza.
UPDATE Voluntarios_OLD v 
set v.Puesto = "Conduccion"
WHERE v.Idvoluntario IN (
	SELECT DISTINCT v.Idvoluntario 
	FROM Voluntarios_OLD v, nivel n, idiomas i
	WHERE v.CarnetB = "si"
		AND v.Idvoluntario=n.IdVoluntario
		AND i.Ididioma= n.IdIdioma
		AND n.hablado IN ("Bajo", "Medio")
		AND v.Poblacion IN ("Jaca", "Zaragoza", "Huesca"))
LIMIT 60

-- 78. Asignar en la tabla voluntarios la columna puesto el valor “Sanitario” a: 30
-- personas, que hayan elegido Tareas Sanitarias con preferencia 1 o 2 y
-- preferiblemente tengan la situación laboral de trabajadores en caso
-- contrario de estudiante.
UPDATE voluntarios v, preferencias p, tareas t, laboral l
SET v.Puesto = "Sanitario"
WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "sanitaria"
		AND p.Preferencia IN (1,2)
		AND v.idLabor = l.IdLabor
		AND (l.labor = "trabajador"
			OR l.labor= "estudiante")
ORDER BY l.labor DESC
LIMIT 30

-- Solucion alternativa
UPDATE voluntarios v
SET v.Puesto = "Sanitario"
WHERE v.IdVoluntarios  IN (
	SELECT v.IdVoluntarios
	FROM voluntarios v, preferencias p, tareas t, laboral l 
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "sanitaria"
		AND p.Preferencia IN (1,2)
		AND v.idLabor = l.IdLabor
		AND (l.labor = "trabajador"
			OR l.labor= "estudiante"))
ORDER BY l.labor DESC
LIMIT 30
			
-- 79. Asignar en la tabla voluntarios la columna puesto el valor “Comunicación”
-- a: 30 personas que hayan elegido Tareas Comunicación con preferencia 1
-- ó 2
UPDATE voluntarios v
SET v.Puesto = "Comunicacion"
WHERE v.IdVoluntarios  IN (
	SELECT v.IdVoluntarios
	FROM voluntarios v, preferencias p, tareas t
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "comunicacion"
		AND p.Preferencia IN (1,2))
LIMIT 30

-- 80. Asignar en la tabla voluntarios la columna puesto el valor “Acompañante”
-- a: 20 personas que hayan elegido Tareas Acompañante con preferencia 1
-- ó 2 ó 3
UPDATE voluntarios v
SET v.Puesto = "Acompañante"
WHERE v.IdVoluntarios  IN (
	SELECT v.IdVoluntarios
	FROM voluntarios v, preferencias p, tareas t
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "acompañantes"
		AND p.Preferencia IN (1,2,3))
LIMIT 30

-- 81. Asignar en la tabla voluntarios la columna puesto el valor “Logística” a: 30
-- personas que hayan elegido Tareas Logistica con preferencia 1 ó 2 ó 3 ó 4
UPDATE voluntarios v
SET v.Puesto = "Logística"
WHERE v.IdVoluntarios  IN (
	SELECT v.IdVoluntarios
	FROM voluntarios v, preferencias p, tareas t
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "logistico"
		AND p.Preferencia IN (1,2,3,4))
LIMIT 30

-- 82. Asignar en la tabla voluntarios old la labor de Promoción a: 30 personas
-- que hayan elegido Tareas Promocion con preferencia 1 ó 2 ó 3 ó 4
UPDATE voluntarios v
SET v.Puesto = "Promoción"
WHERE v.IdVoluntarios  IN (
	SELECT v.IdVoluntarios
	FROM voluntarios v, preferencias p, tareas t
	WHERE v.IdVoluntarios = p.IdVoluntario 
		AND p.IdTarea = t.IdTarea 
		AND t.nombre = "promocion"
		AND p.Preferencia IN (1,2,3,4))
LIMIT 30

-- 83. Asignar en la tabla voluntarios la columna puesto el valor “Apoyo” a: 60
-- personas que practiquen esquí
UPDATE voluntarios v, practicar p, deportes d
SET v.puesto = "Apoyo"
WHERE v.IdVoluntarios = p.IdVoluntarios 
	AND d.IdDeporte = p.IdDeportes 
	AND d.deporte REGEXP "esquí"
LIMIT 60

-- 84. Asignar en la tabla voluntarios la columna puesto el valor “Accesos” a: 30
-- personas mas altas.
UPDATE voluntarios v 
SET v.puesto = "Accesos"
ORDER BY v.altura desc
LIMIT 30

-- 85. Asignar en la tabla voluntarios la columna puesto el valor “Voluntarios” a:
-- 30 personas de menor peso
UPDATE voluntarios v 
SET v.puesto = "Voluntarios"
WHERE v.peso > 0
ORDER BY cast(v.peso as int) asc
LIMIT 30

-- 86. Asignar en la tabla voluntarios la columna puesto el valor “Información” a:
-- 30 personas
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Información"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND v.puesto = NULL
ORDER BY p.Preferencia asc
LIMIT 30

-- 87. Asignar en la tabla voluntarios la columna puesto el valor “Palacio de
-- congresos” a personas con las siguientes tareas:
-- a. 10 personas Traducción o Interprete ,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre IN ("traduccion", "interprete")
	AND v.puesto = NULL
LIMIT 10

-- b. 4 sanitarios,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
	AND v.puesto = NULL
LIMIT 4

-- c. 10 administrativos,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "administrativas"
	AND v.puesto = NULL
LIMIT 10

-- d. 5 información,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
	AND v.puesto = NULL
LIMIT 5

-- e. 5 informaticos,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informatica"
	AND v.puesto = NULL
LIMIT 5

-- f. 10 protocolo
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "protocolo"
	AND v.puesto = NULL
LIMIT 10

-- g. 5 logistica
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Palacio de congresos"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "logistico"
	AND v.puesto = NULL
LIMIT 5

-- 88. Asigna en la tabla voluntarios la columna puesto el valor “Pista de Hielo”
-- a personas con las siguientes tareas:
-- a. 8 personas de Accesos,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Pista de hielo"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
	AND v.puesto = NULL
LIMIT 8

-- b. 8 personas de logística,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Pista de hielo"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "logistico"
	AND v.puesto = NULL
LIMIT 8

-- c. 6 sanitarios ,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Pista de hielo"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
	AND v.puesto = NULL
LIMIT 6

-- d. 5 información,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Pista de hielo"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
	AND v.puesto = NULL
LIMIT 5

-- e. 5 informaticos
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Pista de hielo"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informatica"
	AND v.puesto = NULL
LIMIT 5

-- 89. Asigna en la tabla voluntarios la columna puesto el valor “Centro de
-- Transporte” a personas con las siguientes tareas:
-- a. 70 personas de conducción,
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "conduccion"
	AND v.puesto = NULL
LIMIT 70

-- b. 5 administrativos
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "administrativas"
	AND v.puesto = NULL
LIMIT 5

-- c. 5 informaticos
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informatica"
	AND v.puesto = NULL
LIMIT 5

-- d. 5 logistica
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "logistico"
	AND v.puesto = NULL
LIMIT 5

-- e. 5 informacion
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
	AND v.puesto = NULL
LIMIT 5

-- 90. asigna en la tabla voluntarios la columna puesto el valor “Nave de
-- Logistica” a personas con las siguientes tareas:
-- a. 2 personas de Accesos
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Nave de logistica"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
	AND v.puesto = NULL
LIMIT 2

-- b. 30 promocion
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "promocion"
	AND v.puesto = NULL
LIMIT 30

-- c. 5 logistica
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "logistico"
	AND v.puesto = NULL
LIMIT 5


-- 91. Asigna en la tabla voluntarios la columna puesto el valor “Escuela militar
-- de montaña” a personas con las siguientes tareas:
-- a. 5 Accesos
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Escuela militar de montaña"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
	AND v.puesto = NULL
LIMIT 5

-- b. 30 voluntarios
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Centro de transporte"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "voluntarios"
	AND v.puesto = NULL
LIMIT 30

-- 92. Asigna en la tabla voluntarios la columna puesto el valor “delegaciones”
-- a personas con las siguientes tareas:
-- a. 43 personas de Traducción/Interprete
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Delegaciones"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre IN ("traduccion", "interprete")
	AND v.puesto = NULL
LIMIT 43

-- b. 10 protocolo
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Delegaciones"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "protocolo"
	AND v.puesto = NULL
LIMIT 10

-- c. 20 acompañantes
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Delegaciones"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
	AND v.puesto = NULL
LIMIT 20

-- d. 7 logistica
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Delegaciones"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "logistico"
	AND v.puesto = NULL
LIMIT 7

-- e. 5 comunicación
UPDATE voluntarios v, preferencias p, tareas t
SET v.puesto = "Delegaciones"
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "comunicacion"
	AND v.puesto = NULL
LIMIT 5

-- 93. Asigna en la tabla voluntarios la localidad “Berja” a personas con las
-- siguientes tareas:
-- a. 12 personas Apoyo
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "berja")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "apoyo"
LIMIT 12

-- b. 4 sanitarios
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "berja")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
LIMIT 4

-- c. 3 informacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "berja")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
LIMIT 3

-- d. 5 comunicacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "berja")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "comunicacion"
LIMIT 5

-- e. 3 accesos
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "berja")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
LIMIT 3

-- 94. Asigna en la tabla voluntarios la localidad “Jaca” a personas con las
-- siguientes tareas:
-- a. 12 personas Apoyo
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Jaca")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "apoyo"
LIMIT 12

-- b. 4 sanitarios
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Jaca")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
LIMIT 4

-- c. 3 informacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Jaca")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
LIMIT 3

-- d. 5 comunicacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Jaca")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "comunicacion"
LIMIT 5

-- e. 3 accesos
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Jaca")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
LIMIT 3

-- 95. Asigna en la tabla voluntarios la localidad “Formentera” a personas con
-- las siguientes tareas:
-- a. 12 personas Apoyo
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Formentera")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "apoyo"
LIMIT 12

-- b. 4 sanitarios
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Formentera")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
LIMIT 4

-- c. 3 informacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Formentera")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
LIMIT 3

-- d. 5 comunicacion
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Formentera")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "comunicacion"
LIMIT 5

-- e. 3 accesos
UPDATE voluntarios v, preferencias p, tareas t, localidades l
SET v.idLocalidad = (
	SELECT l.idLocalidad 
	FROM localidades l 
	WHERE l.localidad = "Formentera")
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
LIMIT 3

-- 96. Asigna la tarea de Panticosa a personas con las siguientes tareas:
INSERT INTO tareas (IdTarea, nombre)
VALUES (16, "Panticosa")

-- a. 12 personas Apoyo
UPDATE voluntarios v, preferencias p, tareas t
SET p.IdTarea=16
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "apoyo"
LIMIT 12

-- b. 4 sanitarios
UPDATE voluntarios v, preferencias p, tareas t
SET p.IdTarea=16
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "sanitaria"
LIMIT 4

-- c. 3 informacion
UPDATE voluntarios v, preferencias p, tareas t
SET p.IdTarea=16
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "informacion"
LIMIT 3

-- d. 5 comunicacion
UPDATE voluntarios v, preferencias p, tareas t
SET p.IdTarea=16
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "comunicacion"
LIMIT 5

-- e. 3 acceso
UPDATE voluntarios v, preferencias p, tareas t
SET p.IdTarea=16
WHERE p.IdVoluntario = v.IdVoluntarios 
	AND p.IdTarea = t.IdTarea 
	AND t.nombre = "accesos"
LIMIT 3