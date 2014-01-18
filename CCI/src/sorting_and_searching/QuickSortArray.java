package sorting_and_searching;

import java.util.Arrays;
/**
 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 * @author Bolun
 *
 */
public class QuickSortArray {
	
	public void QuickSort(int[] array) {
		if (array == null || array.length == 0 || array.length == 1) return;
		QuickSortCore(array, 0, array.length-1);
		return;
	}
	
	public void QuickSortCore(int[] array, int begin, int end) {
		int p1 = begin;
		int p2 = end;
		int pivot = array[begin+(end-begin)/2]; // mid point
		while (p1 <= p2) {
			while (array[p1] < pivot) p1++;
			while (array[p2] > pivot) p2--;
			if (p1 <= p2) {
				int tmp = array[p1];
				array[p1] = array[p2];
				array[p2] = tmp;
				p1++;
				p2--;
			}
		}
		if (begin < p2) {
			QuickSortCore(array, begin, p2);
		}
		if (end > p1) {
			QuickSortCore(array, p1, end);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {2,55,17,1,11,11,21,10,1,63,42,21,8,34,51,10};
		QuickSortArray q = new QuickSortArray();
		System.out.println(Arrays.toString(array));
		q.QuickSort(array);
		System.out.println(Arrays.toString(array));
	}
}