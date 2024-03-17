import java.util.Arrays;

/**
 * aOrderedList creates multiple methods to create and organize an ordered list of car's make, year, and price, from the files taken in.
 * 
 * CSC 1351 Programming Project No 1
 * Section 2
 * 
 * @author Jonathan Breaux
 * @since 03/17/24
 * 
 */

public class aOrderedList {

	final int SIZEINCREMENTS = 20; //The size of increments for increasing the ordered list
	private Comparable<Car>[] oList; //The Ordered List
	private int listSize; //The size of the ordered list
	private int numObjects; //The number of objects in the ordered list
	private int curr; //The index of current element accessed via the iterator methods
	
	/*
	 * Constructor for aOrderedList class
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Car[SIZEINCREMENTS];
		this.curr = -1;
	}
	
	/*
	 * Adds a new object to the ordered list
	 * 
	 * @param newCar - the object to be added
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public void add(Comparable<Car> newCar) {
		
		 if (numObjects == listSize) {
	            listSize += SIZEINCREMENTS;
	            oList = Arrays.copyOf(oList, listSize);
	        }
		 
	        int index = 0; //the index of the new ordered list
	        while (index < numObjects && newCar.compareTo((Car) oList[index]) > 0) {
	            index++;
	        }
	        for (int i = numObjects - 1; i>= index; i--) {
	        	oList[i + 1] = oList[i];
	        }
	        
	        oList[index] = newCar;
	        numObjects++;
	    }
	
	/*
	 * Overrides the toString for aOrderedList class
	 * 
	 * @return - The ordered list in string format
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	@Override
	public String toString() {
			StringBuilder strgBldr = new StringBuilder(); //A string builder to build the toString
			strgBldr.append("[");
			for (int i = 0; i < numObjects; i++) {
				strgBldr.append(oList[i]);
				if (i < numObjects - 1) {
					strgBldr.append(", ");
				}
			}
			strgBldr.append("]");
			return strgBldr.toString();
		}
	
	/*
	 * Gives the size of the ordered list
	 * 
	 * @return - the size of the ordered list
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public int size() {
		return numObjects;
	}
	
	/*
	 * Gives the object at a certain index
	 * 
	 * @param index - the index we are searching to
	 * @throws - IndexOutOfBoundsException if the index is out of bounds
	 * @return - the object
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public Comparable<Car> get(int index) {
		if (index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException("Index out of bounds - Index: " + index + "Size: " + numObjects);
		}
		return oList[index];
	}
	
	/*
	 * Checks if the ordered list is empty
	 * 
	 * @return - true if the ordered list is empty, false if it is not
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public boolean isEmpty() {
		return numObjects == 0;
	}
	
	/*
	 * Removes a certain object from the ordered list
	 * 
	 * @param index - the index of the object to be removed
	 * @throws - IndexOutOfBoundsException if the index is out of bounds
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public void remove(int index) {
		if (index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException("Index out of bounds - Index: " + index + ", Size: " + numObjects);
		}
		for (int i = index; i < numObjects - 1; i++) {
			oList[i] = oList[i+1];
		}
		oList[numObjects - 1] = null;
		numObjects--;
	}
	
	/*
	 * Resets the iterator variable back to the beginning
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public void reset() {
		curr = -1;
	}
	
	/*
	 * Iterates through one iteration of the ordered list
	 * 
	 * @return - the next object in the list
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public Comparable<Car> next() {
		curr += 1;
		return oList [curr];
	}
	
	/*
	 * Checks if there is another object in the list from the iterator
	 * 
	 * @return - true if there is another object, false if there isn't
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public boolean hasNext() {
		return curr + 1 < numObjects;
	}
	
	/*
	 * Removes the current object of the iterator from the ordered list
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public void remove() {
		remove(curr);
	}
	
}
