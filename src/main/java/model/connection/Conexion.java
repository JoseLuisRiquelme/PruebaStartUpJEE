package model.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	// 1. Declaramos una coneccion nula como parametro:
	private static Connection con = null;

	// 2. Declaramos un constructor singleton:
	private Conexion() {
		// 2.1 Aplicamos un bloque try-catch (Logica conexion a la DB)

		try {
//2.1.2. Se carga el driver en memoria para que el driver manager pueda encontrar el driver adecuado
			Class.forName("org.postgresql.Driver"); // esto es PSQL
			// Class.forName("com.mysql.jdbc.Driver"); // esto es mySQL
			// Class.forName("oracle.jdbc.driver.OracleDriver"); // esto es oracle

			// 2.1.3. Procedemos a realizar la coneccion mediante el driverManager y el
			// method getConnection()

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/startupdb", "postgres", "Postgres1234");

			// 2.1.3 verificar si la conection es valida
			boolean isValid = con.isValid(50000);
			System.out.println(isValid ? "TEST OK PSQL" : "TEST FAILES PSQL");
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error al conectar con la DB: " + ex.getMessage());
			
		}
	}

	public static Connection getCon() {

		if (con == null) {
			new Conexion();
		}
		return con;
	}

}
