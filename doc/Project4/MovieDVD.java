public class MovieDVD extends Media {
	
	//attribute
	private double size;	
	
	//constructor
	public MovieDVD(int id , String title , int year , boolean available , double size) {
		super(id , title , year , available);
		this.size = size;
	}
	
	//overloaded constructor
	public MovieDVD(String line) {
		super(line);
		size = Double.parseDouble(line.substring(line.indexOf("<size>") + 6 , line.indexOf("</size>")));
	}
	
	//get method
	public double getSize() {
		return this.size;
	}
	
	//set method
	public void setSize(double size) {
		this.size = size;
	}
	
	//toString method
	public String toString() {
			return "<MovieDVD>"
					+ "<id>" 		+ this.getId() 			+ "</id>"
					+ "<title>" 	+ this.getTitle() 		+ "</title>"
					+ "<year>"		+ this.getYear()		+ "</year>"
					+ "<available>" + this.getAvailable() 	+ "</available>"
					+ "<size>"		+ size					+ "</size>"
					+ "</MovieDVD>"; 
		}

	//display method
	public String displayString() {
		return "MovieDVD [id=" + this.getId() + ", title=" + this.getTitle() + ", year=" + this.getYear() + ", size=" + this.size +"MB, available=" + this.getAvailable() + "]";
	}
}