
public class FruitSnack extends Snack {

	//attributes
	private boolean citrus;
	private double cPrice;
	
	
	
	//constructor
	public FruitSnack(String size , boolean citrus) {
		
		super(size);
		
		this.citrus =  citrus;
		if (citrus)
			cPrice = 5.99;
		else
			cPrice = 0;
	}
	
	//get method
	public boolean getCitrus() {
		return this.citrus;
	}
	
	//set method 
	public void setCitrus(boolean addCitrus) {
		this.citrus = addCitrus;
	}

	//new price method
	public double calcPrice() {
		price = 100 * (getPrice() + cPrice);
		price = (Math.round(price));
		price = price / 100;
		return (price);
	}
	//to string method
		@Override
		public String toString() {
			
			return ("You have chosen snack type: " + getType() + ", size: " + getSize() + ", ID: " + getId() + ", and price: $" + price);
		}
}
