package Parte2;

public class Edge {
	Node prev, next;

	public Edge(Node p, Node n) {
		prev = p;
		next = n;
	}
	
	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
