public class Node {
	public Attribute value;
	public Node prev;
	public Node next;

	public Node(Attribute v, Node p, Node n) {
		value = v;
		prev = p;
		next = n;
	}

	public void remove() {
		if (next == null) {
			prev.next = next;
		} else {
			next.prev = prev;
			prev.next = next;
		}
	}
	
}