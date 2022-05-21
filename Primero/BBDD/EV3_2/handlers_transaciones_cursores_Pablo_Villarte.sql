-- Crea una base de datos llamada test que contenga una tabla llamada alumno. La tabla debe tener cuatro columnas:
-- id: entero sin signo (clave primaria).
-- nombre: cadena de 50 caracteres.
-- apellido1: cadena de 50 caracteres.
-- apellido2: cadena de 50 caracteres.
CREATE DATABASE IF NOT EXISTS test;
USE test;
CREATE TABLE IF NOT EXISTS alumno(
	id int unsigned unique,
	nombre varchar(50),
	apellido1 varchar(50), 
	apellido2 varchar(50));

-- Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado insertar_alumno con las siguientes
-- características. El procedimiento recibe cuatro parámetros de entrada (id, nombre, apellido1, apellido2) y los
-- insertará en la tabla alumno. El procedimiento devolverá como salida un parámetro llamado error que tendrá un
-- valor igual a 0 si la operación se ha podido realizar con éxito y un valor igual a 1 en caso contrario.
-- Deberá manejar los errores que puedan ocurrir cuando se intenta insertar una fila que contiene una clave primaria repetida.
DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_alumno
$$
CREATE PROCEDURE IF NOT EXISTS insertar_alumno (
	IN id int unsigned,
	IN nombre varchar(50),
	IN apellido1 varchar(50), 
	IN apellido2 varchar(50))
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION SET @error = 1;
	INSERT INTO alumno VALUES (id, nombre, apellido1, apellido2);
	SET @error = 0;
END
$$
CALL insertar_alumno(2, 'a', 'b', 'c')
$$
SELECT @error
$$

-- OPCION ALTERNATIVA
DELIMITER $$
DROP PROCEDURE IF EXISTS insertar_alumno2
$$
CREATE PROCEDURE IF NOT EXISTS insertar_alumno2 (
	IN id int unsigned,
	IN nombre varchar(50),
	IN apellido1 varchar(50), 
	IN apellido2 varchar(50))
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET @error = 1;
	INSERT INTO alumno VALUES (id, nombre, apellido1, apellido2);
	WHILE  @error = 1 DO
		SET @error = 0; 
		SET id = id + 1;
		INSERT INTO alumno VALUES (id, nombre, apellido1, apellido2);
	END WHILE;
END
$$
CALL insertar_alumno2(2, 'a', 'b', 'c')
$$
SELECT @error
$$

-- Crea una base de datos llamada cine que contenga dos tablas con las siguientes columnas.
-- Tabla cuentas:
-- id_cuenta: entero sin signo (clave primaria).
-- saldo: real sin signo.
-- Tabla entradas:
-- id_butaca: entero sin signo (clave primaria).
-- nif: cadena de 9 caracteres.
DELIMITER $$
CREATE DATABASE IF NOT EXISTS cine
$$
USE cine
$$
CREATE TABLE IF NOT EXISTS cuentas (id_cuenta int unsigned unique, saldo real unsigned)
$$
CREATE TABLE IF NOT EXISTS entradas (id_butaca int unsigned unique, nif varchar(9))
$$
-- INSERT INTO cuentas values (1, 100)
$$
-- Una vez creada la base de datos y las tablas deberá crear un procedimiento llamado comprar_entrada con las
-- siguientes características. El procedimiento recibe 3 parámetros de entrada (nif, id_cuenta, id_butaca) y
-- devolverá como salida un parámetro llamado error que tendrá un valor igual a 0 si la compra de la entrada
-- se ha podido realizar con éxito y un valor igual a 1 en caso contrario.
-- El procedimiento de compra realiza los siguientes pasos:
-- Inicia una transacción.
-- Actualiza la columna saldo de la tabla cuentas cobrando 5 euros a la cuenta con el id_cuenta adecuado.
-- Inserta una una fila en la tabla entradas indicando la butaca (id_butaca) que acaba de comprar el usuario (nif).
-- Comprueba si ha ocurrido algún error en las operaciones anteriores. Si no ocurre ningún error entonces aplica
-- un COMMIT a la transacción y si ha ocurrido algún error aplica un ROLLBACK.
-- Deberá manejar los siguientes errores que puedan ocurrir durante el proceso.
-- ERROR 1264 (Out of range value)
-- ERROR 1062 (Duplicate entry for PRIMARY KEY)
DELIMITER $$
DROP PROCEDURE IF EXISTS comprar_entradas
$$
CREATE PROCEDURE IF NOT EXISTS comprar_entradas (
	IN nif varchar(9),
	IN id_cuenta int unsigned,
	in id_butaca int unsigned,
	OUT error BOOLEAN
)
BEGIN
	DECLARE EXIT HANDLER FOR 1264, 1062 
	BEGIN
		SET @error = 1;
		SELECT @error;
		ROLLBACK;
	END;
	START TRANSACTION;
	UPDATE cuentas c 
		SET c.saldo = c.saldo - 5
		WHERE c.id_cuenta = id_cuenta;
	INSERT INTO entradas VALUES (id_butaca, nif);
	COMMIT;
END
$$
CALL comprar_entradas('17456623Z', 1, 5, @error)
$$
-- ¿Qué ocurre cuando intentamos comprar una entrada y le pasamos como parámetro un número de cuenta que no
-- existe en la tabla cuentas? ¿Ocurre algún error o podemos comprar la entrada?
-- No se realiza la transaccion y se produce una excepción que da lugar a un ROLLBACK 
-- En caso de que exista algún error, ¿cómo podríamos resolverlo?.
-- Una posible solucion sería la de insertar un nuevo usuario y volver a intentarlo automaticamente.


-- Escribe las sentencias SQL necesarias para crear una base de datos llamada test, una tabla llamada alumnos
--  y 4 sentencias de inserción para inicializar la tabla. La tabla alumnos está formada por las siguientes columnas:
-- id (entero sin signo y clave primaria)
-- nombre (cadena de caracteres)
-- apellido1 (cadena de caracteres)
-- apellido2 (cadena de caracteres
-- fecha_nacimiento (fecha)
DELIMITER $$
CREATE DATABASE IF NOT EXISTS cursores
$$
USE cursores
$$
DROP TABLE IF EXISTS alumnos
$$
CREATE TABLE IF NOT EXISTS alumnos (id int unsigned unique, nombre varchar(30), ape1 varchar(30), ape2 varchar(30), fechaNac date)
$$
INSERT INTO alumnos values (1, "paco", "ramirez", "perez", "2000-4-11")
$$
INSERT INTO alumnos values (2, "pepe", "buesa", "che", "2005-2-11")
$$
INSERT INTO alumnos values (3, "pedro", "jalin", "peeeero", "2003-4-1")
$$
INSERT INTO alumnos values (4, "ramon", "ramos", "rametes", "1990-2-1")
$$
-- Una vez creada la tabla se decide añadir una nueva columna a la tabla llamada edad que será un valor calculado
-- a partir de la columna fecha_nacimiento. Escriba la sentencia SQL necesaria para modificar la tabla y añadir
-- la nueva columna.
ALTER TABLE alumnos ADD edad int unsigned
$$

-- Escriba una función llamada calcular_edad que reciba una fecha y devuelva el número de años que han pasado 
-- desde la fecha actual hasta la fecha pasada como parámetro:
-- Función: calcular_edad
-- Entrada: Fecha
-- Salida: Número de años (entero)
DELIMITER $$
DROP FUNCTION IF EXISTS calcular_edad
$$
CREATE FUNCTION IF NOT EXISTS calcular_edad (fecha DATE)
RETURNS int
BEGIN
	DECLARE age int;
	SET age = ABS(TRUNCATE(DATEDIFF(NOW(), fecha)/365,0));
	RETURN age;
END
$$
SELECT calcular_edad("2020-11-24")
$$
-- Ahora escriba un procedimiento que permita calcular la edad de todos los alumnmos que ya existen en
--  la tabla. Para esto será necesario crear un procedimiento llamado actualizar_columna_edad que calcule
--  la edad de cada alumno y actualice la tabla. Este procedimiento hará uso de la función calcular_edad
--  que hemos creado en el paso anterior.
DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_columna_edad
$$
CREATE PROCEDURE IF NOT EXISTS actualizar_columna_edad()
BEGIN
	DECLARE done INT default 0;
	DECLARE fechaCalculo date;
	DECLARE idAlu int;
	DECLARE eda int;
	DECLARE cur1 CURSOR FOR SELECT a.id, a.fechaNac FROM alumnos a;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
	OPEN cur1;
	bucle1 : LOOP
		FETCH cur1 INTO idAlu, fechaCalculo;
		IF done=1 THEN
			LEAVE bucle1;
		END IF;
		SET eda = (SELECT calcular_edad(fechaCalculo));
		UPDATE alumnos SET edad = eda WHERE id = idAlu;
	END LOOP;
	CLOSE cur1;
END
$$
CALL actualizar_columna_edad()
$$
-- Modifica la tabla alumnos del ejercicio anterior para añadir una nueva columna email. Una vez que hemos modificado
-- la tabla necesitamos asignarle una dirección de correo electrónico de forma automática.
-- Escriba un procedimiento llamado crear_email que dados los parámetros de entrada: nombre, apellido1, apellido2
-- y dominio, cree una dirección de email y la devuelva como salida.
-- Procedimiento: crear_email
-- Entrada:
-- nombre (cadena de caracteres)
-- apellido1 (cadena de caracteres)
-- apellido2 (cadena de caracteres)
-- dominio (cadena de caracteres)
-- Salida:
-- email (cadena de caracteres)
-- devuelva una dirección de correo electrónico con el siguiente formato:
-- El primer carácter del parámetro nombre.
-- Los tres primeros caracteres del parámetro apellido1.
-- Los tres primeros caracteres del parámetro apellido2.
-- El carácter @.
-- El dominio pasado como parámetro.
DELIMITER $$
DROP PROCEDURE IF EXISTS crear_email
$$
CREATE PROCEDURE IF NOT EXISTS crear_email(
	in nombre varchar(30), in ape1 varchar(30), in ape2 varchar(30), in dom varchar(30), out mail varchar(70))
BEGIN 
	SET mail = concat(substr(nombre, 1, 1), substr(ape1, 1, 3), substr(ape2, 1, 3), "@", dom);
END
$$
CALL crear_email("aaaa", "bbbb", "cccc", "gmail.com", @mail)
$$
SELECT @mail
$$
-- Ahora escriba un procedimiento que permita crear un email para todos los alumnmos que ya existen en la tabla.
-- Para esto será necesario crear un procedimiento llamado actualizar_columna_email que actualice la columna
-- email de la tabla alumnos. Este procedimiento hará uso del procedimiento crear_email que hemos creado en el paso anterior.
DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_columna_mail
$$
CREATE PROCEDURE IF NOT EXISTS actualizar_columna_mail()
BEGIN
	DECLARE done int default 0;
	DECLARE idAlu int;
	DECLARE nom varchar(30);
	DECLARE ap1 varchar(30);
	DECLARE ap2 varchar(30);
	DECLARE dom varchar(30) default "gmail.com";
	DECLARE cur2 CURSOR FOR SELECT a.id, a.nombre, a.ape1, a.ape2 FROM alumnos a;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
	OPEN cur2;
	bucle1 : LOOP
		IF done=1 THEN
			LEAVE bucle1;
		END IF;
		FETCH cur2 into idAlu, nom, ap1, ap2;
		call crear_email(nom, ap1, ap2, dom, @mail);
		UPDATE alumnos a set a.mail = @mail where a.id = idAlu;
	END LOOP;
	CLOSE cur2;
END
$$
CALL actualizar_columna_mail()
$$


-- Escribe un procedimiento llamado crear_lista_emails_alumnos que devuelva la lista de emails de la tabla
-- alumnos separados por un punto y coma. Ejemplo: juan@iescelia.org;maria@iescelia.org;pepe@iescelia.org;lucia@iescelia.org.
DELIMITER $$
DROP PROCEDURE IF EXISTS crear_lista_emails_alumnos
$$
CREATE PROCEDURE crear_lista_emails_alumnos(OUT lista text)
BEGIN
	DECLARE hecho int default 0;
	DECLARE correo varchar(50);
	DECLARE mailTemp text;
	DECLARE cur3 cursor for SELECT a.mail from alumnos a;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET hecho=1;
	set lista ="";
	OPEN cur3;
	bucle3: LOOP
		IF hecho = 1 THEN
			leave bucle3;
		END IF;
		FETCH cur3 INTO correo;
		set lista = CONCAT(lista," ; ", correo); 
	END LOOP;
	close cur3;
END
$$
CALL crear_lista_emails_alumnos(@lista)
$$
SELECT @lista
$$




