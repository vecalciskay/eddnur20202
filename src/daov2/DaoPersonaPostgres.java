package daov2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import listas.Lista;

public class DaoPersonaPostgres extends DaoPersona {

	private final static Logger log = LogManager.getRootLogger();
	
	public DtoPersona get(int id) {
		IConexion conexion = Conexion.getSingleton();

		String query = "SELECT id, nombre FROM persona where id = " + id;
		ResultSet res = conexion.ejecutar(query);

		DtoPersona result = null;

		try {

			if (res.next()) {
				int _id = res.getInt("id");
				String _nombre = res.getString("nombre");

				result = new DtoPersona();
				result.setId(_id);
				result.setNombre(_nombre);
			}
		} catch (SQLException e) {
			log.error("Error en el motor SQL", e);
		}

		return result;
	}

	public Lista<DtoPersona> get() {
		Conexion conexion = Conexion.getSingleton();

		String query = "SELECT id, nombre FROM persona";
		ResultSet res = conexion.ejecutar(query);

		Lista<DtoPersona> result = new Lista<>();

		try {

			while (res.next()) {
				int _id = res.getInt("id");
				String _nombre = res.getString("nombre");

				DtoPersona p = new DtoPersona();
				p.setId(_id);
				p.setNombre(_nombre);

				result.insertar(p);
			}
		} catch (SQLException e) {
			log.error("Error en el motor SQL", e);
		}

		return result;
	}

	public int guardar(DtoPersona dto) throws SQLException {

		Conexion conexion = Conexion.getSingleton();

		if (dto.getId() <= 0) {
			// Insertar

			String query = "INSERT INTO persona (nombre) VALUES ('" + dto.getNombre() + "')";

			int nuevoId = conexion.ejecutarSimple(query);
			dto.setId(nuevoId);

		} else {
			// Update
			String query = "UPDATE persona SET nombre = '" + dto.getNombre() + "' WHERE id = " + dto.getId();

			conexion.ejecutarSimple(query);

		}

		return dto.getId();
	}

	public int eliminar(DtoPersona dto) throws Exception {
		Conexion conexion = Conexion.getSingleton();

		if (dto.getId() <= 0) {
			// Insertar
			throw new Exception("El dto debe tener un id mayor a 0");

		} else {
			// Update
			String query = "DELETE FROM persona WHERE id = " + dto.getId();

			conexion.ejecutarSimple(query);

		}
		
		return dto.getId();
	}

}
