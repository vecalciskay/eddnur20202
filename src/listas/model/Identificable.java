package listas.model;

public interface Identificable<T> {

	public boolean seIdentificaPor(T o);
	
	public T getId();
}
