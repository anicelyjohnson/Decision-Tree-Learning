/*
Programming Assignment 3: Decision Trees
Alexander Johnson and Daniel Chou




raining weekend
v       v       classifaction
*/

import java.util.*;

public class DecisionTree {

	public String value;
	public boolean classifaction;
	public String[] branch;
	public DecisionTree[] children;

	public DecisionTree(Attribute a) {
		value = a.name;
		branch = null;
		children = null;
	}
	public DecisionTree(boolean b) {
		classifaction = b;
		value = null;
		branch = null;
		children = null;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	}



	public DecisionTree decision_tree_learning(Example[] examples, List attribs, boolean def) {
		boolean all_examples_have_same_classification = false;
		int yes_counter;
		int no_counter;
		boolean majority_value;

		for (int i = 1; i < examples.length; i++) {
			if (examples[i].classification) {
				yes_counter++;
			} else {
				no_counter++;
			}
		}
		if (yes_counter == 0 || no_counter == 0) {
			all_examples_have_same_classification = true;
		}
		if (yes_counter >= no_counter) {
			majority_value = true;
		} else {
			majority_value = false;
		}


		if (examples[0] == null) {
			DecisionTree d = new DecisionTree(def);//leaf node
			return d;
		} else if (all_examples_have_same_classification) {
			return new DecisionTree(examples[0].classification);			//as a node
		} else if (attribs.root == null) {
			return new DecisionTree(majority_value);
		} else {

			Attribute best = choose_attribute(attribs, examples);
			DecisionTree tree = new DecisionTree(best);
			for (String val : best.possible_values) {

				//take each example thats value of "best" asttr is the same as val
				Example[] next = new Example[10];
				int i = 0;
				int j = 0;
				for (Example e : examples) {
					if (e.attr_vals.get(best.name).equals(val)) {
						next[i] = e;
					i++;
					}
					
				}
				attribs.remove(best);
				DecisionTree subtree = decision_tree_learning(next, attribs, majority_value);
				tree.branch[j] = best.name;
				tree.children[j] = subtree;
				j++;
			}
			return tree;
		}
	}
}








