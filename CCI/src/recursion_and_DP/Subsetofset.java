package recursion_and_DP;

import java.util.ArrayList;

/**
 * find all subset of a set
 * no better than 2^n in time and space complexity
 * @author Bolun
 *
 */
public class Subsetofset {
	
	public ArrayList<ArrayList<Integer>>findSubSets(ArrayList<Integer> inputset) {
		ArrayList<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
		int index = 0;
		if (inputset.isEmpty())
			return resultSet;
		else
			return findSubSet_core(resultSet, index, inputset);
	}
	
	public ArrayList<ArrayList<Integer>> findSubSet_core(ArrayList<ArrayList<Integer>> result, int index, ArrayList<Integer> inputset) {
		if (index == inputset.size()) /* the end of the set */
			return result;
		else {
			if (index == 0) {
				ArrayList<ArrayList<Integer>> moreset = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> s = new ArrayList<Integer>();
				s.add(inputset.get(index));
				moreset.add(new ArrayList<Integer>());
				moreset.add(s);
				result.addAll(moreset);
				return findSubSet_core(result, index+1, inputset);
			} else {
				ArrayList<ArrayList<Integer>> moreset = new ArrayList<ArrayList<Integer>>();
				for (int i = 0; i < result.size(); i++) {
					ArrayList<Integer> s = new ArrayList<Integer>();
					s.addAll(result.get(i));
					s.add(inputset.get(index));
					moreset.add(s);
				}
				result.addAll(moreset);
				return findSubSet_core(result, index+1, inputset);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(9);
		input.add(10);
		input.add(4);
		input.add(3);
		Subsetofset sos = new Subsetofset();
		System.out.println(sos.findSubSets(input));
		System.out.println(sos.findSubSets(input).size());
	}
}