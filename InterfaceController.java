

import java.io.IOException;

public interface IController {
	
	/**
     * Displays the collection of library items to the screen
     */
public void displayCollection();
/**
* Requests for the call number from the user, uses the findItem()
* method to check if that item exists in the library, and if it does * calls the checkOut() method for that item and prints out the item * that has been checked out.
*/
public void checkoutMaterials();
/**
* Searches in both the array of books and the array of periodicals * for the book with the call number received as a parameter.
* @param callNum The call number of the item requested by the user * @return The requested item, or 'null' if item does not exist. */
public ILibrary findItem(String callNum);
    /**
     * Displays the menu options to the user.
     */
public void showMenu();
/**
* Reads data from the input file and stores the items in the
* appropriate array.
* @param fileName The name of the input file.
* @throws IOException Included in case input file is not found. */
public void readInput(String fileName) throws IOException;

}
