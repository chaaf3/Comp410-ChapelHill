package a7;

import java.util.Iterator;

import comp401sushi.Plate;



public interface Belt {

	/* A getter for the size of the belt. */
	public int getSize();
	
	
	/* 	Returns the plate at the specified position on the belt 
	 *  or null if there is no Plate object there. 
	 *  The plate (if any) remains on the belt (i.e., this
	 *  method does not removed the plate from the belt).
	 *  
	 */
	
	public Plate getPlateAtPosition(int position);

	
	/* 	Sets a plate at the specified position on the belt. If the provided plate is null, 
	 *  throws an IllegalArgumentException. 
	 *  If there is already a plate at that position, throws a BeltPlateException.
	 */
	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException;
		
	
	/* 	Clears the specified position on the belt to null. */
	 public void clearPlateAtPosition(int position);

	 
	/* Removes the plate at the specified position off the belt and returns it. 
	 * If there is no plate at the specified position, throws a java.util.NoSuchElementException. 
	 * You should be able to write this method using getPlateAtPosition and clearPlateAtPosition described above.
	 */
	default public Plate removePlateAtPosition(int position) {
		Plate result = getPlateAtPosition(position);
		if (result == null) {
			throw new java.util.NoSuchElementException("No plate at position");
		}
		clearPlateAtPosition(position);
		return result;
	}
	
	/* Sets plate on belt at position if possible. If not possible, tries at 
	 * next higher position. Continues in this way until either plate is placed
	 * somewhere or belt is found to be completely full. In the second case,
	 * throws a BeltFullException.
	 */
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException;
	
	/* Rotates plates on the belt. 
	 * Any plate that was at position i will end up at
	 * position i+1 after rotate().
	 */	
	public void rotate();
	
	void addBeltObserver(BeltObserver o);
	void removeBeltObserver(BeltObserver o);
	void notifyObservers(PlateEvent e);
	public void registerCustomerAtPosition(Customer c, int position);
	public Customer unregisterCustomerAtPosition(int position);
	public void notificationMethod(Customer c, Plate p, int position);
	
}
