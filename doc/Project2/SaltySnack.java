
public class SaltySnack extends Snack {
	
	//attributes
	private boolean nut;
	private double nPrice;
	
	//constructor
	public SaltySnack(String size , boolean nut) {
		
		super(size);
		this.nut = nut;
		if(nut)
			nPrice = 4.5;
		else
			nPrice = 0;
	}
	
	//get method
	public boolean getNut() {
		return this.nut;
	}
	
	//set method
	public void setNut(boolean addNut) {
		this.nut = addNut;
	}
	
	//new price method
		public double calcPrice() {
			price = 100 * (getPrice() + nPrice);
			price = Math.round(price);
			price = price / 100;
			return price;
		}
		
		//to string method
				@Override
				public String toString() {
					return ("You have chosen snack type: " + getType() + ", size: " + getSize() + ", ID: " + getId() + ", and price: $" + price);
				

				}
}