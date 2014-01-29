package google;

import java.util.ArrayList;
import java.util.HashMap;

public class RotN {
	public ArrayList<ArrayList<String>> rot(ArrayList<String> input) {
		if (input == null || input.size() == 0) return null;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < input.size(); i++) {
			String key = shift(input.get(i));
			if (map.containsKey(key)) {
				ArrayList<String> val = map.get(key);
				val.add(input.get(i));
				map.put(key, val);
			} else {
				map.put(key, new ArrayList<String>());
				ArrayList<String> val = map.get(key);
				val.add(input.get(i));
				map.put(key, val);
			}
		}
		/*ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}*/
		return (ArrayList<ArrayList<String>>)map.values();
	}

	public String shift(String s) {
		String sn = new String("");
		int diff = s.charAt(0)-'a';
	for (int i = 0; i < s.length(); i++) {
			sn += String.valueOf((char)(s.charAt(i)-diff));
	}
	return sn;
	}
}
