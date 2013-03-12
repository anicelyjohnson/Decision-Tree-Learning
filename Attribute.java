public class Attribute {
	public String name;
	public String[] possible_values;

	public Attribute(String n, String[] p) {
		name = n;
		possible_values = p;
	}

	public Attribute(String n) {
		name = n;
		String[] s = {};
		possible_values = s;
	}

	
}