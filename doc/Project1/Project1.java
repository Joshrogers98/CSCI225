/**@author Josh Rogers
*/
/**
 * CMIS 242
 * 25MAR2022
 * This Program takes three static weights and
 * compares them by minimum and maximum
 * then converts them to strings to print.
 * This program also takes the three weights and
 * prints the average weight of all three in pounds and ounces.
 */
public class Project1 {
	
	private static final int POUNDS1 = 8;
	private static final int POUNDS2 = 14;
	private static final int POUNDS3 = 14;
	private static final double OUNCES1 = 1.9;
	private static final double OUNCES2 = 1.6;
	private static final double OUNCES3 = 1.6;

	private static String findMinimum(Weight weight1, Weight weight2, Weight weight3) {
			
		//something to print if there is no lowest value.
		String noResult = "No results, two or more values are equal.";
	
		//if weight is less than both other weights it must be the lowest
		if(weight1.lessThan(weight2) && weight1.lessThan(weight3))
			return weight1.toString();
		
		else if(weight2.lessThan(weight1) && weight2.lessThan(weight3))
			return weight2.toString();
		
		else if(weight3.lessThan(weight1) && weight3.lessThan(weight2))
			return weight3.toString();
		
		else 
			return noResult;		
	}
		
	private static String findMaximum(Weight weight1 , Weight weight2, Weight weight3) {
		
		//create a string to say if there was an error
		String noResult = "Error.";
		
		//if weight is not less than the other two, than it must be greater than both.
		if (!(weight1.lessThan(weight2)) && !(weight1.lessThan(weight3)))
			return weight1.toString();
		
		else if(!(weight2.lessThan(weight1)) && !(weight2.lessThan(weight3)))
			return weight2.toString();
		
		else if(!(weight3.lessThan(weight1)) && !(weight3.lessThan(weight2)))
			return weight3.toString();
		
		else 
			return noResult;
	}
	
	private static String findAverage(Weight weight1 , Weight weight2, Weight weight3) {
		
		//convert weight objects to ounces (double)
		double oz1 = weight1.toOunces();
		double oz2 = weight2.toOunces();
		double oz3 = weight3.toOunces();
		
		//create an array for the loop to call each weight individually
		double[] weights = {oz1 , oz2 , oz3};
		
		//set inital values for the final average
		int avgPounds = 0;
		double avgOunces = 0;
		
		//for loop to have counter as the number of times the loop completes and continue to add to the total ounces
		int counter = 0;
		
		for(int i = 0; i < weights.length; i++) {
			
			avgOunces = avgOunces + weights[i];
			//counter adds 1 each time the loop completes
			counter++;
		}
		
		//get the average in ounces
		avgOunces = avgOunces / counter;
		
		//create an instance of the average weight
		Weight average = new Weight(avgPounds , avgOunces);
		
		//print all values for each weight
		System.out.println("\nWeight 1: " + weight1 + "\nWeight 2: " + weight2 + "\nWeight 3: " + weight3);
		
		//return the string of the average weight
		return average.toString();
	}

	//run main method
	public static void main(String[] args) {
		
		//create three instances of "Weight"
		Weight weight1 = new Weight(POUNDS1 , OUNCES1);
		Weight weight2 = new Weight(POUNDS2 , OUNCES2);
		Weight weight3 = new Weight(POUNDS3 , OUNCES3);
				
		//print results from each method
		System.out.println("The minimum weight is: " + findMinimum(weight1 , weight2 , weight3));
		System.out.println("The maximum weight is: " + findMaximum(weight1 , weight2 , weight3));
		System.out.println("The average weight is: " + findAverage(weight1 , weight2 , weight3));
		//end main
	}
//end class
}
