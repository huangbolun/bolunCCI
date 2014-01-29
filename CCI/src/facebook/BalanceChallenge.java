package facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/*
Please write complete compilable code.
Your class should be named Solution
Read input from standard input (STDIN) and print output to standard output(STDOUT).
For more details, please check https://www.interviewstreet.com/recruit/challenges/faq/view#stdio
*/
class Balance {
    int weight = 10; // pound
    int leftextra = 0; // extra-weight to be added on left
    int rightextra = 0; // extra-weight to be added on right
    int leftWeight = 0;
    int rightWeight = 0;
    int flag = 0; // 1 indicates it is balanced, 0 indicates it is not yet
    ArrayList<Integer> leftBalance;
    ArrayList<Integer> rightBalance;
    ArrayList<Balance> leftChilds;
    ArrayList<Balance> rightChilds;
    
    Balance(int leftW, int rightW) {
        leftWeight = leftW;
        rightWeight = rightW;
        leftBalance = new ArrayList<Integer>();
        rightBalance = new ArrayList<Integer>();
        leftChilds = new ArrayList<Balance>();
        rightChilds = new ArrayList<Balance>();
        if (leftW > rightW) rightextra += Math.abs(leftW-rightW); // add extra weights to balance
        else leftextra += Math.abs(leftW-rightW); // add extra weights to balance
    }
    // something is wrong for this function, need future modification and debug
    int getWeight() {
    	if (flag == 0) {
        	int total = 0;
        	int leftWTotal = 0;
        	int rightWTotal = 0;
        	for (Balance b : leftChilds) {
        		leftWTotal += b.getWeight();
        	}
        	for (Balance b : rightChilds) {
        		rightWTotal += b.getWeight();
        	}
        	if (leftWTotal > rightWTotal) rightextra += Math.abs(leftWTotal-rightWTotal); // add extra weights
        	else leftextra += Math.abs(leftWTotal-rightWTotal); // add extra weights
        	total = weight+leftextra+rightextra+leftWTotal+rightWTotal; // the total balanced weight
        	flag = 1; // reset the flag!!
        	return total;
    	} else {
    		int leftWTotal = 0;
        	int rightWTotal = 0;
        	for (Balance b : leftChilds) {
        		leftWTotal += b.getWeight();
        	}
        	for (Balance b : rightChilds) {
        		rightWTotal += b.getWeight();
        	}
    		return weight+leftextra+rightextra+leftWTotal+rightWTotal; // the total balanced weight
    	}
    }
    
    ArrayList<Integer> getLeftBalance() {
        return leftBalance;
    }
    
    ArrayList<Integer> getRightBalance() {
        return rightBalance;
    }
    
    ArrayList<Balance> getLeftChilds() {
        return leftChilds;
    }
    
    ArrayList<Balance> getRightChilds() {
        return rightChilds;
    }
    
    void addToLeftBalance(int a) {
        leftBalance.add(a);
    }
    
    void addToRightBalance(int a) {
        rightBalance.add(a);
    }
    
    void addToLeftChild(Balance b) {
        leftChilds.add(b);
    }
    
    void addToRightChild(Balance b) {
        rightChilds.add(b);
    }
}

public class BalanceChallenge {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Balance> balanceMap = new HashMap<Integer, Balance>(); // map to cache balance
        int numBalance = Integer.parseInt(br.readLine());
        for (int i = 0; i < numBalance; i++) {
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");
            Balance b = new Balance(Integer.parseInt(line1[0]), Integer.parseInt(line2[0]));
            for (int j = 1; j < line1.length; j++) {
                b.addToLeftBalance(Integer.parseInt(line1[j]));
            }
            for (int k = 1; k < line2.length; k++) {
                b.addToRightBalance(Integer.parseInt(line2[k]));
            }
            balanceMap.put(i, b); // add to map
        }
        // construct the structure
        for (Integer i : balanceMap.keySet()) {
            Balance b = balanceMap.get(i);
            ArrayList<Integer> leftBs = b.getLeftBalance();
            for (Integer j : leftBs) {
                b.addToLeftChild(balanceMap.get(j));
            }
            ArrayList<Integer> rightBs = b.getRightBalance();
            for (Integer j : rightBs) {
                b.addToRightChild(balanceMap.get(j));
            }
        }
        
        for (Integer i : balanceMap.keySet()) {
        	balanceMap.get(i).getWeight(); // get weight for every balance
        }
        for (int i = 0; i < numBalance; i++) {
        	System.out.println(i+": "+balanceMap.get(i).leftextra+" "+balanceMap.get(i).rightextra);
        }
    }
    
}