import java.util.Calendar;

public class MusicCD extends Media {
	
	//attribute
	private int length;
	
	//constructor
	public MusicCD(int id , String title , int year , boolean available , int length) {
		super(id , title , year , available);
		this.length = length;
	}
	
	//overloaded constructor
	public MusicCD(String line) {
		super(line);
		length = Integer.parseInt(line.substring(line.indexOf("<length>") + 8 , line.indexOf("</length>")));
	}
	
	//get method
	public int getLength() {
		
		return length;
	}
	
	//set method
	public void setLength(int length) {
		this.length = length;
	}
	
	//override base fee
	@Override
	public double rentalFee() {
		
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		double fee = length * 0.02;
		
		if(getYear() == thisYear)
			fee = fee + 1;
		return fee;
	}
	
	//toString method
	public String toString() {
			return "<MusicCD>"
					+ "<id>" 		+ this.getId() 			+ "</id>"
					+ "<title>" 	+ this.getTitle() 		+ "</title>"
					+ "<year>"		+ this.getYear()		+ "</year>"
					+ "<available>" + this.getAvailable() 	+ "</available>"
					+ "<length>"	+ length				+ "</length>"
					+ "</MusicCD>";
	}
	
	//display method
	public String displayString() {
		return "MusicCD [id=" + this.getId() + ", title=" + this.getTitle() + ", year=" + this.getYear() + ", length=" + this.length +"Minutes, available=" + this.getAvailable() + "]";
	}
}