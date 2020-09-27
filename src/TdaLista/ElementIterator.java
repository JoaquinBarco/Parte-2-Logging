package TdaLista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterador de lista
 * @author Barco Joaquin Ezequiel
 *
 * @param <E> elemento
 */
public class ElementIterator<E> implements Iterator<E>{
	
	protected PositionList<E> lista;
	protected Position<E> cursor;
	
	/**
	 * Inicializa un iterador de la lista l
	 * @param l lista a iterar
	 */
	public ElementIterator(PositionList<E> l) {
		try {
			lista = l;
			if(l.isEmpty()) {
				cursor = null;
			} else {
				cursor = l.first();
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean hasNext() {
		return cursor != null;
	}

	@Override
	public E next() {
		if(cursor == null) throw new NoSuchElementException("No hay elemento siguiente");
		E ret = cursor.element();
		try {
			if(cursor == lista.last()) {
				cursor = null;
			} else {
				try {
					cursor = lista.next(cursor);
				} catch (InvalidPositionException | BoundaryViolationException e2) {
					e2.printStackTrace();
				}
			}
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
