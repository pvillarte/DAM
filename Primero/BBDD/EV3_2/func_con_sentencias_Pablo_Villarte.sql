-- Escribe una función para la base de datos tienda que devuelva el número total de productos que hay en la tabla productos.
DELIMITER $$
USE tienda
$$
CREATE FUNCTION IF NOT EXISTS totalProductos()
RETURNS INT
BEGIN
	DECLARE salida INT;
	SET salida = (
		SELECT count(p.codigo) 
		FROM producto p);
	RETURN salida;
END
$$
SELECT totalProductos()
$$

-- Escribe una función para la base de datos tienda que devuelva el valor medio del precio de los productos de un
-- determinado fabricante que se recibirá como parámetro de entrada. El parámetro de entrada será el nombre del fabricante.
DELIMITER $$
USE tienda
$$
CREATE FUNCTION IF NOT EXISTS precioMedioFabricante(fabricante VARCHAR(40))
RETURNS FLOAT(10,2)
BEGIN
	DECLARE salida FLOAT(10,2);
	SET salida = (
		SELECT avg(p.precio) 
		FROM producto p 
			INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
		WHERE fabricante = f.nombre
		GROUP BY f.codigo
		);
	RETURN salida;
END
$$
SELECT precioMedioFabricante("Lenovo")
$$

-- Escribe una función para la base de datos tienda que devuelva el valor máximo del precio de los productos de un
-- determinado fabricante que se recibirá como parámetro de entrada. El parámetro de entrada será el nombre del fabricante.
DELIMITER $$
USE tienda
$$
CREATE FUNCTION IF NOT EXISTS precioMaximoFabricante(fabricante VARCHAR(40))
RETURNS FLOAT(10,2)
BEGIN
	DECLARE salida FLOAT(10,2);
	SET salida = (
		SELECT max(p.precio) 
		FROM producto p 
			INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
		WHERE fabricante = f.nombre
		);
	RETURN salida;
END
$$
SELECT precioMaximoFabricante("Asus")
$$

-- Escribe una función para la base de datos tienda que devuelva el valor mínimo del precio de los productos de un
-- determinado fabricante que se recibirá como parámetro de entrada. El parámetro de entrada será el nombre del fabricante
DELIMITER $$
USE tienda
$$
CREATE FUNCTION IF NOT EXISTS precioMinimoFabricante(fabricante VARCHAR(40))
RETURNS FLOAT(10,2)
BEGIN
	DECLARE salida FLOAT(10,2);
	SET salida = (
		SELECT min(p.precio) 
		FROM producto p 
			INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
		WHERE fabricante = f.nombre
		);
	RETURN salida;
END
$$
SELECT precioMinimoFabricante("Lenovo")
$$
