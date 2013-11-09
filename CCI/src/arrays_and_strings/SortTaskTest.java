package arrays_and_strings;

import java.util.Arrays;
import java.util.ArrayList;

public class SortTaskTest {
	
	public String toStringTaskArray(Task[] taskarray) {
		StringBuilder str = new StringBuilder();
		str.append("{");
		for (int i = 0; i < taskarray.length; i++)
			if (i != taskarray.length - 1)
				str.append(taskarray[i].toString()+", ");
			else
				str.append(taskarray[i].toString());
		str.append("}");
		return str.toString();
	}
	
	public static void main(String[] args) {
		
		Task[] testarray = new Task[5];
		testarray[0] = new Task(1,2,3);
		testarray[1] = new Task(3,4,5);
		testarray[2] = new Task(2,6,4);
		testarray[3] = new Task(5,4,7);
		testarray[4] = new Task(9,8,2);
		
		SortTaskTest stt = new SortTaskTest();
		
		System.out.println(stt.toStringTaskArray(testarray));
		Arrays.sort(testarray);
		System.out.println(stt.toStringTaskArray(testarray));
		
		ArrayList<Task> testarray2 = new ArrayList<Task>();
		testarray2.add(new Task(1,2,3));
		testarray2.add(new Task(3,4,5));
		testarray2.add(new Task(2,6,4));
		testarray2.add(new Task(5,4,7));
		testarray2.add(new Task(9,8,2));
		
		
		SortTask st = new SortTask();
		System.out.println(st.toStringTaskArray(testarray2));
		st.sort(testarray2);
		System.out.println(st.toStringTaskArray(testarray2));
	}
}