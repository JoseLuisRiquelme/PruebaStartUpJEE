package model.DAO;

import java.util.List;

import model.dto.Direccion;
import model.dto.Proveedor;
import model.dto.Usuario;

public interface UsuarioDAO {
	
	/*CRUD*/
	
	 void create(Usuario u); 
	
	 List<Usuario> read(); 
	
	 Usuario read(int id);
	
	 void update(Usuario u);
	
	 void delete(int id);

	Usuario read(Usuario u);

	List<Proveedor> readP();

	int readRol(int id);

	List<Direccion> readD();

	List<Direccion> readDU();

}
