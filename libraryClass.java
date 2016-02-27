this should be abstract class but i did this to to learn instanceof



import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;

public class LibraryItem implements ILibrary {

	private GregorianCalendar dateDue;
	private GregorianCalendar dateCheckOut;
	private String callNumber;
	private boolean checking = false;

	/**
	 * Generates a string with the details of the library item whose call number
	 * has been input by the user  and returns that string.
	 * If the user wants to check out the library item, the string to be
	 * returned also includes information that the item has been checked out,
	 * the date it was checked out, and the due date for the item.
	 * @return String with information
	 */
	// this is going to be override by the subclasses methods
	public String toString() {
		return null;

	}

	/**
	 * Sets the boolean value checkedOut to true, and * initializes the
	 * dateChecked out attribute (a GregorianCalendar object).
	 */
	// this is going to be override by the subclasses methods
	@Override
	public void checkOut() {
		this.checking = true;
		dateCheckOut = new GregorianCalendar();

	}

	/**
	 * Returns the call number of this object. * @return the callNumber
	 */

	@Override
	public String getCallNumber() {
		return null;
	}

	/**
	 * Returns true or false depending on if this item has been checked out.
	 * * @return the boolean value for isCheckedOut
	 */
	// this is going to be override by the subclasses methods
	@Override
	public boolean isCheckedOut() {
		if (!this.checking) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Returns the date this item was checked out. * @return the dateCheckedOut
	 */
	// this is going to be override by the subclasses methods
	@Override
	public GregorianCalendar getDateCheckedOut() {
		return dateCheckOut;

	}

	/**
	 * Returns the date this item is due to be returned. * @return the dateDue
	 */
   // this is going to be override by the subclasses methods
	@Override
	public GregorianCalendar getDateDue() {
		dateDue = (GregorianCalendar) dateCheckOut.clone();
		dateDue.add(Calendar.DAY_OF_YEAR, 50);// this is sample
		return this.dateDue;
	}

	/**
	 * Sets the dateDue to the parameter received. * @param dateDue the dateDue
	 * to set
	 */
	@Override
	public void setDateDue(GregorianCalendar dateDue) {
		this.dateDue = dateDue;

	}

}
