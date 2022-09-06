import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	
	//constant
	private static final DecimalFormat DF = new DecimalFormat("0.00");
	
	//attribute
	private ArrayList<Media> medias = new ArrayList<>();
	
	//constructor
	public Manager() {
		
		//initialize array list
		medias = new ArrayList<Media>();
	}
	
	//new constructor with parameter for String
	public Manager(String directory) throws FileNotFoundException {
		
		//initialize array list
		medias = new ArrayList<Media>();
		
		//create a file object for directory
		File folder = new File(directory);
		
		//array of all files in the directory
		File[] filesList = folder.listFiles();
		
		//validate
		if(filesList == null)
			throw new FileNotFoundException("Could not load, no directory exists.");
		
		//declare local variables
		Media media = null;
		String line = null;
		Scanner scan = null;
		
		//process each media file
		for (File file : filesList) {
			
			//parse files whose name starts with "EBook" , "MovieDVD" , "MusicCD".
			if (file.getName().contains("EBook")||file.getName().contains("MovieDVD")||file.getName().contains("MusicCD")) {
				
				//assume the file is not empty and read the line
				scan = new Scanner(file);
				line = scan.nextLine();

				//call constructors from child classes depending on which file is used
				if(file.getName().contains("EBook"))
					media = new EBook(line);
				if(file.getName().contains("MovieDVD"))
					media = new MovieDVD(line);
				if(file.getName().contains("MusicCD"))
					media = new MusicCD(line);
				//add objects to the attribute array
				medias.add(media);
			}
		}
	}
	
	//create / update a file for each media object in the medias array
	public void createMediaFiles(String directory) throws IOException {
		
		//initialize print writer
		PrintWriter out = null;
		
		//create / overwrite the file for each media stored in array
		for (int i = 0 ; i < medias.size(); i++) {
			String fileName = directory + "/" + medias.get(i).getClass().getSimpleName() + "-" + medias.get(i).getId() + ".txt";
			out = new PrintWriter(new FileWriter(fileName));
			out.println(medias.get(i).toString());
			out.flush();	//make sure that out writes to the file
			out.close();	//close print writer
		}
	}
	
	//method to display all media to console
	public void displayAllMedia() {
		
		//loop to add all display all the media files
		for(int i = 0 ; i < medias.size() ; i++) {
			System.out.println(medias.get(i).displayString());
		}
	}
	
	//search media function
	public String searchMedia(String title) {

		String result = "";
		
		for(int i = 0 ; i < medias.size() ; i++) {
			
			String savedTitles = medias.get(i).getTitle();
			
			if (savedTitles.contains(title))
				result = result + medias.get(i).displayString() + "\n";
		}
		if(result == "")
			result = "There is no media with this title: " + title;
		
		return result;
	}

	//method to search for rental
	public String searchRental(int id) {
		
		
		String result = "Invalid title value.";
		double fee;
		for (int i = 0 ; i < medias.size(); i++) {
			if(id == medias.get(i).getId()) {
				fee = medias.get(i).rentalFee();
				if(medias.get(i).getAvailable())
					result = "Media was successfully rented. Rental fee = $" + DF.format(fee);
				else
					result = "This media is currently unavaileble";
			}	
		}
		return result;
	}
	
	//add media object
	public void addMedia(Media media) {
		medias.add(media);
	}
}