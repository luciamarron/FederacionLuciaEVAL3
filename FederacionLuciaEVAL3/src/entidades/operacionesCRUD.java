package entidades;

public interface operacionesCRUD <T> {
	
	//Ejercicio 9 Examen 10
	public boolean insertarSinID(T elemento);
	
	public boolean insertarConID(T elemento); 
	
	//Ejercicio 10 Examen 10
	public long buscarPorID(T elemento);
	
	
	
}
