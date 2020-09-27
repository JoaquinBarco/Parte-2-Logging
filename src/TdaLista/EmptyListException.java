package TdaLista;

/**
 * Excepcion cuando la lista esta vacia
 * @author Barco Joaquin Ezequiel
 *
 */
public class EmptyListException extends Exception {
	
	/**
	 * Inicializa la excepcion
	 * @param msg mensaje a mostrar
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
	
}
