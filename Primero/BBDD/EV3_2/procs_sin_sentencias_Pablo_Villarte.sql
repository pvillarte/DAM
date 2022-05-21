DELIMITER $$

-- Procedimientos sin sentencias SQL
-- Ejercicio 1.8.1.1
-- Escribe un procedimiento que no tenga ningún parámetro de entrada ni de salida y que muestre el texto ¡Hola mundo!
DROP PROCEDURE IF EXISTS a1
$$
CREATE PROCEDURE a1()
BEGIN
	SELECT "¡Hola mundo!" AS SALIDA;
END
$$
CALL a1;
$$

-- Ejercicio 1.8.1.2
-- Escribe un procedimiento que reciba un número real de entrada y muestre un mensaje indicando si el número es positivo,
-- negativo o cero.
DROP PROCEDURE IF EXISTS a2
$$
CREATE PROCEDURE a2(IN num real)
BEGIN
	SELECT IF (num < 0, "NEGATIVO", IF (num>0, "POSITIVO", "CERO"))AS SALIDA;
END
$$
CALL a2(0);
$$

-- Ejercicio 1.8.1.3
-- Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor un
-- número real, y un parámetro de salida, con una cadena de caracteres indicando si el número es positivo, negativo o cero.
DROP PROCEDURE IF EXISTS a3
$$
CREATE PROCEDURE a3(IN num real, OUT resultado varchar(8))
BEGIN
	SELECT IF (num < 0, "NEGATIVO", IF (num>0, "POSITIVO", "CERO"))
	INTO resultado;
END
$$
CALL a3(0, @resultado)
$$
SELECT @resultado
$$

-- Ejercicio 1.8.1.4
-- Escribe un procedimiento que reciba un número real de entrada, que representa el valor de la nota de un alumno, y
-- muestre un mensaje indicando qué nota ha obtenido teniendo en cuenta las siguientes condiciones:
-- [0,5) = Insuficiente -  [5,6) = Aprobado - [6, 7) = Bien - [7, 9) = Notable - [9, 10] = Sobresaliente - Otro no valido
DROP PROCEDURE IF EXISTS a4
$$
CREATE PROCEDURE a4(IN num real)
BEGIN
	SELECT IF ((num < 0 OR num>10), "No valido",
		IF (num<5, "Insuficiente", 
			IF (num<6,"aprobado",
				IF (num<7, "bien",
					IF(num<9, "notable", 
						IF (num <= 10, "sobresaliente", 
							"No valido")))))) AS SALIDA;
END
$$
CALL a4(0);
$$

-- Ejercicio 1.8.1.5
-- Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor de la
-- nota en formato numérico y un parámetro de salida, con una cadena de texto indicando la nota correspondiente.
DROP PROCEDURE IF EXISTS a5
$$
CREATE PROCEDURE a5(IN num int, OUT resultado varchar(14))
BEGIN
	SELECT IF (num not between 0 and 10, "no valido", 
		IF (num=0 , "cero",
			IF(num=1, "uno", 
				IF (num=2, "dos", 
					IF (num=3, "tres",
						IF(num=4, "cuatro",
							IF (num=5, "cinco",
								IF (num=6, "seis",
									IF (num=7, "siete",
										IF(num=8, "ocho", 
											IF (num=9, "nueve", 
												IF (num=10, "diez", "no valido"))))))))))))
	INTO resultado;
END
$$
CALL a5(5, @resultado);
$$
SELECT @resultado
$$

-- Ejercicio 1.8.1.6
-- Resuelva el procedimiento diseñado en el ejercicio anterior haciendo uso de la estructura de control CASE.
DROP PROCEDURE IF EXISTS a6;
$$
CREATE PROCEDURE a6 (IN num INT, OUT resultado varchar(14))
BEGIN
	SELECT 
		(CASE
			WHEN num=0 THEN "cero"
			WHEN num=1 THEN "uno"
			WHEN num=2 THEN "dos"
			WHEN num=3 THEN "tres"
			WHEN num=4 THEN "cuatro"
			WHEN num=5 THEN "cinco"
			WHEN num=6 THEN "seis"
			WHEN num=7 THEN "siete"
			WHEN num=8 THEN "ocho"
			WHEN num=9 THEN "nueve"
			WHEN num=10 THEN "diez"
			ELSE "No valido"
		END)
	INTO resultado;
END
$$
CALL a6(7, @resultado);
$$
SELECT @resultado
$$

-- Ejercicio 1.8.1.7
-- Escribe un procedimiento que reciba como parámetro de entrada un valor numérico que represente un día de la semana
-- y que devuelva una cadena de caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el
-- valor de entrada 1 debería devolver la cadena lunes.
DROP PROCEDURE IF EXISTS a7;
$$
CREATE PROCEDURE a7 (IN num INT, OUT resultado varchar(14))
BEGIN
	SELECT 
		(CASE
			WHEN num=1 THEN "lunes"
			WHEN num=2 THEN "martes"
			WHEN num=3 THEN "miercoles"
			WHEN num=4 THEN "jueves"
			WHEN num=5 THEN "viernes"
			WHEN num=6 THEN "sabado"
			WHEN num=7 THEN "domingo"
			ELSE "No valido"
		END)
	INTO resultado;
END
$$
CALL a7(7, @resultado);
$$
SELECT @resultado
$$