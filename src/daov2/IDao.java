package daov2;

import java.sql.SQLException;

import dao.DTOPersona;
import listas.Lista;

public interface IDao<E> {

	public int eliminar(E dto) throws Exception;
	public int guardar(E dto) throws SQLException;
	
	public Lista<E> get();
	public E get(int id);
}
