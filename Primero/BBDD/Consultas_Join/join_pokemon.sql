-- 1. mostrar los pokemon con una estadística base de ps mayor que 200 y que no evolucionan de otro pokemon.
SELECT p.*, eb.ps 
FROM pokemon p 
	INNER JOIN estadisticas_base eb ON eb.numero_pokedex = p.numero_pokedex
WHERE eb.ps > 200
	AND p.numero_pokedex not in (SELECT p.numero_pokedex 
		FROM pokemon p 
		INNER JOIN evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex) 

-- 2. mostrar los pokemon que son de tipo hielo o veneno, que tengan una ataque que permitan como
--  efecto secundario paralizar.
SELECT DISTINCT p.*, es.efecto_secundario 
FROM pokemon p
	INNER JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex	
	INNER JOIN tipo t ON t.id_tipo = pt.id_tipo
	INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex 
	INNER JOIN movimiento m ON m.id_movimiento = pmf.id_movimiento 
	INNER JOIN movimiento_efecto_secundario mes ON mes.id_movimiento = m.id_movimiento 
	INNER JOIN efecto_secundario es ON es.id_efecto_secundario = mes.id_efecto_secundario 
WHERE (t.nombre = 'veneno' or t.nombre = 'hielo')
	AND es.efecto_secundario = 'paralizar'
	
-- 3. mostrar los pokemon que tengan movimientos cuya potencia del movimiento es cero, ordena la
--  información por el campo pp descendentemente.
SELECT DISTINCT p.*
FROM pokemon p 
	INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex 
	INNER JOIN movimiento m ON m.id_movimiento = pmf.id_movimiento
WHERE m.potencia = 0
ORDER BY m.pp DESC


-- 4. mostrar los pokemon y la información de sus estadísticas base, de aquellos pokemon que evolucionan de
--  otros pokemon con una estadística de velocidad superior a 100 ordenados de mayor a menor por
--  ataque, y después por el poder de defensa de menor a mayor.
SELECT p.nombre, eb.*
FROM pokemon p 
	INNER JOIN estadisticas_base eb ON eb.numero_pokedex = p.numero_pokedex 
	INNER JOIN evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex	
WHERE ed.pokemon_origen IN (SELECT p.numero_pokedex 
	FROM pokemon p 
		INNER JOIN estadisticas_base eb ON eb.numero_pokedex = p.numero_pokedex
	WHERE eb.velocidad >100)

-- 5. mostrar los ataques que sean de tipo especial y los pokemon que usan estos ataques.
SELECT m.nombre AS ATAQUE, p.nombre AS POKEMON ,  ta.tipo AS TIPO
FROM pokemon p 
	INNER JOIN pokemon_movimiento_forma pmf ON p.numero_pokedex = pmf.numero_pokedex 
	INNER JOIN movimiento m ON m.id_movimiento = pmf.id_movimiento 
	INNER JOIN tipo t ON m.id_tipo = t.id_tipo 
	INNER JOIN tipo_ataque ta ON ta.id_tipo_ataque = t.id_tipo_ataque
WHERE ta.tipo = 'especial'
ORDER BY m.id_movimiento 

	
