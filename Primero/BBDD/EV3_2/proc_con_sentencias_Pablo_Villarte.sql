-- 1.8.2 Procedimientos con sentencias SQL
-- Escribe un procedimiento que reciba el nombre de un país como parámetro de entrada y realice una consulta sobre la tabla
-- cliente para obtener todos los clientes que existen en la tabla de ese país.
DELIMITER $$
DROP PROCEDURE IF EXISTS a1
$$
CREATE PROCEDURE a1(IN pais varchar(20))
BEGIN
	SELECT c.*
	FROM cliente c
	WHERE c.pais = pais;
END
$$
call a1("australia");
$$

-- Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres
-- (Ejemplo: PayPal, Transferencia, etc). Y devuelva como salida el pago de máximo valor realizado para esa forma de
-- pago. Deberá hacer uso de la tabla pago de la base de datos jardineria.
DELIMITER $$
DROP PROCEDURE IF EXISTS a2
$$
CREATE PROCEDURE a2(IN pago varchar(40))
BEGIN
	SELECT max(p.total) AS PAGO_MÁXIMO
	FROM pago p 
	WHERE pago = p.forma_pago;
END
$$
call a2("PayPal");
$$
-- Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres
-- (Ejemplo: PayPal, Transferencia, etc). Y devuelva como salida los siguientes valores teniendo en cuenta la forma
-- de pago seleccionada como parámetro de entrada: el pago de máximo valor, el pago de mínimo valor, el valor medio de
-- los pagos realizados, la suma de todos los pagos, el número de pagos realizados para esa forma de pago.
-- Deberá hacer uso de la tabla pago de la base de datos jardineria.
DELIMITER $$
DROP PROCEDURE IF EXISTS a3
$$
CREATE PROCEDURE a3(IN pago varchar(40))
BEGIN
	SELECT max(p.total) AS pago_max,
		min(p.total) AS pago_min,
		avg(p.total) AS pago_medio,
		sum(p.total) AS sumatorio_pagos,
		count(p.id_transaccion) AS num_pagos
	FROM pago p 
	WHERE pago = p.forma_pago;
END
$$
call a3("paypal");
$$
-- Crea una base de datos llamada procedimientos que contenga una tabla llamada cuadrados. La tabla cuadrados debe tener
-- dos columnas de tipo INT UNSIGNED, una columna llamada número y otra columna llamada cuadrado.
-- Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado calcular_cuadrados con las siguientes
-- características. El procedimiento recibe un parámetro de entrada llamado tope de tipo INT UNSIGNED y calculará el
-- valor de los cuadrados de los primeros números naturales hasta el valor introducido como parámetro. El valor del
-- números y de sus cuadrados deberán ser almacenados en la tabla cuadrados que hemos creado previamente.
-- Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos
-- valores de los cuadrados que va a calcular.
DELIMITER $$
DROP DATABASE IF EXISTS procedimientos2
$$
CREATE DATABASE procedimientos2 CHARACTER SET utf8mb4
$$
USE procedimientos2
$$
CREATE TABLE cuadrados(numero int unsigned, cuadrado int unsigned)
$$
DROP PROCEDURE IF EXISTS a4_alt
$$
CREATE PROCEDURE a4_alt(IN num int)
BEGIN
	FOR i IN 0..num
		DO
		INSERT INTO cuadrados VALUES(i, i*i);
	END FOR;
END
$$
CALL a4_alt(5);
$$
-- Utilice un bucle WHILE para resolver el procedimiento.
DELIMITER $$
DELETE c.* FROM cuadrados c
$$
DROP PROCEDURE IF EXISTS a4
$$
CREATE PROCEDURE a4 (IN num int)
BEGIN
	DECLARE i int default 0;
	WHILE i<num DO
		INSERT INTO cuadrados VALUES(i, i*i);
		SET i = i+1;
	END WHILE;
END
$$
CALL a4(100);
$$

-- Utilice un bucle REPEAT para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DELETE c.* FROM cuadrados c
$$
DROP PROCEDURE IF EXISTS a5
$$
CREATE PROCEDURE a5 (IN num int)
BEGIN
	DECLARE i int default 0;
	REPEAT 
		INSERT INTO cuadrados VALUES(i, i*i);
		SET i = i+1;
	UNTIL i>num 
	END REPEAT;
END
$$
CALL a5(10);
$$
-- Utilice un bucle LOOP para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DELETE c.* FROM cuadrados c
$$
DROP PROCEDURE IF EXISTS a6
$$
CREATE PROCEDURE a6 (IN num int)
BEGIN
	DECLARE i int default 0;
	bucle1: LOOP
		INSERT INTO cuadrados VALUES(i, i*i);
		SET i= i+1;
		IF i<=num THEN 
			ITERATE bucle1;
		END IF;
		LEAVE bucle1;
	END LOOP bucle1;
END
$$
CALL a6(23);
$$

-- Crea una base de datos llamada procedimientos que contenga una tabla llamada ejercicio. La tabla debe tener una única
-- columna llamada número y el tipo de dato de esta columna debe ser INT UNSIGNED.
-- Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado calcular_números con las siguientes
--  características. El procedimiento recibe un parámetro de entrada llamado valor_inicial de tipo INT UNSIGNED y deberá-
-- almacenar en la tabla ejercicio toda la secuencia de números desde el valor inicial pasado como entrada hasta el 1.
-- Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de las tablas antes de insertar los nuevos.
-- Utilice un bucle WHILE para resolver el procedimiento.
DELIMITER $$
DROP DATABASE IF EXISTS procedimientos3
$$
CREATE DATABASE procedimientos3 CHARACTER SET utf8mb4
$$
USE procedimientos3
$$
CREATE TABLE ejercicio(num int unsigned)
$$
DELETE e.* FROM ejercicio e
$$
DROP PROCEDURE IF EXISTS a7
$$
CREATE PROCEDURE a7 (IN num int unsigned)
BEGIN
	DECLARE i int default num;
		WHILE 1<=i DO
			INSERT INTO ejercicio VALUES(i);
			SET i = i-1;
		END WHILE;
END
$$
CALL a7(44);
$$
-- Utilice un bucle REPEAT para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DELETE e.* FROM ejercicio e
$$
DROP PROCEDURE IF EXISTS a8
$$
CREATE PROCEDURE a8 (IN num int unsigned)
BEGIN
	DECLARE i int default num;
		REPEAT
			INSERT INTO ejercicio VALUES(i);
			SET i = i-1;
			UNTIL i<=1
		END REPEAT;
END
$$
CALL a8(57);
$$
-- Utilice un bucle LOOP para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DELETE e.* FROM ejercicio e
$$
DROP PROCEDURE IF EXISTS a8
$$
CREATE PROCEDURE a8 (IN num int unsigned)
BEGIN
	DECLARE i int default num;
	bucle2: LOOP
		INSERT INTO ejercicio VALUES(i);
		SET i=i-1;
		IF i>=1 THEN 
			ITERATE bucle2;
		END IF;
		LEAVE bucle2;
	END LOOP bucle2;
END
$$
CALL a8(32);
$$

-- Crea una base de datos llamada procedimientos que contenga una tabla llamada pares y otra tabla llamada impares.
-- Las dos tablas deben tener única columna llamada número y el tipo de dato de esta columna debe ser INT UNSIGNED.
-- Una vez creada la base de datos y las tablas deberá crear un procedimiento llamado calcular_pares_impares con las
-- siguientes características. El procedimiento recibe un parámetro de entrada llamado tope de tipo INT UNSIGNED y
-- deberá almacenar en la tabla pares aquellos números pares que existan entre el número 1 el valor introducido como
-- parámetro. Habrá que realizar la misma operación para almacenar los números impares en la tabla impares.
-- Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de las tablas antes de insertar los nuevos valores.
-- Utilice un bucle WHILE para resolver el procedimiento.
DELIMITER $$
DROP DATABASE IF EXISTS procedimientos4
$$
CREATE DATABASE procedimientos4
$$
USE procedimientos4
$$
CREATE TABLE pares(numero int unsigned)
$$
CREATE TABLE impares(numero int unsigned)
$$
DROP PROCEDURE IF EXISTS calcular_pares_impares
$$
DELETE p.* FROM pares p 
$$
DELETE i.* FROM impares i 
$$
CREATE PROCEDURE calcular_pares_impares (IN tope_de_tipo INT UNSIGNED)
BEGIN
	DECLARE i INT  DEFAULT 1;
	DECLARE p INT DEFAULT 2;
	WHILE p<tope_de_tipo DO
		INSERT INTO pares VALUES(p);
		SET p= p+2;
	END WHILE;
	WHILE i<tope_de_tipo DO
		INSERT INTO impares VALUES(i);
		SET i= i+2;
	END WHILE;
END
$$
CALL calcular_pares_impares(100)
$$
-- Utilice un bucle REPEAT para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DROP PROCEDURE IF EXISTS calcular_pares_impares
$$
DELETE p.* FROM pares p 
$$
DELETE i.* FROM impares i 
$$
CREATE PROCEDURE calcular_pares_impares (IN tope_de_tipo INT UNSIGNED)
BEGIN
	DECLARE i INT  DEFAULT 1;
	DECLARE p INT DEFAULT 2;
	REPEAT 
		INSERT INTO pares VALUES(p);
		SET p = p+2;
		UNTIL p>=tope_de_tipo
	END REPEAT;
	REPEAT 
		INSERT INTO impares VALUES(i);
		SET i = i+2;
		UNTIL i>=tope_de_tipo
	END REPEAT;
END
$$
CALL calcular_pares_impares(100)
$$

-- Utilice un bucle LOOP para resolver el procedimiento del ejercicio anterior.
DELIMITER $$
DROP PROCEDURE IF EXISTS calcular_pares_impares
$$
DELETE p.* FROM pares p 
$$
DELETE i.* FROM impares i 
$$
CREATE PROCEDURE calcular_pares_impares (IN tope_de_tipo INT UNSIGNED)
BEGIN
	DECLARE i INT  DEFAULT 1;
	DECLARE p INT DEFAULT 2;
	buclePar: LOOP
		INSERT INTO pares VALUES(p);
		SET p = p+2;
		IF p < tope_de_tipo THEN 
			ITERATE buclePar;
		END IF;
		LEAVE buclePar;
	END LOOP buclePar;
	bucleImpar: LOOP
		INSERT INTO impares VALUES(i);
		SET i = i+2;
		IF i < tope_de_tipo THEN 
			ITERATE bucleImpar;
		END IF;
		LEAVE bucleImpar;
	END LOOP bucleImpar;
END
$$
CALL calcular_pares_impares(150)
$$
