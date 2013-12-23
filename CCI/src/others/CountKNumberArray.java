package others;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * keep three pointer pos0, pos2 and current position
 * pos0 is initialized to be the first index not 0
 * pos2 is initialized to be the last index not 2
 * traversal index from pos0 to pos2, if 0 swap with pos0
 * and move pos0, if 2 swap with pos2 and move pos2
 * @author Bolun
 *
 */
public class CountKNumberArray {
	
	public HashMap<Integer, Integer> solution(ArrayList<Integer> input) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
		int pos0 = 0;
		int pos2 = input.size() - 1;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) != 0) {
				pos0 = i;
				break;
			}
		}
		for (int i = input.size() - 1; i >= 0; i--) {
			if (input.get(i) != 2) {
				pos2 = i;
				break;
			}
		}
		for (int i = pos0 + 1; i <= pos0; i++) {
			if (input.get(i) == 0) {
				int sw = input.get(i);
				input.set(i, input.get(pos0));
				input.set(pos0, sw);
				pos0 += 1;
				while(pos0 == 0)
					pos0 += 1;
			} else if (input.get(i) == 2) {
				int sw = input.get(i);
				input.set(i, input.get(pos2));
				input.set(pos2, sw);
				pos2 -= 1;
				while (pos2 == 2)
					pos2 -= 1;
			} else {
				// nothing
			}
		}
		result.put(0, pos0+1);
		result.put(1, pos2-pos0);
		result.put(2, input.size()-pos2-1);
		
		return result;
	}
}