package arrays_and_strings;

import java.util.Comparator;

public class Task implements Comparable<Task>{

	public int in1;
	public int in2;
	public int out;
	
	public Task(int in1, int in2, int out) {
		this.in1 = in1;
		this.in2 = in2;
		this.out = out;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("(in1: "+in1+",in2: "+in2+",out: "+out+")");
		return str.toString();
	}
	
	@Override
	public int compareTo(Task arg0) {
		// TODO Auto-generated method stub
		if (this.out == arg0.in1 || this.out == arg0.in2)
			return -1;
		return 0;
	}
}