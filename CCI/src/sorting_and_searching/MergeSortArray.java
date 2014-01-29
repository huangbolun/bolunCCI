package sorting_and_searching;

import java.util.Arrays;

public class MergeSortArray {
	
	public int[] MergeSort (int[] array) {
		if (array.length > 1) {
			int leftLen = array.length/2;
			int rightLen = array.length - leftLen;
			int[] leftArray = new int[leftLen];
			int[] rightArray = new int[rightLen];
			for (int i = 0; i < leftLen; i++) {
				leftArray[i] = array[i];
			}
			for (int i = 0; i < rightLen; i++) {
				rightArray[i] = array[leftLen+i];
			}
			leftArray = MergeSort(leftArray);
			rightArray = MergeSort(rightArray);
			// Merge
			int i = 0;
			int j = 0;
			int k = 0;
			while (j < leftLen && k < rightLen) {
				if (leftArray[j] < rightArray[k]) {
					array[i] = leftArray[j];
					i++;
					j++;
				} else if (leftArray[j] >= rightArray[k]) {
					array[i] = rightArray[k];
					i++;
					k++;
				}
			}
			if (j == leftLen) { // append rightArray to the end
				while (k < rightLen) {
					array[i] = rightArray[k];
					i++;
					k++;
				}
			}
			if (k == rightLen) { // append leftArray to the end
				while (j < leftLen) {
					array[i] = leftArray[j];
					j++;
					i++;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		String s = new String("123456");
		System.out.println(s.substring(6));
		int[] array = {2,55,17,1,11,11,21,10,1,63,42,21,8,34,51,10};
		MergeSortArray m = new MergeSortArray();
		System.out.println(Arrays.toString(array));
		m.MergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}