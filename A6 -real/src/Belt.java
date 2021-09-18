

import java.util.Iterator;

public interface Belt {

	/* A getter for the size of the belt. */
	public int getSize();
	
	
	/* 	Returns the plate at the specified position on the belt 
	 *  or null if there is no Plate object there. */
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
	public Plate removePlateAtPosition(int position);

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException;
	
	public Iterator<Plate> iterator();
	
	public Iterator<Plate> iteratorFromPosition(int position);
}
