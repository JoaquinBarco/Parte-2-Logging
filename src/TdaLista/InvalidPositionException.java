package TdaLista;

/**
 * Excepcion cuando la posicion es invalida
 * @author bmagario
 *
 */
public class InvalidPositionException extends Exception {

	/**
	 * Inicializa la excapcion
	 * @param msg mensaje a mostrar
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
	
}
