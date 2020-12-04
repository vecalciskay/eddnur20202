package tests.unidad5;

import java.sql.SQLException;

import dao.DAOPersona;
import dao.DTOPersona;

public class TestDaoUpdate {

	public static void main(String[] args) throws SQLException {
		
		DAOPersona daoPersona= new DAOPersona();
		
		DTOPersona persona = daoPersona.get(4);
		
		persona.setNombre("Donald");
		
		daoPersona.guardar(persona);
	}
}
