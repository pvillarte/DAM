-- 1. Buscar los socios que se inscribieron después del 1 de enero del 2000:
SELECT s.nombre , s.fecha_ingreso 
FROM socio s 
WHERE year(s.fecha_ingreso) >= 2000

-- 2. Buscar socios en con la dirección contiene port.
SELECT s.nombre, s.direccion 
FROM socio s 
WHERE s.direccion REGEXP "port"

-- 3. Socios que se llaman eric y se inscribieron antes del 2000
SELECT s.nombre 
FROM socio s 
WHERE year(s.fecha_ingreso) < 2000
	AND s.nombre REGEXP "^eric"

-- 4. Socios con nombre que empieza por A y sus telefonos
SELECT s.nombre , ts.telefono 
FROM socio s, telefonos_socio ts 
WHERE s.nombre REGEXP "^a"
	AND ts.nif_socio = s.nif 
	
-- 5. Socios que tienen una embarcacion: nombre de socio, matricula de enbarcacion y tipo velero
SELECT s.nombre, e.matricula, e.tipo 
FROM embarcacion e, socio s 
WHERE s.nif = e.nif_dueño 
	AND e.tipo = "velero"

	
-- 6. Embarcaciones con dimension mayor de 30, numero de muelle, y lectura de contador de agua sea
-- superior a 500
SELECT e.matricula, e.dimensiones, m.numero , m.lect_cont_agua
FROM embarcacion e, muelle m 
WHERE m.matr_embarcacion = e.matricula
	AND m.lect_cont_agua > 500
	AND e.dimensiones > 30

-- 7. Empleados de especialidad motor, que tienen embarcaciones de tipo lancha
SELECT DISTINCT e.nombre
FROM empleado e, embarcacion e2, se_encarga se 
WHERE e.especialidad = "motor"
	AND se.cod_empleado = e.codigo 
	AND se.matr_embarcacion = e2.matricula
	AND e2.tipo = "lancha"

-- 8. Devolver los números de muelle y los códigos de empleados que atienden muelles sin
-- mantenimiento
SELECT m.numero, e.codigo, m.mantenimiento 
FROM muelle m, empleado e, atiende a 
WHERE a.cod_empleado = e.codigo 
	AND a.num_muelle = m.numero 
	AND m.mantenimiento = false

-- 9. Nombres de Empleados y número de muelle que atienden muelles con algún contador a menos de
-- 100.
SELECT e.nombre, m.numero
FROM empleado e, muelle m, atiende a 
WHERE a.cod_empleado = e.codigo 
	AND a.num_muelle = m.numero 
	AND (m.lect_cont_agua <100
		OR m.lect_cont_luz< 100)

-- 10. Muelles con mantenimiento en donde hay embarcaciones de las que se encarga un empleado con
-- la especialidad de limpieza.
SELECT DISTINCT m.numero 
FROM muelle m, atiende a, empleado e 
WHERE a.cod_empleado = e.codigo 
	AND a.num_muelle = m.numero 
	AND e.especialidad = "limpieza"

-- 11. Teléfonos de cada socio que tenga una embarcación de tipo pesquero que esté en un muelle que lo
-- atienda algún empleado de especialidad distinta a motor
SELECT DISTINCT s.nombre, ts.telefono
FROM socio s , telefonos_socio ts, embarcacion e, muelle m, atiende a, empleado e2 
WHERE ts.nif_socio = s.nif 
	AND e.nif_dueño = s.nif
	AND m.matr_embarcacion = e.matricula 
	AND a.num_muelle = m.numero 
	AND a.cod_empleado = e2.codigo 
	AND e.tipo = "pesquero"
	AND e2.especialidad != "motor"

-- 12. 1 teléfono de cada socio que tenga una embarcación de tipo pesquero que esté en un muelle que lo
-- atienda algún empleado de especialidad distinta a motor
SELECT DISTINCT s.nombre, ts.telefono 
FROM socio s , telefonos_socio ts, embarcacion e, muelle m, atiende a, empleado e2 
WHERE ts.nif_socio = s.nif 
	AND e.nif_dueño = s.nif
	AND m.matr_embarcacion = e.matricula 
	AND a.num_muelle = m.numero 
	AND a.cod_empleado = e2.codigo 
	AND e.tipo = "pesquero"
	AND e2.especialidad != "motor"
GROUP BY s.nombre 

-- 13. Número de empleados de cada especialidad
SELECT e.especialidad, count(e.codigo) AS CANTIDAD_EMPLEADOS
FROM empleado e 
GROUP BY e.especialidad 

-- 14. ¿Cuántos teléfonos tiene cada socios cuyo nombre empiece por A?
SELECT count(ts.telefono), s.nombre
FROM socio s, telefonos_socio ts 
WHERE ts.nif_socio = s.nif
	AND s.nombre REGEXP "^A" 
GROUP BY s.nombre 

-- 15. ¿Cuantas embarcaciones tiene cada socio?
SELECT count(e.matricula) AS CANTIDAD_EMBARCACIONES, s.nombre, s.nif 
FROM embarcacion e, socio s 
WHERE e.nif_dueño = s.nif 
GROUP BY s.nif 

-- 16. Muelles que tienen embarcaciones que no pertenecen al socio propietario de ese muelle: Mostrar
-- nombre del socio propietario de la embarcación y el nombre del socio propietario del muelle.
-- 17. Mostrar el número de embarcaciones que tiene cada socio en sus muelles sin que sean suyas, es
-- decir que el propietario de la embarcación es distinto al propietario del muelle donde esta esa
-- embarcación.
-- 18. Mostrar las embarcaciones de las que se encargan 2 o más empleados
-- 19. Mostrar el ranking de años donde más socios ingresaron, sólo años que ingresaron más de 2 socios
-- 20. Mostrar el ranking de empleados que más trabajo tienen (muelles que atienden sumado a
-- embarcaciones de las que se encargan), sólo de empleados que tienen más de 2 trabajos. ¿Como
-- la modificarias si nos pidieran también el nombre del empleado?.
-- 
-- 21. Mostrar el ranking de empleados que más trabajo tienen (muelles que atienden más embarcaciones
-- de las que se encargan), sólo de empleados que se encargan de ambas cosas (muelles y
-- embarcaciones)
-- 22. Mostrar embarcaciones de socios que han ingresado en la década de los 90 (usando cláusula exist)
-- 23. Mostrar socios que tienen embarcaciones de tipo yate (usando cláusula exist)
-- 24. Mostrar empleados y muelles que son atendidos por empleados que se encargan de alguna
-- embarcación de las que se conocen sus dimensiones (usando cláusula exist)
-- 25. Mostrar número de embarcaciones que se conocen sus dimensiones y de las que se encarga algun
-- empleado (usando cláusula exist)
-- 26. Mostrar el código de empleados que se encargan exclusivamente de todos los barcos de algún
-- socio (usando ALL/ANY)
-- 27. Mostrar nombres de socios que tienen alguna embarcación con dimensiones superiores a 50
-- (usando ALL/ANY)
-- 28. Mostrar socios que todos sus telefonos acaban en el mismo número
-- a. ¿Y si quisiéramos de la consulta anterior solo a los socios que tienen más de un teléfono?
-- 29. Pero así solo vemos un telefono por socio, si queremos ver todos los telefonos, se podria hacer asi:
-- 30. Mostrar socios que todos sus telefonos acaban en el mismo número y tienen más de un número de
-- telefono
-- 31. Socios que todas sus embarcaciones son de tipo yate
-- 32. Clasificar las embarcaciones según sus dimensiones, si la dimensión es menor que 30 será
-- ‘pequeña’, si está entre 30 y 60 será ‘mediana’, si es mayor que 60 será ‘grande’ y sino (si es 0)
-- será ‘desconocido’
-- 33. Mostrar las dimensiones de las embarcaciones en pulgadas (1 metro = 39,3701 pulgadas), si la
-- dimensión es nula, devolverá 0 pulgadas.
-- 34. Mostrar cuantos productos pedidos, porcentaje respecto del total, media de la cantidad pedida
-- agrupando los productos según hayan sido pedidos más de 30 unidades, 30 unidades o menos de
-- 30 unidades, escribiendo en un atributo a qué grupo pertenecen.
-- Nota: Hacer este último ejercicio en la BD de w3schools, usando la tabla Orderdetails:
-- OrderDetailID OrderID ProductID Quantity