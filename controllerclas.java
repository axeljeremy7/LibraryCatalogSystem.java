

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// I choose one array of item because I want to make identical output as the sample
// However, I also make the code using two arrays and that code is commented 
public class Controller implements IController {

	private ArrayList<LibraryItem> item = new ArrayList<>();
	private Scanner keyboard;

	// private ArrayList<LibraryItem> book = new ArrayList<>();
	// private ArrayList<LibraryItem> periodical = new ArrayList<>();

	/**
	 * A constructor called Controller that has one parameter which is an object
	 * of the class Scanner Because the program need to read the strings that
	 * user write as an input
	 */
	public Controller(Scanner k) {
		keyboard = k;
	}

	/**
	 * A method that displays the collection of library items to the screen with
	 * toString()
	 */
	@Override
	public void displayCollection() {
		
		 /* for (int i = 0; i < book.size(); i++) { System.out.print(((Book)
		  book.get(i)).toString()); }
		  
		  for (int k = 0; k < periodical.size(); k++) {
		  System.out.print(((Periodical) periodical.get(k)).toString()); }
		 
*/
		for (int i = 0; i < item.size(); i++) {
			if (item.get(i) instanceof Book) {
				System.out.println(((Book) item.get(i)).toString());
			}
			if (item.get(i) instanceof Periodical) {
				System.out.println(((Periodical) item.get(i)).toString());
			}
		}
	}

	/**
	 * A method that make requests for the call number from the user, using the
	 * findItem() method to check if that item exists in the library, and if it
	 * does calls the checkOut() and isCheckedOut() for that item and print the
	 * item that has been checked out. keep it save that the item has been
	 * checked out and the user cannot checkout again
	 */
	@Override
	public void checkoutMaterials() {
		System.out.print("Enter the call number: ");
		String callnumber = keyboard.nextLine();
		if (findItem(callnumber) != null) {
			if (findItem(callnumber) instanceof Periodical) {
				if (!findItem(callnumber).isCheckedOut()) {// Evaluating if is checked
					findItem(callnumber).checkOut();// Assigning  the checking
					// display with additional information such as check and dates
					System.out.println(((Periodical) findItem(callnumber)).toString());
				} else {// the user cannot checkout again
					System.out.println("Item not available\n");
						
				}
			} else if (findItem(callnumber) instanceof Book) {
				if (!findItem(callnumber).isCheckedOut()) {// Evaluating if is checked
					findItem(callnumber).checkOut();// Assigning  the checking
					//display with additional information such as check and dates
					System.out.println(((Book) findItem(callnumber)).toString());//display 
				} else {// the user cannot checkout again
					System.out.println("Item not available\n");
															 
				}
			}
		}
	}

	/**
	 * Searches in both the array of books and the array of periodicals with the
	 * callnumber received as a parameter.
	 * @param String callNum: The id of the item requested by the user
	 * @return The requested item, or 'null' if item does not exist.
	 */
	@Override
	public ILibrary findItem(String callNum) {
		for (int i = 0; i < item.size(); i++) {
			if (item.get(i) instanceof Book) {
				if (callNum.equals(((Book) item.get(i)).getCallNumber())) {
					return ((Book) item.get(i));
				}
			}
			if (item.get(i) instanceof Periodical) {
				if (callNum.equals(((Periodical) item.get(i)).getCallNumber())) {
					return ((Periodical) item.get(i));
				}
			}
		}
		/*
		  for (int i = 0; i < book.size(); i++) { if (callNum.equals(((Book)
		  book.get(i)).getCallNumber())) { return ((Book) book.get(i)); } }
	 
		  for (int k = 0; k < periodical.size(); k++) { if
		  (callNum.equals(((Periodical) periodical.get(k)).getCallNumber())) {
		  return ((Periodical) periodical.get(k)); } }*/
		 

		return null;// that call number does not exist
	}

	/**
	 * Displays the menu options to the user.
	 */
	@Override
	public void showMenu() {
		for (int i = 1; i <= 14; i++) {
			System.out.print("-");
		}
		System.out.print("Menu");
		for (int j = 1; j <= 14; j++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(" 1) Display collection \n 2) Check out materials  \n 3) Quit");
		for (int k = 1; k <= 32; k++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("Please choose an option: ");
	}

	/**
	 * A method that reads data from an input file 
	 * and stores the items in an array
	 * @param String fileName: The name of the input file.
	 * @throws IOException: Included in case input file is not found.
	 */
	@Override
	public void readInput(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner reader = new Scanner(file);
		ArrayList<LibraryItem> items = new ArrayList<>();
		LibraryItem temp = null;
		String tt;
		String[] t;
		while (reader.hasNext()) {
			tt = reader.nextLine();
			t = tt.split(",");
			if (t[0].equals("B")) {// save books
				temp = new Book(t[1], t[2], t[3], t[4]);
			} else if (t[0].equals("P")) {// save periodical
				temp = new Periodical(t[1], t[2], t[3], t[4], t[5]);
			}
			items.add(temp);
		}
		reader.close();
		item.addAll(items);

		/*
		  for (int i = 0; i < items.size(); i++) { if (items.get(i) instanceof
		  Book) { book.add((Book) items.get(i));
		  
		  } if (items.get(i) instanceof Periodical) {
		  periodical.add((Periodical) items.get(i));
		  
		  } }
		 */

	}

}
