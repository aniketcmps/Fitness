package sort;

public class InsertionSort {

	int compare, swap;

	public InsertionSort() {
		// TODO Auto-generated constructor stub
		compare = 0;
		swap = 0;
	}

	public int[] insertionSort(int data[]) {
		int key;

		for (int i = 1; i < data.length; i++) // Insertion Sort
		{
			key = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] > key) {
				compare++;

				data[j + 1] = data[j];
				j = j - 1;
				swap++;// increment swap when we place the element in proper
						// position
			}
			compare++; // increment compare when data[j]>key is false
			data[j + 1] = key;
		}

		System.out.println("Number of comparisons made by insertion sort: "
				+ compare);
		System.out.println("Number of swaps made by insertion sort: " + swap);

		return data;
	}

}
