package tests.unidad5;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * docker run -p 5432:5432 -d  
 *          -e POSTGRES_PASSWORD=postgres 
 *          -e POSTGRES_USER=postgres 
 *          -e POSTGRES_DB=edd-ejemplo 
 *          -v pgdata:/var/lib/postgresql/data postgres
 *          
 * Luego se puede conectar al postgres de la siguiente manera
 * 
 * docker exec -it 4012959f209f psql -U postgres edd-ejemplo
 * 
 * El numero de imagen se saca de la lista de procesos docker:
 * 
 * docker ps
 * 
 * @author Vladimir
 *
 */
public class TestConexionPostgres {
	private final static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		
		String host = "localhost";
		String database = "edd-ejemplo";
		int port = 5432;
		String username = "postgres";

		String password = "postgres"; // colocar la contraseña
		String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
		String urlcredentials = url + "?user=" + username + "&password=" + password;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(urlcredentials);
		} catch (SQLException e) {
			log.error("No pudo conectarse a la base de datos", e);
			System.exit(0);
		}
		String query = "SELECT id, nombre FROM persona";
		ResultSet res = null;
		try {
			Statement stmt = conn.createStatement();
			res = stmt.executeQuery(query);
		} catch (SQLException e) {
			log.error("No puede ejecutar la consulta SQL", e);
			System.exit(0);
		}
		try {
			while (res.next()) {
				int _id = res.getInt("id");
				String _nombre = res.getString("nombre");
				System.out.println("(" + _id + ") '" + _nombre + "'");
			}
			conn.close();
		} catch (SQLException e) {
			log.error("Error en el motor SQL", e);
		}
	}
}
