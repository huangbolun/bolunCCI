package arrays_and_strings;

import java.util.ArrayList;

/**
 * MicroSoft on campus interview@TAMU
 * given a Task class 
 * @author Bolun
 *
 */
public class SortTask {
	
	/* my solution in the interview: dumped! */
	public ArrayList<Task> sort(ArrayList<Task> in) {
		
		if (in == null) return null;
		if (in.size() == 1) return in;
		
		int flag = 1;
		
		while (flag == 1) {
			flag = 0;
			for (int i = in.size() - 1; i >= 0; i--)
			{
				for (int j = i - 1; j >= 0; j--)
				{
					if (in.get(i).out == in.get(j).in1 || in.get(i).out == in.get(j).in2)
					{
						Task tmp = in.get(j);
						in.set(j, in.get(i));
						in.set(i, tmp);
						flag = 1;
					}
				}
			}
		}
		return in;
	}
	
	public String toStringTaskArray(ArrayList<Task> taskarray) {
		StringBuilder str = new StringBuilder();
		str.append("{");
		for (int i = 0; i < taskarray.size(); i++)
		{
			if (i != taskarray.size() - 1)
				str.append(taskarray.get(i).toString()+", ");
			else
				str.append(taskarray.get(i).toString());
		}
		str.append("}");
		return str.toString();
	}
	
	/* prad's solution */
	
}