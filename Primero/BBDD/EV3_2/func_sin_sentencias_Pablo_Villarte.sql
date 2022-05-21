-- Escribe una función que reciba un número entero de entrada y devuelva TRUE si el número es par o FALSE en caso contrario.
DELIMITER $$
DROP DATABASE IF EXISTS funciones
$$
CREATE DATABASE IF NOT EXISTS funciones
$$
USE funciones
$$
DROP FUNCTION IF EXISTS f1
$$
CREATE FUNCTION f1(num INT) RETURNS BOOLEAN
BEGIN
	DECLARE resultado BOOLEAN;
	IF num%2=0 THEN
		SET resultado = 1;
		RETURN resultado;
	ELSE
		SET resultado = 0;
		RETURN resultado;
	END IF;
END
$$
SELECT f1(5)
$$
-- Escribe una función que devuelva el valor de la hipotenusa de un triángulo a partir de los valores de sus lados.
DELIMITER $$
DROP FUNCTION IF EXISTS f2
$$
CREATE FUNCTION f2(cateto1 DOUBLE UNSIGNED, cateto2 DOUBLE UNSIGNED)
RETURNS DOUBLE
BEGIN
	DECLARE hipotenusa DOUBLE UNSIGNED;
	SET hipotenusa= sqrt(cateto1*cateto1 + cateto2*cateto2);
	RETURN hipotenusa;
END
$$
SELECT f2(10,10)
$$
-- Escribe una función que reciba como parámetro de entrada un valor numérico que represente un día de la semana y que devuelva
-- una cadena de caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el valor de entrada 1 debería
-- devolver la cadena lunes.
DELIMITER $$
DROP FUNCTION IF EXISTS f3
$$
CREATE FUNCTION f3 (num INT UNSIGNED) 
RETURNS VARCHAR(30)
BEGIN
	DECLARE string VARCHAR(30);
	SET string = (
		CASE num 
			when 1 then "Lunes"
			when 2 then "Martes"
			when 3 then "Miercoles"
			when 4 then "Jueves"
			when 5 then "Viernes"
			when 6 then "Sabado"
			when 7 then "Domingo"
			else "No equivale a dia de la semana"
		END);
	RETURN string;
END
$$
SELECT f3(4)
$$
-- Escribe una función que reciba tres números reales como parámetros de entrada y devuelva el mayor de los tres.
DELIMITER $$
DROP FUNCTION IF EXISTS f4
$$
CREATE FUNCTION f4 (a INT, b INT, c INT)
RETURNS INT
BEGIN
	IF a>b THEN
		IF a>c THEN
			RETURN a;
		ELSE
			RETURN c;
		END IF;
	ELSE
		IF b>c THEN 
			RETURN b;
		ELSE
			RETURN C;
		END IF;
	END IF;
END
$$
SELECT f4(1, 4, 3)
$$
-- Escribe una función que devuelva el valor del área de un círculo a partir del valor del radio que se recibirá como parámetro
-- de entrada.
DELIMITER $$
DROP FUNCTION IF EXISTS f5
$$
CREATE FUNCTION f5(radio DOUBLE UNSIGNED)
RETURNS DOUBLE
BEGIN
	DECLARE area DOUBLE UNSIGNED;
	SET area = radio*radio * PI();
	RETURN area;
END
$$
SELECT f5(3)
$$
-- Escribe una función que devuelva como salida el número de años que han transcurrido entre dos fechas que se reciben como 
-- parámetros de entrada. Por ejemplo, si pasamos como parámetros de entrada las fechas 2018-01-01 y 2008-01-01 la función 
-- tiene que devolver que han pasado 10 años.
DELIMITER $$
DROP FUNCTION IF EXISTS f6
$$
CREATE FUNCTION f6 (fecha1 DATE, fecha2 DATE)
RETURNS INT 
BEGIN
	DECLARE dif INT;
	SET dif = ABS(TRUNCATE((DATEDIFF(fecha1, fecha2)/365),0));
	RETURN dif;
END
$$
SELECT f6("2010-01-12", "2018-01-10")
$$
-- Escribe una función que reciba una cadena de entrada y devuelva la misma cadena pero sin acentos. La función tendrá que 
-- reemplazar todas las vocales que tengan acento por la misma vocal pero sin acento. Por ejemplo, si la función recibe 
-- como parámetro de entrada la cadena María la función debe devolver la cadena Maria.
DELIMITER $$
DROP FUNCTION IF EXISTS f7
$$
CREATE FUNCTION f7 (entrada VARCHAR(50))
RETURNS VARCHAR(50)
BEGIN
	DECLARE salida VARCHAR(50);
	SET salida = entrada;
	SET salida = REPLACE(salida,'á','a');
	SET salida = REPLACE(salida,'Á','A');
	SET salida = REPLACE(salida,'é','e');
	SET salida = REPLACE(salida,'É','E');
	SET salida = REPLACE(salida,'í','i');
	SET salida = REPLACE(salida,'Í','I');
	SET salida = REPLACE(salida,'ó','o');
	SET salida = REPLACE(salida,'Ó','O');
	SET salida = REPLACE(salida,'ú','u');
	SET salida = REPLACE(salida,'Ú','U');
	RETURN salida;
END
$$
SELECT f7("Cañón")
$$
