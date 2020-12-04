package tests.unidad5;

import java.sql.SQLException;

import daov2.DaoPersona;
import daov2.DtoPersona;
import daov2.FactoryDao;

public class TestDaoV2Update {
	public static void main(String[] args) throws SQLException {

		DaoPersona daoPersona = FactoryDao.getOrCreate().newDaoPersona();

		DtoPersona persona = daoPersona.get(4);

		System.out.println(persona);
		
		persona.setNombre("Donald");

		daoPersona.guardar(persona);
	}
}
