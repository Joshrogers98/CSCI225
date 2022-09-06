/**@author Josh Rogers
 * CMIS 242
 * 25MAR2022
 * This Program takes three static weights and
 * compares them by minimum and maximum
 * then converts them to strings to print.
 * This program also takes the three weights and
 * prints the average weight of all three in pounds and ounces.
 */
public class Weight {
	
	//constants
	private static final int CONVERTER = 16;								//16 is the converter for pounds to ounces since there are 16 ounces in a pound
	private static final int ROUNDER = 100;									//100 is used to round a double to the 100th place ex. x.xx
		
	//instance variables
	private int pounds;														//establish pounds as an integer since any remainder will be displayed in ounces
	private double ounces;													//establish ounces as a double since it is the remainder of the total weight in pounds
	
	//constructor
	public Weight (int pounds, double ounces) {
		
		this.ounces = ounces;												
		this.pounds = pounds;												
	}
	
	//instance methods
	
	//convert all pounds and ounces to only ounces
	public double toOunces() {
		
		this.ounces = this.ounces + (this.pounds * CONVERTER);				//set all weight to ounces
		this.pounds = 0;													//update pounds since while all weight is currently in ounces
		return this.ounces;													//return the total weight as ounces
	}
	
	//convert any instance of weight to lbs and oz separately
	public void normalize() {
		
		double allOunces = toOunces();										//convert to only ounces
		double allPounds = allOunces / CONVERTER;							//convert from only ounces to only pounds as a double
		this.pounds = (int) allPounds;										//cast the double to an int as the correct value for pounds
		this.ounces = (allPounds - this.pounds) * CONVERTER;				//take the remainder as ounces, multiply by 16 to get the correct value
		this.ounces = (double) Math.round(this.ounces * ROUNDER) / ROUNDER;	//round to two decimal places
		
	}
	
	public String toString() {
		
		normalize();														//run normalize so you don't have to before calling this method every time
		String poundsStr = Integer.toString(this.pounds);					//create a string value for pounds
		String ouncesStr = Double.toString(this.ounces);					//create a string value for ounces
		return (poundsStr + "lbs. " + ouncesStr + "oz.");					//return a string as xLbs. yoz.
	}
	
	public boolean lessThan(Weight weight) {
		
		boolean result = toOunces() < weight.toOunces();
		return result;
	}

}
