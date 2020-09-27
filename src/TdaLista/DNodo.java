package TdaLista;

/**
 * Nodo utilizado en la lista doblemente enlazada
 * @author Barco Joaquin Ezequiel
 *
 * @param <E> elemento
 */
public class DNodo<E> implements Position<E> {

	protected E element;
	protected DNodo<E> prev, next;
	
	
	/**
	 * Inicializa el nodo, con un elemento
	 * el nodo anterior y el nodo siguiente 
	 * @param e elemento
	 * @param p Nodo anterior
	 * @param n Nodo siguiente
	 */
	public DNodo(E e, DNodo<E> p, DNodo<E> n) {
		element = e;
		prev = p;
		next = n;
	}
	
	/**
	 * Establece el elemento
	 * @param e elemento
	 */
	public void setElement(E e) {
		element = e;
	}
	
	@Override
	public E element() {
		return element;
	}
	
	/**
	 * Devuelve el nodo siguiente
	 * @return el nodo siguiente
	 */
	public DNodo<E> getNext(){
		return next;
	}
	
	/**
	 * Establece el nodo siguiente
	 * @param n nodo siguiente
	 */
	public void setNext(DNodo<E> n) {
		next = n;
	}

	/**
	 * Retorna el nodo anterior
	 * @return nodo anterior
	 */
	public DNodo<E> getPrev(){
		return prev;
	}
	
	/**
	 * Establece el nodo anterior
	 * @param p nodo anterior
	 */
	public void setPrev(DNodo<E> p) {
		prev = p;
	}
	
}
