	public abstract class Media {
		
		//constant
		private static final double RENTALFEE = 3.50;
		
		//attributes
		private int id;
		private String title;
		private int year;
		private boolean available;
		
		//establish constructor
		public Media(int id , String title , int year , boolean available) {
			
			this.id = id;
			this.title = title;
			this.year = year;
			this.available = available;
		}
		
		//constructor to parse string with xml tags for its values
		public Media(String line) {
			id = Integer.parseInt(line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>")));
			title = line.substring(line.indexOf("<title>") + 7, line.indexOf("</title>"));
			year = Integer.parseInt(line.substring(line.indexOf("<year>") + 6, line.indexOf("</year>")));
			available = Boolean.parseBoolean(line.substring(line.indexOf("<available>") + 11 , line.indexOf("</available>")));
		}
		
		//establish get methods		
		public int getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		public int getYear() {
			return year;
		}
		public double rentalFee() {
			return RENTALFEE;
		}
		public boolean getAvailable() {
			return available;
		}
		
		//set methods
		public void setTitle(String title) {
			this.title = title;
		}
		public void setAvailable(boolean available) {
			this.available = available;
		}
		public void setYear(int year) {
			this.year = year;
		}

		//toString method
		public abstract String toString();
		
		//diplay string method
		public abstract String displayString();
	}