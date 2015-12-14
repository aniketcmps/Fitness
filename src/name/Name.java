package name;

import java.io.BufferedReader;
import java.io.FileReader;

import sort.InsertionSort;
import sort.MergeSort;

public class Name {

	int fitnessData[];
	int size; // will store the size of array
	int sort; // to check if array is sorted or not
	public String name;
	int endname;
	int sortedData[]; // store sorted array

	public Name() {
		// TODO Auto-generated constructor stub
		size = 0;
		sort = 0;
		name = "";
		endname = 1;
	}

	public void reinitialise(String input) throws Exception {
		sort = 1;

		sortedData = new int[size];
		for (int i = 0; i < size; i++) {
			sortedData[i] = fitnessData[i]; // Store the sorted data
		}

		input = input.concat(".txt"); // append ".txt" to define the
		// extension of file to be read

		FileReader inputFile = new FileReader(input);
		BufferedReader bufferReader = new BufferedReader(inputFile);
		String line;

		line = bufferReader.readLine();
		if (line != null) {
			endname = 0;
			size = Integer.parseInt(line); // read total no of inputs
			fitnessData = new int[size];// initialize array with the size
		}
		for (int i = 0; i < size; i++) {
			line = bufferReader.readLine();
			if (line != null) {
				fitnessData[i] = Integer.parseInt(line);// store input
				// values in the
				// array
			}
		}
		bufferReader.close();

	}

	public void start(String input) throws Exception {
		if (endname == 0) {
			System.out.println("Invalid Start "); // Give error for consequtive
													// start
		} else if (endname == 1) {
			name = input;
			input = input.concat(".txt"); // append ".txt" to define the
											// extension of file to be read

			FileReader inputFile = new FileReader(input);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			String line;

			System.out.println("Processing fitness data of: " + name);
			line = bufferReader.readLine();
			if (line != null) {
				endname = 0;
				size = Integer.parseInt(line); // read total no of inputs
				fitnessData = new int[size];// initialize array with the size
			}
			for (int i = 0; i < size; i++) {
				line = bufferReader.readLine();
				if (line != null) {
					fitnessData[i] = Integer.parseInt(line);// store input
															// values in the
															// array
				}
			}
			bufferReader.close();

		} else
			System.out.println("Unable to open file. "); // gives error if file
															// not
															// found

	}

	public void end(String input) {
		if (input.compareTo(name) == 0) {
			System.out.println("End of processing fitness data for: " + name);
			size = 0; // deallocating memory
			sort = 0;
			// fitnessData = null;
			// sortedData = null;
			name = "";
			endname = 1;
		} else {
			System.out.println("Invalid End. "); // if user tries to end
													// different name
		}
	}

	public void insertionSort() {
		InsertionSort is = new InsertionSort();
		fitnessData = is.insertionSort(fitnessData);
	}

	public void mergeSort() {
		MergeSort is = new MergeSort();
		fitnessData = is.mergeSort(fitnessData, 0, fitnessData.length - 1);
		is.printAns();
	}

	public int select(String input) {
		if (sort == 0) // check if array is sorted
		{
			System.out.println("Unable to select from an unsorted array. "); // error
																				// if
																				// array
																				// is
																				// not
																				// sorted
		} else {
			int i;
			if (input.compareTo("min") == 0) {
				i = 0; // smallest value i.e. first data item
			} else if (input.compareTo("max") == 0) {
				i = size - 1; // largest value i.e. last data item
			} else if (input.compareTo("median") == 0) {
				if (size % 2 == 0) // if the array contains even numbers
				{
					i = size / 2;
					float median = (sortedData[i] + sortedData[i - 1]);

					System.out.println("Selecting item: " + median / 2); // median
																			// is
																			// mean
																			// (average)
																			// of
																			// the
																			// two
																			// middlemost
																			// numbers
					return 0;
				} else
					i = size / 2; // if the array contains odd number
			} else {
				i = Integer.parseInt(input);
				if (i < 1 || i > size) // check if input is greater than or less
										// than size of array
				{
					System.out.println("Invalid input."); // prints error if
															// input greater
															// than size of
															// array
					return 0;
				}
				i--;
				// cout<<i;
			}

			System.out.println("Selecting item: " + sortedData[i]);
			return 0;
		}
		return 1;
	}

	public void average() {
		float avg = 0;
		for (int i = 0; i < size; i++) {
			avg += fitnessData[i]; // sum of all elements in array
		}
		avg = avg / size; // divide by the total number of elements to get
							// average

		System.out.println("Average number of steps: " + avg);
	}

	public void exit() {
		System.out.println("Program terminating.");
	}

}
