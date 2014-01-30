package microsoftCodeChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextQueryMatching {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C://Users//Bolun//Desktop//jobhunting//microsoft//CodeCompetitionForStudents//TextQueryMatch//SampleInput.txt"));
		//BufferedReader br = new BufferedReader(new FileReader("C://Users//Bolun//Downloads//ScoringInputs//TextQueryMatch//ActualInput.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C://Users//Bolun//Desktop//jobhunting//microsoft//CodeCompetitionForStudents//SampleOutputs//TextQueryMatch1.txt"));
		
		int num = Integer.parseInt(br.readLine());
		String[] queries = new String[num];
		String[] patterns = new String[num];
		int i = 0;
		while (i < num) {
			queries[i] = br.readLine().toLowerCase();
			patterns[i] = br.readLine().toLowerCase();
			i += 1;
		}
		br.close();
		bw.append(num+"\r\n");
		for (int k = 0; k < queries.length; k++) {
			bw.append(String.valueOf((check(queries[k], patterns[k])))+"\r\n"+queries[k]+"\r\n"+patterns[k]+"\r\n");
		}
		bw.close();
	}
	
	public static boolean check(String query, String pattern) {
		String[] queries = query.split(" "); // split
		String[] patterns = pattern.split(" "); // split
		String wholePattern = new String("");
		for (int i = 0; i < patterns.length; i++) {
			wholePattern += patterns[i];
		}
		System.out.println(query+"\r\n"+pattern+"\r\n");
		System.out.println(wholePattern.contains(query));
		if (wholePattern.contains(query)) return true;
		int i = 0;
		int j = 0;
		while (i < queries.length) {
			int check = 0;
			while (j < patterns.length) {
				if (patterns[j].length() >= queries[i].length() && (patterns[j].substring(0, queries[i].length())).equals(queries[i])) {
					j += 1;
					check = 1; // matched
					break;
				} else { // not matched
					j += 1;
				}
			}
			if (check == 1)
				i += 1;
			if (j == patterns.length) break;
		}
		if (i == queries.length) return true;
		else return false;
	}
	
}