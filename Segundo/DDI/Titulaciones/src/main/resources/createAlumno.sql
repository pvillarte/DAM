create table IF NOT EXISTS alumno(
id bigint auto_increment,
nombre varchar(25),
edad bigint,
titulacion INT,
FOREIGN KEY (titulacion) REFERENCES titulacion(id)
);

ALTER TABLE alumno
ADD FOREIGN KEY (materia)
REFERENCES titulacion(id)