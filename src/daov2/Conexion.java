package daov2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Conexion implements IConexion {

	private final static Logger log = LogManager.getRootLogger();
	private static Conexion singleton = null;

	public static Conexion getSingleton() {
		if (singleton == null)
			singleton = new Conexion();
		return singleton;
	}

	private Connection conn;

	private Conexion() {

	}

	public void conectar() throws SQLException {

		if (conn != null && !conn.isClosed()) {
			return;
		}

		String host = "localhost";
		String database = "edd-ejemplo";
		int port = 5432;
		String username = "postgres";

		String password = "postgres"; // colocar la contraseña
		String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
		String urlcredentials = url + "?user=" + username + "&password=" + password;
		conn = null;
		try {
			conn = DriverManager.getConnection(urlcredentials);
		} catch (SQLException e) {
			log.error("No pudo conectarse a la base de datos", e);
			throw e;
		}
	}

	public ResultSet ejecutar(String query) {
		ResultSet res = null;
		try {
			conectar();

			Statement stmt = conn.createStatement();
			res = stmt.executeQuery(query);
		} catch (SQLException e) {
			log.error("No puede ejecutar la consulta SQL", e);
			System.exit(0);
		}

		return res;
	}

	public int ejecutarSimple(String query) throws SQLException {
		int result = 0;
		conectar();
		
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		return result;
	}
}
