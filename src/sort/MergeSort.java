package sort;

public class MergeSort {

	int compare, swap;

	public MergeSort() {
		// TODO Auto-generated constructor stub
		compare = 0;
		swap = 0;
	}

	public int[] merge(int data[], int start, int mid, int end) {

		int sortedList[] = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			sortedList[i] = data[i]; // store array in temp file for reference
		}
		int i = start;
		int j = mid + 1;
		int z = start;

		while (i <= mid && j <= end) {
			compare++;
			// swap++;

			if (sortedList[i] <= sortedList[j]) {
				data[z] = sortedList[i];
				i++;
			} else {
				data[z] = sortedList[j];
				j++;
				swap++;
			}
			z++;
		}
		if (i <= mid) {
			for (int k = z; k <= end; k++) {
				data[k] = sortedList[i]; // If left array is not traveresed
											// completely
				i++;
			}
		} else if (j <= end) {
			for (int k = z; k <= end; k++) {
				data[k] = sortedList[j]; // If right array is not traveresed
											// fully
				j++;
			}
		}
		return data;

	}

	public int[] mergeSort(int data[], int start, int end) {
		int mid;

		if (start < end) {
			mid = ((start + end) / 2);
			data = mergeSort(data, start, mid); // mergesort on Left part of
												// array
			data = mergeSort(data, mid + 1, end); // mergesort on Right part of
													// array
			data = merge(data, start, mid, end);
		}
		return data;
	}

	public void printAns() {
		System.out.println("Number of comparisons made by insertion sort: "
				+ compare);
		System.out.println("Number of swaps made by insertion sort: " + swap);
	}
}
