import java.util.Random;

public abstract class Snack {
	
	Random rng = new Random();
	
	//attributes
	protected double price;
	protected double sPrice = 19.99;
	protected double mPrice = 29.99;
	protected double lPrice = 39.99;
	private String id = "ABC" + rng.nextInt(100000);
	private String size;
	private String type;
	
	//constructor
	public Snack(String size) {
		
		this.size = size;
	}
	public abstract double calcPrice();
		
	
	//get methods
	public String getType() {
		return this.type;
	}
	public double getPrice() {
		switch(size) {
		case "S" :	this.price = sPrice;
					break;
		case "M" :	this.price = mPrice;
					break;
		case "L" :	this.price = lPrice;
					break;
		default  :	this.price = 0;
		}
		return this.price;
	}
	public String getId() {
		return this.id;
	}
	public String getSize() {
		return this.size;
	}
	
	//set methods
	public void setType(int typeChoice) {
		if (typeChoice == 1)
			this.type = "Fruit Snack";
		else if (typeChoice == 2)
			this.type = "Salty Snack";
		else
			this.type = "Invalid type.";
	}
	public void setSize(String sizeChoice) {
		this.size = sizeChoice;
	}
	//to string method
	@Override
	public String toString() {
		return ("You have chosen snack type: " + type + ", size: " + size + ", ID: " + id + ", and price: $" + price);
	}
}
