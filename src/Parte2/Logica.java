package Parte2;

public class Logica {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addNode(1);
		g.addNode(2);
		g.addNode(2);
		g.removeNode(3);
		g.addEdge(1, 2);
		g.removeEdge(1, 2);
		g.removeEdge(1, 2);
		g.removeNode(2);
	}
}
