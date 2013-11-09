package arrays_and_strings;

import java.util.HashMap;

/**
 * MicroSoft interview on campus
 * @author Bolun
 *
 */
public class IsAnagram {
	
	public boolean isAnagram (String a, String b) {
		
		if (a == null || b == null) return false;
		
		if (a.length() != b.length()) return false;
		
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		HashMap<String, Integer> mapb = new HashMap<String, Integer>();
		
		for (int i = 0; i < a.length(); i++)
		{
			if (mapa.containsKey(String.valueOf(a.charAt(i)))) {
				int freq = mapa.get(String.valueOf(a.charAt(i))) + 1;
				mapa.put(String.valueOf(a.charAt(i)), freq);
			} else {
				mapa.put(String.valueOf(a.charAt(i)), 1);
			}
		}
		
		for (int i = 0; i < b.length(); i++)
		{
			if (mapb.containsKey(String.valueOf(b.charAt(i))))
			{
				int freq = mapb.get(String.valueOf(b.charAt(i))) + 1;
				mapb.put(String.valueOf(b.charAt(i)), freq);
			} else {
				mapb.put(String.valueOf(b.charAt(i)), 1);
			}
		}
		
		if (mapa.size() != mapb.size()) return false;
		
		for (String key : mapa.keySet())
		{
			if (!mapb.containsKey(key)) return false;
			else {
				if (mapa.get(key) != mapb.get(key))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String a = new String("1234567444812190");
		String b = new String("1324456784904121");
		
		IsAnagram IA = new IsAnagram();
		System.out.println(IA.isAnagram(a, b));
	}
	
}