package amazon;

import java.util.Vector;
import java.util.HashMap;
import java.util.LinkedList;

public class FindMaxFreqResults {
	
	public HashMap<Integer, Double> find(Vector<Result> input) {
		
		HashMap<Integer, LinkedList<Integer>> ResultMap = new HashMap<Integer, LinkedList<Integer>>();
		HashMap<Integer, Double> Result = new HashMap<Integer, Double>();
		
		for (int i = 0; i < input.size(); i++) {
			if (!ResultMap.containsKey(input.get(i).StudentID)) {
				ResultMap.put(input.get(i).StudentID, new LinkedList<Integer>());
				
			} else {
				LinkedList<Integer> tmp = ResultMap.get(input.get(i).StudentID);
				// make sure the list of testscore is sorted decreasingly
				for (int j = 0; j < tmp.size(); j++) {
					if (tmp.get(j) <= input.get(i).testScore) {
						tmp.add(j, input.get(i).testScore);
						break;
					}
				}
				ResultMap.put(input.get(i).StudentID, tmp);
			}
		}
		
		for (Integer key: ResultMap.keySet()) {
			double finalscore = 0.0;
			int top5sum = 0;
			for (int i = 0; i < 5; i++) {
				top5sum += ResultMap.get(key).get(i);
			}
			Result.put(key, (double)(top5sum/5));
		}
		
		return Result;
	}
	
}