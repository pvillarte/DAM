-- COMPOSICIÓN INTERNA

-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de
--  la base de datos.
SELECT p.nombre AS producto, p.precio AS precio , f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo = f.codigo 

-- Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de
--  la base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT p.nombre, p.precio, f.nombre 
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
ORDER BY f.nombre

-- Devuelve una lista con el código del producto, nombre del producto, código del fabricante y nombre del
--  fabricante, de todos los productos de la base de datos.
SELECT p.nombre AS producto, p.precio AS precio , f.codigo AS cod_fabricante, f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo


-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT p.nombre AS producto, min(p.precio) AS precio , f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo

-- Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
SELECT p.nombre AS producto, max(p.precio) AS precio , f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
	
-- Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT p.nombre AS producto, f.nombre AS fabricante 
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
WHERE f.nombre = "lenovo"

-- Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
SELECT p.nombre AS producto, p.precio, f.nombre AS fabricante 
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
WHERE f.nombre = "crucial"
	AND p.precio > 200

-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. Sin
--  utilizar el operador IN.
SELECT p.nombre AS producto, f.nombre AS fabricante 
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
WHERE f.nombre = "asus"
	OR f.nombre = "Hewlett-Packard"
	OR f.nombre = "seagate"

-- Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packardy Seagate.
--  Utilizando el operador IN.
SELECT p.nombre AS producto, f.nombre AS fabricante 
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo 
WHERE f.nombre IN ("asus", "Hewlett-Packard", "seagate")

-- Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre
-- termine por la vocal e.
SELECT p.nombre AS producto, p.precio, f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre REGEXP "e$"


-- Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga
--  el carácter w en su nombre.
SELECT p.nombre AS producto, p.precio, f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre REGEXP "w"

-- Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos
--  que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio
--  (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)
SELECT p.nombre AS producto, p.precio, f.nombre AS fabricante
FROM producto p 
	INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE p.precio >= 180
ORDER BY p.precio DESC, f.nombre ASC

-- Devuelve un listado con el código y el nombre de fabricante, solamente de aquellos fabricantes que 
-- tienen productos asociados en la base de datos.
SELECT DISTINCT f.codigo, f.nombre AS fabricante
FROM fabricante f 
	INNER JOIN producto p ON p.codigo_fabricante = f.codigo
	
-- COMPOSICIÓN EXTERNA

-- Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos
-- que tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen 
-- productos asociados.
SELECT f.nombre AS fabricante, p.nombre AS producto
FROM fabricante f 
	LEFT JOIN producto p ON p.codigo_fabricante = f.codigo 
	
-- Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT f.nombre AS fabricante, p.nombre AS producto
FROM fabricante f 
	LEFT JOIN producto p ON p.codigo_fabricante = f.codigo
WHERE p.codigo IS NULL

-- ¿Pueden existir productos que no estén relacionados con un fabricante? Justifique su respuesta.
/*
 * Sin hacer ninguna variación en la estructura actual de esta base de datos, no. Puesto que es un dato
 * que es obligatorio, al igual que el código en este caso. Sin embargo, si en la tabla en un inicio se
 * hubiera definido como no obligatorio, como es el nombre en este caso, sí que sería posible.
*/

-- COMPOSICION INTERNA 2
-- Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.
SELECT e.nif, e.nombre, e.apellido1, e.apellido2, d.*
FROM empleado e 
	INNER JOIN departamento d ON d.codigo = e.codigo_departamento 
	
-- Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.
-- Ordena el resultado, en primer lugar por el nombre del departamento (en orden alfabético) y en
-- segundo lugar por los apellidos y el nombre de los empleados.
SELECT e.nif, e.nombre, e.apellido1, e.apellido2, d.*
FROM empleado e 
	INNER JOIN departamento d ON d.codigo = e.codigo_departamento
ORDER BY d.nombre ASC, e.apellido1 ASC, e.apellido2 ASC, e.nombre ASC
	
-- Devuelve un listado con el código y el nombre del departamento, solamente de aquellos departamentos
-- que tienen empleados.
SELECT DISTINCT d.codigo, d.nombre 
FROM departamento d 
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo 
	
-- Devuelve un listado con el código, el nombre del departamento y el valor del presupuesto actual del
-- que dispone, solamente de aquellos departamentos que tienen empleados. El valor del presupuesto 
-- actual lo puede calcular restando al valor del presupuesto inicial (columna presupuesto) el valor 
-- de los gastos que ha generado (columna gastos).
SELECT DISTINCT d.codigo, d.nombre, (d.presupuesto-d.gastos) AS presupuesto 
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
	
-- Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif 38382980M.
SELECT d.nombre
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE e.nif = "38382980M"

-- Devuelve el nombre del departamento donde trabaja el empleado Pepe Ruiz Santana.
SELECT d.nombre
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE e.nombre = "Pepe"
	AND e.apellido1 = "Ruiz"
	AND e.apellido2 = "Santana"
	
-- Devuelve un listado con los datos de los empleados que trabajan en el departamento de I+D. Ordena el
-- resultado alfabéticamente.
SELECT e.*, d.nombre AS departamento
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE d.nombre = "I+D"
ORDER BY e .nombre ASC

-- Devuelve un listado con los datos de los empleados que trabajan en el departamento de Sistemas,
-- Contabilidad o I+D. Ordena el resultado alfabéticamente.
SELECT e.*, d.nombre AS departamento
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE d.nombre = "I+D"
	OR d.nombre = "sistemas"
	OR d.nombre = 'Contabilidad' 
ORDER BY e .nombre ASC

-- Devuelve una lista con el nombre de los empleados que tienen los departamentos que no tienen un
-- presupuesto entre 100000 y 200000 euros.
SELECT e.*, d.nombre AS departamento, d.presupuesto 
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE d.presupuesto >=200000
	AND d.presupuesto >=100000

-- Devuelve un listado con el nombre de los departamentos donde existe algún empleado cuyo segundo
-- apellido sea NULL. Tenga en cuenta que no debe mostrar nombres de departamentos que estén repetidos.
SELECT DISTINCT d.nombre AS departamento
FROM departamento d
	INNER JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE e.apellido2 IS NULL

-- COMPOSICIÓN EXTERNA 2
-- Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan.
-- Este listado también debe incluir los empleados que no tienen ningún departamento asociado.
SELECT e.*, d.nombre, d.presupuesto, d.gastos 
FROM empleado e 
	LEFT JOIN departamento d ON e.codigo_departamento = d.codigo 

-- Devuelve un listado donde sólo aparezcan aquellos empleados que no tienen ningún departamento asociado.
SELECT e.*, d.nombre, d.presupuesto, d.gastos 
FROM empleado e 
	LEFT JOIN departamento d ON e.codigo_departamento = d.codigo
WHERE d.codigo IS NULL

-- Devuelve un listado donde sólo aparezcan aquellos departamentos que no tienen ningún empleado asociado.
SELECT d.*
FROM departamento d 
	LEFT JOIN empleado e ON e.codigo_departamento = d.codigo
WHERE e.codigo IS NULL

-- Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan. 
-- El listado debe incluir los empleados que no tienen ningún departamento asociado y los departamentos 
-- que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.
SELECT e.*, d.nombre AS departamento, d.presupuesto, d.gastos 
FROM empleado e 
	LEFT JOIN departamento d ON e.codigo_departamento = d.codigo
UNION 
SELECT e.*, d.nombre AS departamento, d.presupuesto, d.gastos 
FROM empleado e 
	RIGHT JOIN departamento d ON e.codigo_departamento = d.codigo
ORDER BY departamento ASC
 
-- Devuelve un listado con los empleados que no tienen ningún departamento asociado y los departamentos 
-- que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.
SELECT e.*, d.nombre AS departamento, d.presupuesto, d.gastos 
FROM empleado e 
	LEFT JOIN departamento d ON e.codigo_departamento = d.codigo
WHERE d.codigo IS NULL
UNION 
SELECT e.*, d.nombre AS departamento, d.presupuesto, d.gastos 
FROM empleado e 
	RIGHT JOIN departamento d ON e.codigo_departamento = d.codigo
WHERE e.codigo IS NULL
ORDER BY departamento ASC

-- COMPOSICIÓN INTERNA 3
-- Devuelve un listado con el identificador, nombre y los apellidos de todos los clientes que han realizado 
-- algún pedido. El listado debe estar ordenado alfabéticamente y se deben eliminar los elementos repetidos.
SELECT DISTINCT c.id, c.nombre , c.apellido1, c.apellido2 
FROM cliente c
	INNER JOIN pedido p ON p.id_cliente = c.id 
ORDER BY c.nombre, c.apellido1, c.apellido2

-- Devuelve un listado que muestre todos los pedidos que ha realizado cada cliente. El resultado debe mostrar 
-- todos los datos de los pedidos y del cliente. El listado debe mostrar los datos de los clientes ordenados 
-- alfabéticamente.
SELECT c.*, p.* 
FROM cliente c
	INNER JOIN pedido p ON p.id_cliente = c.id 
ORDER BY c.nombre, c.apellido1, c.apellido2

-- Devuelve un listado que muestre todos los pedidos en los que ha participado un comercial. El resultado 
-- debe mostrar todos los datos de los pedidos y de los comerciales. El listado debe mostrar los datos de 
-- los comerciales ordenados alfabéticamente.
SELECT p.*, c.*
FROM pedido p 
	INNER JOIN comercial c ON c.id = p.id_comercial
ORDER BY c.nombre, c.apellido1, c.apellido2

-- Devuelve un listado que muestre todos los clientes, con todos los pedidos que han realizado y con los 
-- datos de los comerciales asociados a cada pedido.
SELECT p.id_cliente, c.nombre , c.apellido1, c.apellido2,
	p.id AS id_pedido, p.total, p.fecha, p.id_comercial, 
	c2.nombre AS com_nombre, c2.apellido1 AS com_apellido1, c2.apellido2 AS com_apellido2, c2.comisión 
FROM cliente c
	INNER JOIN pedido p ON p.id_cliente = c.id
	INNER JOIN comercial c2 ON p.id_comercial = c2.id

-- Devuelve un listado de todos los clientes que realizaron un pedido durante el año 2017, cuya cantidad 
-- esté entre 300 € y 1000 €.
SELECT c.nombre , c.apellido1, c.apellido2, p.*
FROM cliente c 
	INNER JOIN pedido p ON p.id_cliente = c.id 
WHERE p.total BETWEEN 300 AND 1000
	AND year(p.fecha) = 2017 
	
-- Devuelve el nombre y los apellidos de todos los comerciales que ha participado en algún pedido realizado 
-- por María Santana Moreno.
SELECT DISTINCT c2.nombre AS com_nombre, c2.apellido1 AS com_apellido1, c2.apellido2 AS com_apellido2
FROM cliente c
	INNER JOIN pedido p ON p.id_cliente = c.id
	INNER JOIN comercial c2 ON p.id_comercial = c2.id
WHERE c.nombre = "maria"
	AND c.apellido1 = "santana"
	AND c.apellido2 = "moreno"

-- Devuelve el nombre de todos los clientes que han realizado algún pedido con el comercial Daniel Sáez Vega.
SELECT DISTINCT c.nombre , c.apellido1, c.apellido2
FROM cliente c
	INNER JOIN pedido p ON p.id_cliente = c.id
	INNER JOIN comercial c2 ON p.id_comercial = c2.id
WHERE c2.nombre = "daniel"
	AND c2.apellido1 = "saez"
	AND c2.apellido2 = "vega"
	
-- COMPOSICIÓN EXTERNA 3
-- Devuelve un listado con todos los clientes junto con los datos de los pedidos que han realizado. 
-- Este listado también debe incluir los clientes que no han realizado ningún pedido. El listado debe 
-- estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los clientes.
SELECT c.nombre , c.apellido1, c.apellido2, p.*
FROM cliente c
	LEFT JOIN pedido p ON p.id_cliente = c.id 
ORDER BY c.nombre, c.apellido1, c.apellido2

-- Devuelve un listado con todos los comerciales junto con los datos de los pedidos que han realizado. 
-- Este listado también debe incluir los comerciales que no han realizado ningún pedido. El listado debe 
-- estar ordenado alfabéticamente por el primer apellido, segundo apellido y nombre de los comerciales.
SELECT c.nombre , c.apellido1, c.apellido2, p.*
FROM comercial c
	LEFT JOIN pedido p ON p.id_comercial = c.id 
ORDER BY c.nombre, c.apellido1, c.apellido2

-- Devuelve un listado que solamente muestre los clientes que no han realizado ningún pedido.
SELECT DISTINCT c.nombre , c.apellido1, c.apellido2, p.*
FROM cliente c
	LEFT JOIN pedido p ON p.id_cliente = c.id
WHERE p.id IS NULL

-- Devuelve un listado que solamente muestre los comerciales que no han realizado ningún pedido.
SELECT DISTINCT c.nombre , c.apellido1, c.apellido2, p.*
FROM comercial c
	LEFT JOIN pedido p ON p.id_comercial = c.id
WHERE p.id IS NULL

-- Devuelve un listado con los clientes que no han realizado ningún pedido y de los comerciales que no han 
-- participado en ningún pedido. Ordene el listado alfabéticamente por los apellidos y el nombre. En en 
-- listado deberá diferenciar de algún modo los clientes y los comerciales.
SELECT DISTINCT  c.nombre, c.apellido1, c.apellido2, "Cliente" AS tipo
FROM cliente c
	LEFT JOIN pedido p ON p.id_cliente = c.id
WHERE p.id IS NULL
UNION
SELECT DISTINCT c2.nombre, c2.apellido1, c2.apellido2, "Comercial" AS tipo
FROM comercial c2
	LEFT JOIN pedido p ON p.id_comercial = c2.id
WHERE p.id IS NULL
	
-- ¿Se podrían realizar las consultas anteriores con NATURAL LEFT JOIN o NATURAL RIGHT JOIN? Justifique 
-- su respuesta.
/* 
 * No, puesto que las columnas a comparar no utilizan el mismo nombre (hay que comparar id con 
 * id_ cliente o id_comercial) 
*/

-- COMPOSICION INTERNA 4
-- Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	
-- Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes 
-- de ventas.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	INNER JOIN pago p ON p.codigo_cliente = c.codigo_cliente 
	
-- Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes 
-- de ventas.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.codigo_cliente NOT IN (
	SELECT DISTINCT c.codigo_cliente
	FROM cliente c
		INNER JOIN pago p ON p.codigo_cliente = c.codigo_cliente)

-- Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la 
-- ciudad de la oficina a la que pertenece el representante.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2, o.ciudad 
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	INNER JOIN pago p ON p.codigo_cliente = c.codigo_cliente
	INNER JOIN oficina o ON o.codigo_oficina = e.codigo_oficina 
	
-- Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con 
-- la ciudad de la oficina a la que pertenece el representante.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2, o.ciudad 
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	INNER JOIN oficina o ON o.codigo_oficina = e.codigo_oficina 
WHERE c.codigo_cliente NOT IN (
	SELECT DISTINCT c.codigo_cliente
	FROM cliente c
		INNER JOIN pago p ON p.codigo_cliente = c.codigo_cliente)

-- Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
SELECT o.linea_direccion1, o.linea_direccion2, o.codigo_postal, o.ciudad, 
	o.region, o.pais, c.ciudad AS ciudad_cliente
FROM oficina o
	INNER JOIN empleado e ON e.codigo_oficina = o.codigo_oficina 
	INNER JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.ciudad = "fuenlabrada"
		
-- Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina 
-- a la que pertenece el representante.
SELECT DISTINCT c.nombre_cliente, e.nombre AS rep_nombre, 
	e.apellido1 AS rep_apellido1, e.apellido2 AS rep_apellido2, o.ciudad AS ciudad_representante
FROM cliente c
	INNER JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	INNER JOIN oficina o ON o.codigo_oficina = e.codigo_oficina 
	
-- Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
SELECT e.nombre AS empleado, e2.nombre AS jefe
FROM empleado e 
	INNER JOIN empleado e2 ON e2.codigo_empleado = e.codigo_jefe
	
-- Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe 
-- de sus jefe.
SELECT e.nombre AS empleado, e2.nombre AS jefe, e3.nombre AS jefe_de_jefe
FROM empleado e 
	INNER JOIN empleado e2 ON e2.codigo_empleado = e.codigo_jefe
	INNER JOIN empleado e3 ON e2.codigo_jefe = e3.codigo_empleado
	
-- Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
SELECT DISTINCT c.nombre_cliente, p.fecha_esperada, p.fecha_entrega 
FROM cliente c 
	INNER JOIN pedido p ON p.codigo_cliente = c.codigo_cliente
WHERE DATEDIFF(p.fecha_esperada, p.fecha_entrega) < 0 
	
-- Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
SELECT DISTINCT c.nombre_cliente, gp.gama 
FROM cliente c
	INNER JOIN pedido p ON p.codigo_cliente = c.codigo_cliente 
	INNER JOIN detalle_pedido dp ON dp.codigo_pedido = p.codigo_pedido 
	INNER JOIN producto p2 ON p2.codigo_producto = dp.codigo_producto 
	INNER JOIN gama_producto gp ON gp.gama = p2.gama
ORDER BY c.codigo_cliente 

-- COMPOSICION EXTERNA 4
-- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT DISTINCT c.nombre_cliente
FROM cliente c 
	LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
WHERE p.id_transaccion IS NULL

-- Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
SELECT DISTINCT c.nombre_cliente
FROM cliente c 
	LEFT JOIN pedido p ON p.codigo_cliente = c.nombre_cliente 
WHERE p.codigo_pedido IS NULL
 
-- Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no
-- han realizado ningún pedido.
SELECT DISTINCT c.nombre_cliente
FROM cliente c 
	LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
WHERE p.id_transaccion IS NULL
UNION 
SELECT DISTINCT c.nombre_cliente
FROM cliente c 
	LEFT JOIN pedido p2 ON p2.codigo_cliente = c.nombre_cliente 
WHERE p2.codigo_pedido IS NULL

-- Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
SELECT e.codigo_empleado, o.codigo_oficina 
FROM empleado e 
	LEFT JOIN oficina o ON o.codigo_oficina = e.codigo_oficina
WHERE o.codigo_oficina IS NULL 

-- Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2 
FROM empleado e 
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.codigo_cliente IS NULL 

-- Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto
-- con los datos de la oficina donde trabajan.
SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2, o.*
FROM empleado e 
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
	LEFT JOIN oficina o ON o.codigo_oficina = e.codigo_oficina 
WHERE c.codigo_cliente IS NULL 

-- Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no
-- tienen un cliente asociado.
SELECT e.codigo_empleado
FROM empleado e 
	LEFT JOIN oficina o ON o.codigo_oficina = e.codigo_oficina
WHERE o.codigo_oficina IS NULL
UNION 
SELECT e.codigo_empleado
FROM empleado e 
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.codigo_cliente IS NULL 

-- Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT DISTINCT p.*
FROM producto p 
	LEFT JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
WHERE dp.codigo_producto IS NULL

-- Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar
-- el nombre, la descripción y la imagen del producto.
SELECT DISTINCT p.nombre, gp.descripcion_texto, gp.descripcion_html, gp.imagen 
FROM producto p 
	LEFT JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
	LEFT JOIN gama_producto gp ON gp.gama = p.gama 
WHERE dp.codigo_producto IS NULL

-- Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes
-- de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
SELECT DISTINCT o.codigo_oficina, e2.codigo_empleado 
FROM oficina o
	INNER JOIN empleado e2 ON e2.codigo_oficina = o.codigo_oficina
WHERE e2.codigo_empleado NOT IN (
	SELECT DISTINCT e.codigo_empleado
	FROM empleado e 
		INNER JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado 
		INNER JOIN pedido p ON p.codigo_cliente = c.codigo_cliente 
		INNER JOIN detalle_pedido dp ON dp.codigo_pedido = p.codigo_pedido 
		INNER JOIN producto p2 ON p2.codigo_producto = dp.codigo_producto 
		INNER JOIN gama_producto gp ON gp.gama = p2.gama
	WHERE p2.gama = "frutales")

-- Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.
SELECT DISTINCT c.codigo_cliente, c.nombre_cliente 
FROM cliente c 
	LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente
	INNER JOIN pedido p2 ON p2.codigo_cliente = c.codigo_cliente 
WHERE p.id_transaccion IS NULL

-- Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre
-- de su jefe asociado.
SELECT e.*, e2.nombre AS jefe_asociado
FROM empleado e 
	INNER JOIN empleado e2 ON e2.codigo_empleado = e.codigo_jefe
	LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE c.codigo_cliente IS NULL


 

