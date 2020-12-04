package daov2;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IConexion {

	public void conectar() throws SQLException;
	
	public ResultSet ejecutar(String query);
	
	public int ejecutarSimple(String query) throws SQLException;
}
