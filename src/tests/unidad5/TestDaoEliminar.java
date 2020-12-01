package tests.unidad5;

import dao.DAOPersona;
import dao.DTOPersona;

public class TestDaoEliminar {
	public static void main(String[] args) throws Exception {
		
		DTOPersona persona = new DTOPersona();
		persona.setId(2);
		
		DAOPersona daoPersona = new DAOPersona();
		
		daoPersona.eliminar(persona);
	}
}
