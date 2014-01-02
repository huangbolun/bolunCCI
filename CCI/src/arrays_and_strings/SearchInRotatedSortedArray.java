package arrays_and_strings;
public class SearchInRotatedSortedArray {

	public void search (int[] array, int num) {
		int length = array.length;
		int[] left = new int[length/2+1];
		int[] right = new int[length/2+1];
		
		java.lang.System.arraycopy(array, 0, left, 0, length/2);
		java.lang.System.arraycopy(array, length/2+1, right, 0, length/2);
		
		if (array.length == 1 && array[0] == num)
		{
			System.out.println("IN");
		} else if (left[length/2-1] > left[0] && num > left[0] && num < left[length/2-1]) {
			this.search(left, num);
		} else if (right[length/2-1] > right[0] && num > right[0] && num < right[length/2-1]) {
			this.search(right, num);
		} else if (left[length/2-1] < left[0]) {
			this.search(left, num);
		} else if (right[length/2-1] < right[0]) {
			this.search(left, num);
		}
	}

	public static void main(String[] args) {
		int[] a = {6,7,8,9,1,2,3,5};
		SearchInRotatedSortedArray mySIRSA = new SearchInRotatedSortedArray();
		mySIRSA.search(a, 2);
		java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<Integer>();
		String s = new String("");
		
	}
}