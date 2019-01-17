import java.util.Scanner;
import java.util.ArrayList;
/* Peter J George       Project 0 
 * Due: Monday, 01/21/2019         CMSC401-001 Spring 2019 @VCU
 */

public class TrialAssignment {
	public static void main(String[] args){	
		
	Scanner sc = new Scanner(System.in); //initializing scanner
	String input = sc.nextLine(); //Get the first line from user
	
	
	//while(!input.startsWith("Q")) { //Q to quit, no spaces         Performs endlessly until user inputs "Q"
		ArrayList<Integer> ints = new ArrayList<>(); //Local ArrayList within the while loop, will reset between new command statements
		
		if(input.startsWith("A")) {  //--------------- For A commands
			Scanner lineScanner = new Scanner(input);
			lineScanner.next(); //Skips initial identifying letter to allow integers only. Error if multiple letters (No exception thrown due to project specs)
			int count = 0;
			
			while(lineScanner.hasNext()) {    //A loot to assign all subsequent integers following the identifying letter to a space in local arrayList, counts usage
				ints.add(Integer.parseInt(lineScanner.next()));
				count++; 
			}
			
			int upperBound = ints.get(count-1);    //Sets the ending point for the multiply chain to the last value in "ints"
			int lowerBound = ints.get(count - 2);    //Sets the start of the multiply chain to the second last value in "ints"
			
			System.out.println(multiply(ints, lowerBound, upperBound));
			lineScanner.close();
		}
		
		if(input.startsWith("B")) { //--------------- For B commands
			Scanner lineScanner = new Scanner(input);
			lineScanner.next();
			int toFactorial = lineScanner.nextInt();
			System.out.println(factorial(toFactorial));
			lineScanner.close();
		}	
		
		
		//input = sc.nextLine(); // Prompt user for next line        IF WHILE Q LOOP NEEDS TO BE TRASHED, DELETE THIS
	//}
	sc.close(); //Close scanner for resource leak
	
	}
	
	
	/* A method that intakes an arrayList, and the upper/lower bounds to multiply through
	 * @start an integer with the first value of the multiple chain
	 * @count keeps track of when to finish the multiple chain
	 * @return returns start after all multiplication necessary has been completed
	 */
	static int multiply(ArrayList<Integer> anArray, int Low, int High) {
		int start = anArray.get(Low-1);
		int count = Low;
		while(count < High) {			
			start = start * anArray.get(count);
			count++;
		}
		return start;
	}
	
	/* A method to return the factorial of an integer
	 * @return returns recursive factorial product of anInt and all of it's subsequent ints until, but not lower than, 1
	 */
	static int factorial(int anInt) {
		if(anInt == 1) {
			return 1;
		}   
		return anInt * factorial(anInt - 1);
	}
}
