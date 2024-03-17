import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;

/*
 * This is the main class. This creates a scanner and printwriter to read a file, put that information into an ordered list, and print that on another file.
 * CSC 1351 Programming Project No 1
 * 
 * Section 2
 * 
 * @author Jonathan Breaux
 * @since 03/17/24
 */

public class Prog01_aOrderedList {
	
	/*
	 * Gets the name of the input file, and creates and opens a scanner for this file
	 * (Could only read with forward slashes)
	 * 
	 * @param userPrompt - the question displayed to the user
	 * @throws - FileNotFoundException when a file is not found
	 * @return - Scanner for the input file
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static Scanner GetInputFile(String userPrompt) throws FileNotFoundException {
		Scanner scanner = new Scanner(System.in); //Scanner for the user response
		System.out.print(userPrompt);
		String filename = scanner.nextLine(); //User Response(Should be the name of the file)
		
		if (!filename.startsWith(":\\", 1) && !filename.startsWith(".\\") && !filename.startsWith("\\") && !filename.startsWith("./") && !filename.startsWith(":/", 1) && !filename.startsWith("/")) {
			filename = "./" + filename;
		}
		if(filename.contains(File.separator)) {
			return new Scanner(new File(filename));
		}
		else {
			return new Scanner(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + filename));
		}
	}
	
	/*
	 * Reads the input file, and creates an ordered list
	 * 
	 * @param scanner - the scanner of the input file
	 * @return - the ordered list
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static aOrderedList reader(Scanner scanner) {
		aOrderedList orderedList = new aOrderedList(); //Creates the Ordered List
		
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine(); //The iterated line of the input file
			Scanner stringScanner = new Scanner(s); //The scanner to read the each line
			stringScanner.useDelimiter(",\\s*");
			
			while(stringScanner.hasNext()) {
				String val = stringScanner.next(); //The value of either A or D
				
				String make = ""; //Object variable with null value
				int year = 0; //Object variable with null value
				int price = 0; //Object variable with null value
				
				try {
					make = stringScanner.next();
					year = Integer.valueOf(stringScanner.next());
					price = Integer.valueOf(stringScanner.next());
				}
				catch (NoSuchElementException e) {	
				}
				catch (NumberFormatException e) {	
				}
				
				if (val.equals("A")) {
					Car car = new Car(make, year, price); //Creates new car object to add
					orderedList.add(car);
				}
				else if (val.equals("D")) {
					orderedList.reset();
					for (int i = 0; i < orderedList.size(); i++) {
						if (orderedList.hasNext()) {
							Car currCar = (Car) orderedList.next(); //The current car being compared to the delete case
							if (currCar.getMake().equals(make) && currCar.getYear() == year) {
								if (currCar.getPrice() == price || price == 0) {
									orderedList.remove();
								}
							}
						}
					}
				}
			}
			stringScanner.close();
		}
		return orderedList;
	}
	
	/*
	 * Gets the name of the output file, and creates and opens a PrintWriter for this file
	 * (Could only read with forward slashes)
	 * 
	 * @param userPrompt - the question displayed to the user
	 * @throws - FileNotFoundException when the file can't be found
	 * @return - the PrintWriter for the output file
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static PrintWriter GetOutputFile(String userPrompt) throws FileNotFoundException {
		
		System.out.print(userPrompt);
		Scanner scanner = new Scanner(System.in); //Scanner for the user response
		String filename = scanner.nextLine(); //The user response(Should be the output file name)
		
		if (!filename.startsWith(":\\", 1) && !filename.startsWith(".\\") && !filename.startsWith("\\") && !filename.startsWith("./") && !filename.startsWith(":/", 1) && !filename.startsWith("/")) {
			filename = "./" + filename;
		}
		
		if (filename.contains(File.separator)) {
			return new PrintWriter(new File(filename));
		}
		else {
			return new PrintWriter(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + filename));
		}
	}
	
	/*
	 * Formats the ordered list
	 * 
	 * @param list - the ordered list
	 * @return - the formatted version of the ordered list
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static String formatter(aOrderedList list) {
		String output = ""; //The string to be returned after the method is completed
		
		output += "Number of cars:\t" + list.size();
		
		for (int i = 0; i < list.size(); i++) {
			Car car = (Car) list.get(i);
			
			if (car.getMake().equals("")) {
				output += "\n\nMake:\tnull";
			}
			else {
				output += "\n\nMake:\t" + car.getMake();
			}
			
			if (car.getYear() == 0) {
				output += "\nYear:\tnull";
			}
			else {
				output += "\nYear:\t" + car.getYear();
			}
			
			if (car.getPrice() == 0) {
				output += "\nPrice:tnull";
			}
			else {
				String priceArrange = String.format("$%,d", car.getPrice()); //Adds dollar sign and commas to the price
				output += "\nPrice:\t" + priceArrange;
			}
		}
		return output;
	}
	
	/*
	 * If a file isn't found, checks if user would like to continue
	 * 
	 * @param userPrompt - the question displayed to the user
	 * @return - true if user chooses Y, false if user chooses N
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static boolean yesOrNo(String userPrompt) {
		boolean b = false; //The boolean to be returned
		
		System.out.println(userPrompt);
		Scanner scan = new Scanner(System.in); //The scanner to read the user response
		String answer = scan.nextLine(); //The user response (Should be Y or N)
		
		if (answer.equals("Y")) {
			b = true;
		}
		else if (answer.equals("N")) {
			b = false;
			scan.close();
			System.exit(0);
		}
		return b;
	}
	
	/*
	 * The main method. Prompts the user when necessary, and reads and writes on the given files.
	 * 
	 * CSC 1351 Programming Project No 1
	 * 
	 * Section 2
	 * 
	 * @author Jonathan Breaux
	 * @since 03/17/24
	 */
	
	public static void main(String[] args) {
		boolean b; //boolean meant to end the program if true
		do {
			b = false;
			try {
				
				Scanner scanner = GetInputFile("Enter the filename: ");
				
				aOrderedList orderedList = reader(scanner);
				
				PrintWriter writer = GetOutputFile("Enter the output filename: ");
				
				String fList = formatter(orderedList); //formatted list
				writer.println(fList);
				
				scanner.close();
				writer.close();

			}
			catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			b = yesOrNo("Would you like to continue? <Y/N>");
		}
		}
		while (b);	
	}	
	
}