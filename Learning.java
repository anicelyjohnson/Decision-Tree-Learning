public class Learning {


	public DecisionTree tree;

	public Learning(Example[] e, List a, boolean d) {
		tree = decision_tree_learning(e, a, d);
	}

	public DecisionTree decision_tree_learning(Example[] examples, List attribs, boolean def) {
			boolean all_examples_have_same_classification = false;
			int yes_counter = 0;
			int no_counter = 0;
			boolean majority_value = false;

			if (examples == null || examples.length == 0 || examples[0] == null) {
				//System.out.println("Examples " + examples[0]);
				DecisionTree d = new DecisionTree(def);//leaf node
				return d;
			} 

			for (int i = 0; i < examples.length; i++) {
				if (examples[i].classification == true) {
					yes_counter++;
				} else {
					no_counter++;
				}
			}
			System.out.println("yes: " + yes_counter + " no: " + no_counter);
			if (yes_counter == 0 || no_counter == 0) {
				all_examples_have_same_classification = true;
			}
			if (yes_counter >= no_counter) {
				majority_value = true;
			} else {
				majority_value = false;
			}


			if (all_examples_have_same_classification) {
				System.out.println("classification ");
				return new DecisionTree(examples[0].classification);			//as a node
			} else if (attribs == null || attribs.root == null) {
				System.out.println("attrib.root " + attribs.root);
				return new DecisionTree(majority_value);
			} else {
				System.out.println("else clause");
				Attribute best = choose_attribute(attribs, examples);
				System.out.println("using attribute " + best.name);
				DecisionTree tree = new DecisionTree(best);
				int j = 0;
				for (String val : best.possible_values) {
					System.out.println("val: " + val);
					//take each example thats value of "best" asttr is the same as val
					Example[] next = new Example[10];
					int i = 0;
					
					for (Example e : examples) {
						if (e.attr_vals.get(best.name).equals(val)) {
							next[i] = e;
						i++;
						}
					}
					Example[] real = new Example[i];
					for (i = 0; i < real.length; i++) {
						real[i] = next[i];
					}

					System.out.println("attrib.root: " + attribs.root.value.name);
					List attribs_minus_best = new List(attribs.root.value);
					Node n = attribs.root.next;
					while (n != null) {
						attribs_minus_best.add(n.value);
						n = n.next;
					}
					Node test = attribs_minus_best.root;
					while (test != null) {
						System.out.println(test.value.name);
						test = test.next;
					}
					
					attribs_minus_best.remove(best);
					DecisionTree subtree = decision_tree_learning(real, attribs_minus_best, majority_value);
					tree.branch[j] = val;
					tree.children[j] = subtree;
					j++;
				}
				return tree;
			}
		}

		private double gain(Attribute a, Example[] e){
			int pi = 0;
			int ni = 0;
			int p = 0;
			int n = 0;
			double remainder = 0;
			double i = 0;
			for (Example ex : e) {
				if (ex.classification) {
					p++;
				} else {
					n++;
				}
			}
			for (String val : a.possible_values) {
				for (Example ex : e) {
					if (ex.attr_vals.get(a.name).equals(val)) {
						if (ex.classification) {
							pi++;
						} else {
							ni++;
						}
					}
				}
				if((pi+ni) != 0)
					i = -pi/(pi + ni) * (Math.log(pi/(pi+ni))/Math.log(2)) - ni/(pi+ni) * (Math.log(ni/(pi+ni))/Math.log(2));
				remainder += (pi+ni) / (p+n) * i;
			}

			if((p+n) != 0)
				i = -p/(p + n) * (Math.log(p/(p+n))/Math.log(2)) - n/(p+n) * (Math.log(n/(p+n))/Math.log(2));

			return i - remainder;

		}

		private Attribute choose_attribute(List attribs, Example[] examples) {
			Node n = attribs.root;
			double max = gain(n.value, examples);
			Attribute max_attr = n.value;
			while (n.next != null) {
				double g = gain(n.value, examples);
				if (g > max) {
					max = g;
					max_attr = n.value;
				}
				n = n.next;
			}
			return max_attr;
		}
}