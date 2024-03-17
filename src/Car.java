
/*
 * The class represents a car object that has a make, year, and price. Each car object can be compared to another car object as well.
 * CSC 1351 Programming Project No 1
 * 
 * Section 2
 * 
 * @author Jonathan Breaux
 * @since 03/17/24
 */

public class Car implements Comparable<Car> {
	
	private String make; //The make of the car object
	private int year; //The year of the car object
	private int price; //The price of the car object
	
	/*
	 * Constructor for Car class
	 * 
	 * @param make - intitializes make of the car
	 * @param year - intializes year of the car
	 * @param price - initializes the price of the car
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	/*
	 * Getter for parameter make
	 * 
	 * @return - the make of the car
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public String getMake() {
		return make;
	}
	
	/*
	 * Getter for the parameter year
	 * 
	 * @return - the year of the car
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
 	 * @author Jonathan Breaux
 	 * @since 03/17/24
	 */
	
	public int getYear() {
		return year;
	}
	
	/*
	 * Getter for the parameter price
	 * 
	 * @return - the price of the car
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public int getPrice() {
		return price; 
	}
	
	/*
	 * Compares two car objects, first by make, and then by year
	 * 
	 * @param other - the car object being compared to the first car object
	 * @return - which car object is either alphebatically before the other in make, or if they are the same, which car object is earlier in year.
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public int compareTo(Car other) {
		if(make.compareTo(other.make)!= 0)
			return make.compareTo(other.make);
		else
			return Integer.compare(year,other.year);
		
	}
	
	/*
	 * Overrides the toString for Car class
	 * 
	 * @return - formatted string "Make: " + make + ", Year: " + year + ", PriceL " + price + ";"
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
		return "Make: " + make + ", Year: " + year + ", Price: " + price + ";";
	}
	
}
