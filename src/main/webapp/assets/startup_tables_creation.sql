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

