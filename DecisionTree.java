/*
Programming Assignment 3: Decision Trees
Alexander Johnson and Daniel Chou




raining weekend
v       v       classifaction
*/

import java.util.*;
import java.util.Dictionary.*;

public class DecisionTree {

	public String value;
	public boolean classification;
	public String[] branch;
	public DecisionTree[] children;

	public DecisionTree(Attribute a) {
		value = a.name;
		branch = new String[10];
		children = new DecisionTree[10];
	}
	public DecisionTree(boolean b) {
		classification = b;
		value = null;
		branch = new String[10];
		children = new DecisionTree[10];
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Example[] examples = new Example[100];
		List attr = null;
		boolean d = false;
		int j =0;

		/*
		while (true) {
			System.out.println("Add attribute? y/n");
			String in1 = input.next();
			if (in1.equals("n")) {
				break;
			}
			System.out.println("Attribute name?");
			String new_attr_name = input.next();
			Attribute a = new Attribute(new_attr_name);
			if (attr == null) {
				attr = new List(a);
			} else {
				attr.add(a);
			}

			while(true) {
				System.out.println("Add a possible value to attribute " + a.name + " or enter NO_MORE_VALS.");
				String in2 = input.next();
				if (in2.toLowerCase().equals("no_more_vals")) {
					break;
				} else {
					String[] sarray = new String[a.possible_values.length + 1];
					int i = 0;
					for (i = 0; i < a.possible_values.length; i++) {
						sarray[i] = a.possible_values[i];
					}
					sarray[a.possible_values.length] = in2;
					a.possible_values = sarray;
				}
			}

		}

		while (true) {
			System.out.println("Add examples? y/n");
			String in3 = input.next();
			if (in3.equals("n")) {
				break;
			}
			Hashtable h = new Hashtable();
			boolean c = false;
			if (attr != null) {
			Node n = attr.root;
				while (n != null) {
					System.out.println("Value for " + n.value.name + ": ");
					String in4 = input.next();
					h.put(n.value.name, in4);
					n = n.next;
				}
			}
			System.out.println("Classification: (true/false)");
			c = input.nextBoolean();
			Example e = new Example(c, h);
			examples[j] = e;
			j++;

		}
		
		int i = 0;
		while (examples[i] != null) {
			i++;
		}
		Example[] real;
		if (i == 0) {
			real = new Example[1];
		} else {
			real = new Example[i];
		}
		for (int k = 0; k < i; k++) {
			real[k] = examples[k];
		}
		
		System.out.println("attr:");
		Node no = attr.root;
		while (no != null) {
			System.out.println(no.value.name);
			no = no.next;
		}
		System.out.println("examples");
		for (Example e: real) {
			System.out.println(e.classification);
		}
		Learning l = new Learning(real, attr, d);
		l.tree.display(0);
		*/

		/*
		System.out.println(l.tree.value);
		for (String b : l.tree.branch) {
			System.out.println("  " + b);
		}
		for (DecisionTree c : l.tree.children) {
			System.out.println(c.classification);
		}

	
		*/
		
		

		String[] yesno = {"yes", "no"};
		String[] patrons = {"some", "full", "none"};
		String[] pricerange = {"$", "$$", "$$$"};
		String[] genre = {"French", "Thai", "Italian", "Burger"};
		String[] wait = {"0-10","30-40","10-30", "30-60", ">60"};
		Attribute alt = new Attribute("alt", yesno);
		Attribute bar = new Attribute("bar", yesno);
		Attribute fri = new Attribute("fri", yesno);
		Attribute hun = new Attribute("hun", yesno);
		Attribute pat = new Attribute("pat", patrons);
		Attribute price = new Attribute("price", pricerange);
		Attribute rain = new Attribute("rain", yesno);
		Attribute res = new Attribute("res", yesno);
		Attribute type = new Attribute("type", genre);
		Attribute est = new Attribute("est", wait);

		List attr_list = new List(alt);
		attr_list.add(bar);
		attr_list.add(fri);
		attr_list.add(hun);
		attr_list.add(pat);
		attr_list.add(price);
		attr_list.add(rain);
		attr_list.add(res);
		attr_list.add(type);
		attr_list.add(est);

		Example[] examples = new Example[12];
		Hashtable ex1 = new Hashtable();
		ex1.put("alt", "yes");
		ex1.put("bar", "no");
		ex1.put("fri", "no");
		ex1.put("hun", "yes");
		ex1.put("pat", "some");
		ex1.put("price", "$$$");
		ex1.put("rain", "no");
		ex1.put("res", "yes");
		ex1.put("type", "French");
		ex1.put("est", "0-10");
		examples[0] = new Example(true, ex1);

		Hashtable ex2 = new Hashtable();
		ex2.put("alt", "yes");
		ex2.put("bar", "no");
		ex2.put("fri", "no");
		ex2.put("hun", "yes");
		ex2.put("pat", "full");
		ex2.put("price", "$");
		ex2.put("rain", "no");
		ex2.put("res", "no");
		ex2.put("type", "Thai");
		ex2.put("est", "30-40");
		examples[1] = new Example(false, ex2);

		Hashtable ex3 = new Hashtable();
		ex3.put("alt", "no");
		ex3.put("bar", "yes");
		ex3.put("fri", "no");
		ex3.put("hun", "no");
		ex3.put("pat", "some");
		ex3.put("price", "$");
		ex3.put("rain", "no");
		ex3.put("res", "no");
		ex3.put("type", "Burger");
		ex3.put("est", "0-10");
		examples[2] = new Example(true, ex3);

		Hashtable ex4 = new Hashtable();
		ex4.put("alt", "yes");
		ex4.put("bar", "no");
		ex4.put("fri", "yes");
		ex4.put("hun", "yes");
		ex4.put("pat", "full");
		ex4.put("price", "$");
		ex4.put("rain", "yes");
		ex4.put("res", "no");
		ex4.put("type", "Thai");
		ex4.put("est", "10-30");
		examples[3] = new Example(true, ex4);

		Hashtable ex5 = new Hashtable();
		ex5.put("alt", "yes");
		ex5.put("bar", "no");
		ex5.put("fri", "yes");
		ex5.put("hun", "no");
		ex5.put("pat", "full");
		ex5.put("price", "$$$");
		ex5.put("rain", "no");
		ex5.put("res", "yes");
		ex5.put("type", "French");
		ex5.put("est", ">60");
		examples[4] = new Example(false, ex5);

		Hashtable ex6 = new Hashtable();
		ex6.put("alt", "no");
		ex6.put("bar", "yes");
		ex6.put("fri", "no");
		ex6.put("hun", "yes");
		ex6.put("pat", "some");
		ex6.put("price", "$$");
		ex6.put("rain", "yes");
		ex6.put("res", "yes");
		ex6.put("type", "Italian");
		ex6.put("est", "0-10");
		examples[5] = new Example(true, ex6);

		Hashtable ex7 = new Hashtable();
		ex7.put("alt", "no");
		ex7.put("bar", "yes");
		ex7.put("fri", "no");
		ex7.put("hun", "no");
		ex7.put("pat", "none");
		ex7.put("price", "$");
		ex7.put("rain", "yes");
		ex7.put("res", "no");
		ex7.put("type", "Burger");
		ex7.put("est", "0-10");
		examples[6] = new Example(false, ex7);

		Hashtable ex8 = new Hashtable();
		ex8.put("alt", "no");
		ex8.put("bar", "no");
		ex8.put("fri", "no");
		ex8.put("hun", "yes");
		ex8.put("pat", "some");
		ex8.put("price", "$$");
		ex8.put("rain", "yes");
		ex8.put("res", "yes");
		ex8.put("type", "Thai");
		ex8.put("est", "0-10");
		examples[7] = new Example(true, ex8);

		Hashtable ex9 = new Hashtable();
		ex9.put("alt", "no");
		ex9.put("bar", "yes");
		ex9.put("fri", "yes");
		ex9.put("hun", "no");
		ex9.put("pat", "full");
		ex9.put("price", "$");
		ex9.put("rain", "yes");
		ex9.put("res", "no");
		ex9.put("type", "Burger");
		ex9.put("est", ">60");
		examples[8] = new Example(false, ex9);

		Hashtable ex10 = new Hashtable();
		ex10.put("alt", "yes");
		ex10.put("bar", "yes");
		ex10.put("fri", "yes");
		ex10.put("hun", "yes");
		ex10.put("pat", "full");
		ex10.put("price", "$$$");
		ex10.put("rain", "no");
		ex10.put("res", "yes");
		ex10.put("type", "Italian");
		ex10.put("est", "10-30");
		examples[9] = new Example(false, ex10);

		Hashtable ex11 = new Hashtable();
		ex11.put("alt", "no");
		ex11.put("bar", "no");
		ex11.put("fri", "no");
		ex11.put("hun", "no");
		ex11.put("pat", "none");
		ex11.put("price", "$");
		ex11.put("rain", "no");
		ex11.put("res", "no");
		ex11.put("type", "Thai");
		ex11.put("est", "0-10");
		examples[10] = new Example(false, ex11);

		Hashtable ex12 = new Hashtable();
		ex12.put("alt", "yes");
		ex12.put("bar", "yes");
		ex12.put("fri", "yes");
		ex12.put("hun", "yes");
		ex12.put("pat", "full");
		ex12.put("price", "$");
		ex12.put("rain", "no");
		ex12.put("res", "no");
		ex12.put("type", "Burger");
		ex12.put("est", "30-60");
		examples[11] = new Example(true, ex12);

		Learning l = new Learning(examples, attr_list, false);
		l.tree.display(0);


		


	}



	

	public void display(int depth) {
		
		if (branch[0] == null) {
			for (int f = depth; f > 0; f--) {
				System.out.print("   ");
			}
			System.out.println(classification);
		} else {
			int i = 0;
			while (branch[i] != null) {
				for (int d = depth; d > 0; d--) {
					System.out.print("   ");
				}
				System.out.println(value + ": " + branch[i]);
				children[i].display(depth + 1);
				i++;
			}	
		}
	}
}








