package TdaLista;

import java.util.Iterator;

/**
 * Tipo de dato abstracto lista doblemente enlazado
 * @author Barco Joaquin Ezequiel
 *
 * @param <E> elemento
 */
public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	
	protected int size;
	protected DNodo<E> head, tail;
	
	/**
	 * Inicializa una lista vacia
	 */
	public ListaDoblementeEnlazada() {
		size =0;
		head = new DNodo(null,null,null);
		tail = new DNodo(null,head,null);
		head.setNext(tail);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<E> first() throws EmptyListException {
		if(size == 0) throw new EmptyListException("La lista esta vacia");
		return head.getNext();
	}

	@Override
	public Position<E> last() throws EmptyListException {
		if(size == 0) throw new EmptyListException("La lista esta vacia");
		return tail.getPrev();
	}
	
	/**
	 * Verifica que la posicion sea valida y retorna el nodo de la posicion
	 * @param p posicion
	 * @return Nodo de la posicion
	 * @throws InvalidPositionException la posicion es invalida
	 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		DNodo<E> ret = null;
		if( p == null) throw new InvalidPositionException("Posición nula");
		if(p.element() == null) throw new InvalidPositionException("p eliminada previamente");
		try {
			ret = (DNodo<E>) p;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("La posicion es invalida");
		}
		return ret;
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> ret = pos.getNext();
		if(ret == tail) throw new BoundaryViolationException("La posicion ingresada es la ultima");
		return ret;
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> ret = pos.getPrev();
		if(ret == head) throw new BoundaryViolationException("La posicion ingresada es la primera");
		return ret;
	}

	@Override
	public void addFirst(E element) {
		size++;
		DNodo<E> nuevo = new DNodo<E>(element, head, null);
		nuevo.setNext(head.getNext());
		head.setNext(nuevo);
		nuevo.getNext().setPrev(nuevo);
	}

	@Override
	public void addLast(E element) {
		size++;
		DNodo<E> nuevo = new DNodo<E>(element, null, tail);
		nuevo.setPrev(tail.getPrev());
		tail.setPrev(nuevo);
		nuevo.getPrev().setNext(nuevo);		
	}

	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p);
		size++;
		DNodo<E> next = nodo.getNext();
		DNodo<E> nuevo = new DNodo<E>(element,nodo,next);
		nodo.setNext(nuevo);
		next.setPrev(nuevo);
	}

	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p);
		size++;
		DNodo<E> prev = nodo.getPrev();
		DNodo<E> nuevo = new DNodo<E> (element, prev, nodo);
		prev.setNext(nuevo);
		nodo.setPrev(nuevo);
		}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p);
		size--;
		nodo.getPrev().setNext(nodo.getNext());
		nodo.getNext().setPrev(nodo.getPrev());
		nodo.setPrev(null);
		nodo.setNext(null);
		nodo.setElement(null);
		return nodo.element();
	}

	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> nodo = checkPosition(p);
		E ret = nodo.element();
		nodo.setElement(element);
		return ret;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> p = new ListaDoblementeEnlazada<Position<E>>();
		if(size != 0) {
			Position<E> pos = null;
			try {
				pos = head.getNext();
				while(pos != tail.getPrev()) {
					p.addLast(pos);	
					pos = next(pos);
				}
				p.addLast(pos);
			} catch (InvalidPositionException | BoundaryViolationException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

}
