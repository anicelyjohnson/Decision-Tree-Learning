public class List {
	public Node root;

	public List(Attribute v) {
		Node n = new Node(v, null, root);
		root = n;
		
	}

	public void add(Attribute v) {
		Node n = new Node(v, null, root);
		root = n;
		n.next.prev = n;
	}

	public void remove(Attribute v) {
		Node n = root;
		if (n.value == v) {
			root = n.next;
			if (root != null) {
				root.prev = null;
			}
		} else {
			while (n.value != v) {
				n = n.next;
			}
			n.remove();
		}
	}
}