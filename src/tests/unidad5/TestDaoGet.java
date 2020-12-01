package tests.unidad5;

import dao.DAOPersona;
import dao.DTOPersona;
import listas.Lista;

public class TestDaoGet {
	public static void main(String[] args) {
		
		DAOPersona daoPersona = new DAOPersona();

		Lista<DTOPersona> personas = daoPersona.get();

		for (DTOPersona dtoPersona : personas) {
			System.out.println(dtoPersona);	
		}
		
		
		/*
		 * MateriaDAO m = ...
		 * 
		 * MateriaDTO m1 = m.get(5);
		 * 
		 * PersonaDAO p = ....
		 * 
		 * PersonaDTO p1 = p.get(10);
		 * 
		 * 		 * 
		 * 
		 */
	}
}
