

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book extends LibraryItem {
	private String title;
	private String author;
	private String genre;
	private String callnumber;
	private boolean checking = false;// boolean variable is false at the
										// beginning becuase the book is not
										// checked.
	private GregorianCalendar dateDue;
	private GregorianCalendar dateCheckOut;

	/**
	 * A constructor for book with the attributes title,
	 * author,genre,callnumber.
	 */
	public Book(String c, String t, String a, String g) {
		title = t;
		author = a;
		genre = g;
		callnumber = c;

	}

	
	/**
	 * A method to get callnumber
	 * @return String callnumber
	 */
	@Override
	public String getCallNumber() {

		return callnumber;
	}

	/**
	 * A method to assign the boolean checking true in order to be checked
	 * initialize the dateCheckOut GregorianCalendar object
	 */
	@Override
	public void checkOut() {
		this.checking = true;
		dateCheckOut = new GregorianCalendar();

	}

	/**
	 * A boolean method to verify the changes of the variable checking according
	 * to the changes of the variable checking , the method return a boolean
	 * @return boolean that is an answer if it is checked
	 */
	@Override
	public boolean isCheckedOut() {
		if (!this.checking) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * A method to return the dateCheckOut
	 * 
	 * @return dateCheckOut
	 */
	@Override
	public GregorianCalendar getDateCheckedOut() {
		return this.dateCheckOut;
	}

	/**
	 * A method to return the dateDue
	 * @return dateDue
	 */
	@Override
	public GregorianCalendar getDateDue() {
		dateDue = (GregorianCalendar) dateCheckOut.clone();
		dateDue.add(Calendar.DAY_OF_YEAR, 21);
		return this.dateDue;
	}

	/**
	 * A method to set the dateDue
	 */
	@Override
	public void setDateDue(GregorianCalendar dateDue) {
		this.dateDue = dateDue;
	}

	/**
	 * A method that generates a string with the details of the library item and
	 * returns a string with more details if the user check out a library item
	 * the string includes information that the item has been checked out the
	 * date it was checked out, and the due date for the item.
	 * 
	 * @return String : string with details
	 */
	@Override
	public String toString() {

		if (isCheckedOut()) {
			String unn = String.format(
					"Book Title: %s\nAuthor: %s\nGenre: %s\nCall Number: %s\n"
							+ "CheckOut: YES\nDate Out: %tD\nDate Due: %tD\n",
					title, author, genre, callnumber, dateCheckOut, getDateDue());
			return unn;
		} else {
			String unn = String.format("Book Title: %s\nAuthor: %s\nGenre: %s\nCall Number: %s\n" + "CheckOut: NO\n",
					title, author, genre, callnumber);
			return unn;
		}

	}

}
