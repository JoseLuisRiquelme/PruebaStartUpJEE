package model.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.connection.Conexion;
import model.dto.Direccion;
import model.dto.Proveedor;
import model.dto.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public void create(Usuario u) {
		try {
			String query3 = "{ call insert_usuario_con_rol(?, ?, ?, ?, ?, ?,?,?)}";

			Connection c = Conexion.getCon();

			CallableStatement cs = c.prepareCall(query3);

			cs.setString(1, u.getCorreo());
			cs.setString(2, u.getNick());
			cs.setString(3, u.getNombre());
			cs.setString(4, u.getPassword());
			cs.setInt(5, u.getPeso());
			cs.setInt(6, u.getRolId());
			cs.setString(7, u.getCalle());
			cs.setString(8, u.getNumeracion());

			/*
			 * String query1 =
			 * "insert into usuarios (correo,nick,nombre,password,peso) values('" +
			 * u.getCorreo() + "','" + u.getNick() + "','" + u.getNombre() + "','" +
			 * u.getPassword() + "'," + u.getPeso() + ")";
			 */
			/*System.out.println(u.toString());*/
			/*
			 * String query =
			 * "SELECT insert_usuario_con_rol('"+u.getCorreo()+"', '"+u.getNick()+"', '"+
			 * u.getNombre()+"', '"+u.getPassword()+"',"+u.getPeso()+","+u.getRolId();
			 */

			cs.execute();
		} catch (SQLException e) {

			System.out.println("ERROR en el metodo create");
			e.printStackTrace();
		}

	}

	@Override
	public List<Usuario> read() {

		List<Usuario> usuarios = new ArrayList<>();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select correo,nick,nombre,password,peso from usuarios";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {

				Usuario u = new Usuario();
				u.setCorreo(rs.getString("correo"));
				u.setNick(rs.getString("nick"));
				u.setNombre(rs.getString("nombre"));
				u.setPassword(rs.getString("password"));
				u.setPeso(rs.getInt("peso"));

				usuarios.add(u);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List read");
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public List<Proveedor> readP() {

		List<Proveedor> proveedores = new ArrayList<>();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select nombre,rubro,telefono from proveedores";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {

				Proveedor p = new Proveedor();
				p.setNombre(rs.getString("nombre"));
				p.setRubro(rs.getString("rubro"));
				p.setTelefono(rs.getString("telefono"));
				proveedores.add(p);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List readP");
			e.printStackTrace();
		}

		return proveedores;
	}

	@Override
	public List<Direccion> readD() {

		List<Direccion> direcciones = new ArrayList<>();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select nombre,numeracion,usuario_id from direcciones";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {

				Direccion d = new Direccion();
				d.setNombre(rs.getString("nombre"));
				d.setNumeracion(rs.getString("numeracion"));
				d.setUsuarioId(rs.getInt("usuario_id"));
				direcciones.add(d);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List readD");
			e.printStackTrace();
		}

		return direcciones;
	}

	@Override
	public List<Direccion> readDU() {

		List<Direccion> direcciones = new ArrayList<>();

		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "SELECT u.nombre AS usuario_nombre, d.nombre AS direccion_nombre, d.numeracion FROM usuarios u JOIN direcciones d ON u.id = d.usuario_id";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {

				Direccion d = new Direccion();
				d.setNombreUsuario(rs.getString("usuario_nombre"));
				d.setNombre(rs.getString("direccion_nombre"));
				d.setNumeracion(rs.getString("numeracion"));
				direcciones.add(d);
			}
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List readDU");
			e.printStackTrace();
		}

		return direcciones;
	}

	@Override
	public int readRol(int id) {
		int rol=-1;
		try {

			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select rol_id from roles_usuarios where usuario_id=" + id;
			 System.out.println("Executing query: " + query);
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) {
			 rol = rs.getInt("rol_id");
			 System.out.println("Found rol_id: " + rol);
			}else {
	            System.out.println("No rol_id found for usuario_id: " + id);
	        }

		} catch (SQLException e) {
			System.out.println("ERROR en el metodo List readR");
			e.printStackTrace();
		}
		
		System.out.println("Returning rol: " + rol);
		return rol;

	}

	@Override
	public Usuario read(int id) {

		Usuario u = new Usuario();

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select correo, nick, nombre, password, peso from usuarios where id=" + id;
			ResultSet rs = s.executeQuery(query);
			while (rs.next()) {
				u.setCorreo(rs.getString("correo"));
				u.setNick(rs.getString("nick"));
				u.setNombre(rs.getString("nombre"));
				u.setPassword(rs.getString("password"));
				u.setPeso(rs.getInt("peso"));

				return u;
			}
		} catch (SQLException e) {
			System.out.print("ERROR en el metodo id read");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Usuario read(Usuario u) {

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "select id,correo, nick, nombre, password, peso from usuarios where correo='" + u.getCorreo()
					+ "'";
			ResultSet rs = s.executeQuery(query);
			System.out.println(u.toString());
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setCorreo(rs.getString("correo"));
				u.setNick(rs.getString("nick"));
				u.setNombre(rs.getString("nombre"));
				u.setPassword(rs.getString("password"));
				u.setPeso(rs.getInt("peso"));
				System.out.println(u.toString());
				return u;
			}
		} catch (SQLException e) {
			System.out.print("ERROR en el metodo correo read");
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void update(Usuario u) {

		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "update corre, nick, nombre, password, peso values('" + u.getCorreo() + "','" + u.getNick()
					+ "','" + u.getNombre() + "','" + u.getPassword() + "'," + u.getPeso() + ") from usuarios where id="
					+ u.getId();
			s.execute(query);
		} catch (SQLException e) {
			System.out.println("ERROR en el metodo update");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			Connection c = Conexion.getCon();
			Statement s = c.createStatement();
			String query = "delete correo, nick, nombre, password, peso from usuarios where id=" + id;
			s.execute(query);
		} catch (SQLException e) {
			System.out.println("ERROR en metodo delete");
			e.printStackTrace();
		}

	}

}
