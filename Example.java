import java.util.*;

public class Example {
	public boolean classification; //goal predicate
	public Hashtable attr_vals;

	public Example(boolean c, Hashtable a) {
		classification = c;
		attr_vals = a;
	}
}