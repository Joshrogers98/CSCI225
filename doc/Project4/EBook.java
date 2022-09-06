import java.util.Calendar;

public class EBook extends Media {
	
	//attribute
	private int numChapters;
	
	//constructor
	public EBook(int id , String title , int year , boolean available , int chapters) {
		super(id , title , year , available);
		this.numChapters = chapters;
	}
	
	//overloaded constructor
	public EBook(String line) {
		super(line);
		numChapters = Integer.parseInt(line.substring(line.indexOf("<numChapters>") + 13 , line.indexOf("</numChapters>")));
	}
	
	//get method
	public int getNumChapters() {
		
		return numChapters;
	}
	
	//set method
	public void setNumChapters(int numChapters) {
		
		this.numChapters = numChapters;
	}
	
	//rental fee
	@Override
	public double rentalFee() {
		
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		double fee = numChapters / 10;
		
		if(getYear() == thisYear)
			fee = fee + 1;
		
		return fee;
	}
	
	//toString method
	public String toString() {
		return "<EBook>"
				+ "<id>" 		+ this.getId() 			+ "</id>"
				+ "<title>" 	+ this.getTitle() 		+ "</title>"
				+ "<year>"		+ this.getYear()		+ "</year>"
				+ "<available>" + this.getAvailable() 	+ "</available>"
				+ "<numChapters>"+numChapters			+ "</numChapters>"
				+ "</EBook>";
	}
	
	//display method
	public String displayString() {
		return "EBook [id=" + this.getId() + ", title=" + this.getTitle() + ", year=" + this.getYear() + ", Chapters=" + this.numChapters +", available=" + this.getAvailable() + "]";
	}
}