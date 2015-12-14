import java.io.FileNotFoundException;
import java.util.Scanner;

import name.Name;

public class Project2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input, command;
		Name n1 = new Name();
		try {
			Scanner sc = new Scanner(System.in);
			do {

				System.out.println("Enter the command. "); // Take input from
															// user
				command = sc.next();
				if (command.compareTo("Start") == 0) // If command is Start call
														// Start function.
				{
					input = sc.next();
					n1.start(input);
				} else if (command.compareTo("InsertionSort") == 0) // If
																	// command
																	// is
																	// InsertionSort
																	// call
																	// InsertionSort
																	// function.
				{
					n1.insertionSort();
					n1.reinitialise(n1.name); // reinitialise the array
				} else if (command.compareTo("MergeSort") == 0) // If command is
																// InsertionSort
																// call
																// InsertionSort
																// function.
				{
					n1.mergeSort();
					n1.reinitialise(n1.name); // reinitialise the array
				} else if (command.compareTo("Select") == 0) // If command is
																// Select call
																// Select
																// function.
				{
					input = sc.next();
					int temp = n1.select(input);
				} else if (command.compareTo("Average") == 0) // If command is
																// Average call
																// Average
																// function.
				{
					n1.average();
				} else if (command.compareTo("End") == 0) // If command is End
															// call End
															// function.
				{
					input = sc.next();
					n1.end(input);
				} else if (command.compareTo("Exit") == 0) // If command is Exit
															// call Exit
															// function.
				{
					n1.exit();
				} else
					System.out.println("Invalid command.");
			} while (command.compareTo("Exit") != 0 && sc.hasNext());
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
