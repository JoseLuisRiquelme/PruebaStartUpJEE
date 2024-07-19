/*create table usuarios (id serial primary key,
					  correo varchar(50),
					  nick varchar(50),
					  nombre varchar(50),
					  pasword varchar(50),
					  peso integer,
					  created_at timestamp default current_timestamp,
					  update_at timestamp default current_timestamp);*/

--insert into usuarios (correo, nick, nombre, password, peso) values('correo1@example.cl','nick1','usuario1','password1',100);

--alter table usuarios rename column pasword to password;

--select * from usuarios;

/*create or replace function update_timestamp()
returns trigger as $$
begin
new.update_at = now();
return new;
end;
$$ language plpgsql;*/

/*create trigger set_timestamp
before update on usuarios
for each row
execute function update_timestamp();*/

/*create table direcciones (id serial primary key,
						 nombre varchar(50),
						 numeracion varchar(50),
						 usuario_id integer,
						 foreign key(usuario_id) references usuarios(id));*/

--select * from direcciones;

--insert into direcciones (nombre,numeracion,usuario_id) values('calle2','1112',2);
/*create table rol (id serial primary key,
				 nombre_rol varchar(50),
				 descripcion_rol varchar(50));*/
				 
--select * from rol;
--insert into rol(nombre_rol,descripcion_rol)values('supervisor','supervisa'),('operario','opera');

/*create table roles_usuarios (id serial primary key,
							usuarios_id integer,
							rol_id integer,
							foreign key(usuarios_id) references usuarios(id),
							foreign key(rol_id) references rol(id));*/
--select  * from roles_usuarios;
--select * from usuarios;
--insert into usuarios (correo,nick,nombre,password,peso)values('correo2@example.cl','nick2','usuario2','password2',200);
--insert into roles_usuarios(usuario_id,rol_id)values(1,1),(2,2);

--alter table roles_usuarios rename column usuarios_id to usuario_id;

--alter table rol rename to roles;
--select * from roles;
--select * from usuarios;
--select correo, nick, nombre, password, peso from usuarios where correo='pepe@example.cl' and password ='pepe1234';

--select * from usuarios;

--select * from roles;

--update roles set descripcion_rol='administra' where id=1;

--select * from roles_usuarios;
--drop table roles_usuarios;
/*create table roles_usuarios(usuario_id int not null,
						   rol_id int not null,
						   primary key(usuario_id,rol_id),
						   foreign key(usuario_id)references usuarios(id),
						   foreign key(rol_id)references roles(id));*/
						   
/*create or replace function insert_usuario_con_rol(correo varchar,
												  nick varchar,
												  nombre varchar,
												 password varchar,
												 peso integer,
												 rol_id int)
returns void as $$
declare
usuario_id int;
begin
insert into usuarios(correo,nick,nombre,password,peso)
values(correo,nick,nombre,password,peso)
returning id into usuario_id;

insert into roles_usuarios(usuario_id,rol_id)
values(usuario_id,rol_id);
end;
$$ language plpgsql;*/

--SELECT insert_usuario_con_rol('correo5@example.com', 'pupa', 'pupuito', 'pupu1234', 100, 2);

--select * from roles_usuarios;


--select * from usuarios;

--select id,correo, nick, nombre, password, peso from usuarios where correo='correo2@example.cl';

--select * from direcciones;
/*CREATE OR REPLACE FUNCTION insert_usuario_con_rol(
    correo VARCHAR,
    nick VARCHAR,
    nombre VARCHAR,
    password VARCHAR,
    peso INTEGER,
    rol_id INTEGER,
    direccion_nombre VARCHAR,
    direccion_numeracion VARCHAR
) RETURNS VOID AS $$
DECLARE
    usuario_id INTEGER;
BEGIN
    -- Inserta el usuario
    INSERT INTO usuarios (correo, nick, nombre, password, peso) 
    VALUES (correo, nick, nombre, password, peso);

    -- Obtiene el id del usuario recién insertado
    SELECT id INTO usuario_id FROM usuarios WHERE correo = correo;

    -- Inserta el rol del usuario
    INSERT INTO roles_usuarios (usuario_id, rol_id) 
    VALUES (usuario_id, rol_id);

    -- Inserta la dirección del usuario
    INSERT INTO direcciones (nombre, numeracion, usuario_id)
    VALUES (direccion_nombre, direccion_numeracion, usuario_id);
END;
$$ LANGUAGE plpgsql;*/

/*CREATE OR REPLACE FUNCTION insert_usuario_con_rol(
    p_correo VARCHAR,
    p_nick VARCHAR,
    p_nombre VARCHAR,
    p_password VARCHAR,
    p_peso INTEGER,
    p_rol_id INTEGER,
    p_direccion_nombre VARCHAR,
    p_direccion_numeracion VARCHAR
) RETURNS VOID AS $$
DECLARE
    usuario_id INTEGER;
BEGIN
    -- Inserta el usuario
    INSERT INTO usuarios (correo, nick, nombre, password, peso) 
    VALUES (p_correo, p_nick, p_nombre, p_password, p_peso);

    -- Obtiene el id del usuario recién insertado
    SELECT id INTO usuario_id FROM usuarios WHERE correo = p_correo;

    -- Inserta el rol del usuario
    INSERT INTO roles_usuarios (usuario_id, rol_id) 
    VALUES (usuario_id, p_rol_id);

    -- Inserta la dirección del usuario
    INSERT INTO direcciones (nombre, numeracion, usuario_id)
    VALUES (p_direccion_nombre, p_direccion_numeracion, usuario_id);
END;
$$ LANGUAGE plpgsql;*/

--DROP FUNCTION insert_usuario_con_rol(character varying,character varying,character varying,character varying,integer,integer,character varying,character varying)


/*CREATE OR REPLACE FUNCTION insert_usuario_con_rol(
    p_correo VARCHAR,
    p_nick VARCHAR,
    p_nombre VARCHAR,
    p_password VARCHAR,
    p_peso INTEGER,
    p_rol_id INTEGER,
    p_direccion_nombre VARCHAR,
    p_direccion_numeracion VARCHAR
) RETURNS VOID AS $$
DECLARE
    usuario_id INTEGER;
BEGIN
    -- Inserta el usuario
    INSERT INTO usuarios (correo, nick, nombre, password, peso) 
    VALUES (p_correo, p_nick, p_nombre, p_password, p_peso);

    -- Obtiene el id del usuario recién insertado
    SELECT id INTO usuario_id FROM usuarios WHERE correo = p_correo;

    -- Inserta el rol del usuario
    INSERT INTO roles_usuarios (usuario_id, rol_id) 
    VALUES (usuario_id, p_rol_id);

    -- Inserta la dirección del usuario
    INSERT INTO direcciones (nombre, numeracion, usuario_id)
    VALUES (p_direccion_nombre, p_direccion_numeracion, usuario_id);
END;
$$ LANGUAGE plpgsql;*/

--select *from usuarios;
--select * from direcciones;

/*create table proveedores (id serial primary key,
						 nombre varchar(50),
						 rubro varchar(50),
						 telefono varchar(50));*/
--select * from proveedores;
--INSERT INTO proveedores (nombre, rubro, telefono) VALUES ('TechWizards Inc.', 'Tecnología', '123-456-789');
--INSERT INTO proveedores (nombre, rubro, telefono) VALUES ('ChefSupplies Co.', 'Artículos de Cocina', '987-654-321');
--INSERT INTO proveedores (nombre, rubro, telefono) VALUES ('PetParadise', 'Productos para Mascotas', '555-123-456');
--INSERT INTO proveedores (nombre, rubro, telefono) VALUES ('FunToys Ltd.', 'Juguetes', '444-987-654');

/*SELECT u.nombre AS usuario_nombre, d.nombre AS direccion_nombre, d.numeracion
FROM usuarios u
JOIN direcciones d ON u.id = d.usuario_id;*/

--select * from usuarios;
--select rol_id from roles_usuarios where usuario_id=9;



--select rol_id from roles_usuarios where usuario_id=19;

--select * from roles_usuarios;
--select * from usuarios;

