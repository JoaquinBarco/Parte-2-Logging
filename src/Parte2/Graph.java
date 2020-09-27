package Parte2;

import java.util.Iterator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import TdaLista.InvalidPositionException;
import TdaLista.ListaDoblementeEnlazada;
import TdaLista.Position;
import TdaLista.PositionList;

public class Graph {
	
	PositionList<Node> listaNodos;
	PositionList<Edge> listaArcos;
	private static Logger logger;
	
	public Graph() {
		listaNodos = new ListaDoblementeEnlazada<Node>();
		listaArcos = new ListaDoblementeEnlazada<Edge>();
		
		if (logger == null){
			
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int node) {
		if(checkNode(node)==null) {
			Node aux = new Node(node);
			listaNodos.addLast(aux);
			logger.fine("Nodo agregado");
		} else {
			logger.warning("No se agrego nodo porque ya existia");
		}
	}
	
	private Node checkNode(int elem) {
		Node ret = null;
		Iterator<Node> it = listaNodos.iterator();
		while(it.hasNext() && ret == null) {
			Node aux = it.next();
			if(aux.getElem()==elem) {
				ret = aux;
			}
		}
		return ret;
	}
	
	public void addEdge(int node1, int node2) {
		Node n1 = checkNode(node1);
		Node n2 = checkNode(node2);
		boolean existeArco = false;
		
		Iterator<Edge> it = listaArcos.iterator();
		while(it.hasNext() && !existeArco) {
			Edge aux = it.next();
			if(aux.getPrev()==n1 && aux.getNext()==n2) {
				existeArco = true;
			}
		}
		
		if(!existeArco) {
			Edge aux = new Edge(n1, n2);
			listaArcos.addLast(aux);
			logger.fine("Se creo el arco");
		} else {
			logger.warning("No se agrego el arco porque ya existia");
		}
	}
	
	public void removeNode(int node) {
		boolean borre = false;
		Iterator<Position<Node>> it = listaNodos.positions().iterator();
		while(it.hasNext() && !borre) {
			Position<Node> aux = it.next();
			if(aux.element().getElem()==node) {
				try {
					listaNodos.remove(aux);
					borre = true;
				} catch (InvalidPositionException e) {
					e.printStackTrace();
				}
			}
		}
		if(borre) {
			logger.fine("Se borro el nodo correctamente");
		} else {
			logger.warning("No se elimino el nodo ya que no existe");
		}
	}
	
	public void removeEdge(int node1,int node2) {
		Node n1 = checkNode(node1);
		Node n2 = checkNode(node2);
		boolean borre = false;
		Iterator<Position<Edge>> it = listaArcos.positions().iterator();
		while(it.hasNext() && !borre) {
			Position<Edge> aux = it.next();
			if(aux.element().getPrev()==n1 && aux.element().getNext()==n2) {
				try {
					listaArcos.remove(aux);
					borre = true;
				} catch (InvalidPositionException e) {
					e.printStackTrace();
				}
			}
		}
		if(borre) {
			logger.fine("Se borro el arco correctamente");
		} else {
			logger.warning("No se elimino el arco ya que no existe");
		}
		
	}
	
}
