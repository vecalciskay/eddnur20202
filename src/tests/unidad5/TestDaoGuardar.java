package tests.unidad5;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DAOPersona;
import dao.DTOPersona;

public class TestDaoGuardar {
	private final static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {

		DAOPersona dao = new DAOPersona();
		
		DTOPersona p = new DTOPersona();
		p.setNombre("Donald");
		
		
		try {
			dao.guardar(p);
		} catch (SQLException e) {
			log.error("No pudo guardar", e);
		}
		
		System.out.println(p);
	}
}
