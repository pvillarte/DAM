/*Busca los pokemon que evolucionan y con ataques/movimientos aprendidos mediante MO Máquinas técnicas
 *  (MT) (TM en inglés), objetos que enseñan un ataque a un Pokémon y solo pueden utilizarse una vez
 *  (hasta la quinta generación, donde su uso se vuelve ilimitado).Máquinas ocultas (MO) (HM en inglés)
 * , objetos que enseñan un ataque a un Pokémon y pueden utilizarse ilimitadas veces.*/
SELECT p.numero_pokedex, p.nombre AS pokemon, m2.nombre AS movimiento,
	tfa.tipo_aprendizaje 	
FROM pokemon p
	INNER JOIN evoluciona_de ed ON ed.pokemon_origen = p.numero_pokedex
	INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex 
	INNER JOIN forma_aprendizaje fa ON fa.id_forma_aprendizaje = pmf.id_forma_aprendizaje
	INNER JOIN MO m ON m.id_forma_aprendizaje = fa.id_forma_aprendizaje 
	INNER JOIN movimiento m2 ON m2.id_movimiento = pmf.id_movimiento
	INNER JOIN tipo_forma_aprendizaje tfa ON tfa.id_tipo_aprendizaje = fa.id_tipo_aprendizaje

/*Busca los pokemon que evolucionan y con ataques/movimientos aprendidos mediante MT Máquinas técnicas
 *  (MT) (TM en inglés), objetos que enseñan un ataque a un Pokémon y solo pueden utilizarse una vez
 *  (hasta la quinta generación, donde su uso se vuelve ilimitado).Máquinas ocultas (MO) (HM en inglés),
 *  objetos que enseñan un ataque a un Pokémon y pueden utilizarse ilimitadas veces.*/
SELECT p.numero_pokedex, p.nombre AS pokemon, m2.nombre AS movimiento,
	tfa.tipo_aprendizaje 	
FROM pokemon p
	INNER JOIN evoluciona_de ed ON ed.pokemon_origen = p.numero_pokedex
	INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex 
	INNER JOIN forma_aprendizaje fa ON fa.id_forma_aprendizaje = pmf.id_forma_aprendizaje
	INNER JOIN MT m ON m.id_forma_aprendizaje = fa.id_forma_aprendizaje 
	INNER JOIN movimiento m2 ON m2.id_movimiento = pmf.id_movimiento
	INNER JOIN tipo_forma_aprendizaje tfa ON tfa.id_tipo_aprendizaje = fa.id_tipo_aprendizaje

/*Busca los pokemon que evolucionan de otro pokemon con ataque con efectos secundarios y una 
 * estadistica base de ataque mayor que 30*/
SELECT DISTINCT p.numero_pokedex, p.nombre AS pokemon
FROM pokemon p
	INNER JOIN evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex
WHERE ed.pokemon_origen IN (SELECT p.numero_pokedex 
	FROM pokemon p
		INNER JOIN evoluciona_de ed ON ed.pokemon_origen = p.numero_pokedex
		INNER JOIN estadisticas_base eb ON eb.numero_pokedex = p.numero_pokedex
		INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex
		INNER JOIN movimiento m ON m.id_movimiento = pmf.id_movimiento
		INNER JOIN movimiento_efecto_secundario mes ON mes.id_movimiento = m.id_movimiento 
	WHERE eb.ataque > 30)

/*Busca los pokemon de tipo psiquico con ataque de especial cuya tipo de aprendizaje sea mediante nivel*/
SELECT DISTINCT p.numero_pokedex, p.nombre AS pokemon, 
	t.nombre AS tipo_pokemon, m.nombre AS movimiento, ta.tipo AS tipo_ataque
FROM pokemon p
	INNER JOIN pokemon_tipo pt ON pt.numero_pokedex = p.numero_pokedex 
	INNER JOIN tipo t ON t.id_tipo = pt.id_tipo 
	INNER JOIN tipo_ataque ta ON ta.id_tipo_ataque = t.id_tipo_ataque
	INNER JOIN pokemon_movimiento_forma pmf ON pmf.numero_pokedex = p.numero_pokedex 
	INNER JOIN movimiento m ON m.id_movimiento = pmf.id_movimiento 
	INNER JOIN forma_aprendizaje fa ON fa.id_forma_aprendizaje = pmf.id_forma_aprendizaje 
	INNER JOIN tipo_forma_aprendizaje tfa ON tfa.id_tipo_aprendizaje = fa.id_tipo_aprendizaje 
WHERE tfa.tipo_aprendizaje = "nivel"
	AND t.nombre = "psiquico"
	AND ta.tipo = "especial"

/*Busca los pokemon que evolucionan mediante piedra trueno o mediante piedra lunar */
SELECT p.numero_pokedex, p.nombre AS pokemon, tp.nombre_piedra AS piedra_para_evolucionar 
FROM pokemon p 
	INNER JOIN pokemon_forma_evolucion pfe ON pfe.numero_pokedex = p.numero_pokedex
	INNER JOIN forma_evolucion fe ON fe.id_forma_evolucion = pfe.id_forma_evolucion 
	INNER JOIN piedra p2 ON p2.id_forma_evolucion = fe.id_forma_evolucion
	INNER JOIN tipo_piedra tp ON tp.id_tipo_piedra = p2.id_tipo_piedra 
WHERE tp.nombre_piedra = "piedra trueno"
	OR tp.nombre_piedra = "piedra lunar"
	
/*crea una tabla nueva llamada evolution que contenga solamente el nombre del pokemon y el nombre del
 *  pokemon desde el que evoluciona */
CREATE TABLE evolution (pokemon varchar(30), pokemon_origen varchar(30))

INSERT INTO evolution
SELECT DISTINCT p.nombre , p2.nombre 
FROM pokemon p 
	INNER JOIN evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex
	INNER JOIN pokemon p2 ON ed.pokemon_origen = p2.numero_pokedex 
	
/*Borra los movimientos con una precision de 00 que como efecto secundario * bajen alguna estadistica
 * (ataque,desfensa,especial....)*/
DELETE m.*, mes.*
FROM movimiento m 
	INNER JOIN movimiento_efecto_secundario mes ON mes.id_movimiento = m.id_movimiento 
	INNER JOIN efecto_secundario es ON es.id_efecto_secundario = mes.id_efecto_secundario
WHERE m.precision_mov = 00
	AND es.efecto_secundario IN ("bajar velocidad", "bajar ataque", "bajar defensa", "bajar especial")
	
/*Actualiza a 10 pokemon que evolucionan * mediante piedra fuego para que ahora lo hagan mediante piedra
 *  agua*/
UPDATE pokemon_forma_evolucion pfe
SET pfe.id_forma_evolucion = 4
WHERE pfe.numero_pokedex IN (SELECT DISTINCT p.numero_pokedex
		FROM pokemon p 
			INNER JOIN pokemon_forma_evolucion pfe ON pfe.numero_pokedex = p.numero_pokedex
			INNER JOIN forma_evolucion fe ON fe.id_forma_evolucion = pfe.id_forma_evolucion 
			INNER JOIN piedra p2 ON p2.id_forma_evolucion = fe.id_forma_evolucion
			INNER JOIN tipo_piedra tp ON tp.id_tipo_piedra = p2.id_tipo_piedra 
		WHERE tp.nombre_piedra = "piedra fuego")
	AND pfe.numero_pokedex NOT IN (SELECT DISTINCT p.numero_pokedex
		FROM pokemon p 
			INNER JOIN pokemon_forma_evolucion pfe ON pfe.numero_pokedex = p.numero_pokedex
			INNER JOIN forma_evolucion fe ON fe.id_forma_evolucion = pfe.id_forma_evolucion 
			INNER JOIN piedra p2 ON p2.id_forma_evolucion = fe.id_forma_evolucion
			INNER JOIN tipo_piedra tp ON tp.id_tipo_piedra = p2.id_tipo_piedra 
		WHERE tp.nombre_piedra = "piedra agua")
LIMIT 10

/*Borra los pokemon que evolucionan * mediante intercambio*/
DELETE p.*, pfe.*
FROM pokemon p 
	INNER JOIN pokemon_forma_evolucion pfe ON pfe.numero_pokedex = p.numero_pokedex
	INNER JOIN forma_evolucion fe ON fe.id_forma_evolucion = pfe.id_forma_evolucion
	INNER JOIN tipo_evolucion te ON te.id_tipo_evolucion = fe.tipo_evolucion 
WHERE te.tipo_evolucion = "intercambio"
	
/*Actualiza los pokemon que evolucionan de otro pokemon y resta 10 puntos de salud a su estadistica
 *  base(solo a los 10 primeros pokemon con mayor numero de ps)*/	
UPDATE estadisticas_base eb
SET eb.ps = (eb.ps-10)
WHERE eb.numero_pokedex IN (SELECT p.numero_pokedex 
	FROM pokemon p
		INNER JOIN evoluciona_de ed ON ed.pokemon_evolucionado = p.numero_pokedex
		INNER JOIN estadisticas_base eb ON eb.numero_pokedex = p.numero_pokedex
	ORDER BY eb.ps DESC)
LIMIT 10


	





	
	
	
	
	