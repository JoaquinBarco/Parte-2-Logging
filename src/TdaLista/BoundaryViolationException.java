package TdaLista;

/**
 * Excepcion cuando la posicion se sale de la lista
 * @author Barco Joaquin Ezequiel
 *
 */
public class BoundaryViolationException extends Exception {
	
	/**
	 * Inicializa la excepcion
	 * @param msg mensaje a mostrar
	 */
	public BoundaryViolationException(String msg) {
		super(msg);
	}

}
