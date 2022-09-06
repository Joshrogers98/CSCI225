import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MediaRentalSystem extends JFrame {
	
	//constant
	private static final long serialVersionUID = 1L;
	//attributes
	private JTextArea text;				
	private JFileChooser directory;		
	private String directoryPath;
	
	//constructor to make GUI
	public MediaRentalSystem() {
		
		super("Media Rental System");	//create window title
		setJMenuBar(makeMenus());
		text = new JTextArea(25 , 50);
		text.setMargin(new Insets(3 , 5 , 0 , 0));
		JScrollPane scroller = new JScrollPane(text);
		setContentPane(scroller);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocation(50 , 50);
	}
	
	//create JMenuBar
	private JMenuBar makeMenus() {
		
		ActionListener listener = new ActionListener() {
			//object to serve as listener for menu items
			public void actionPerformed(ActionEvent evt) {
				
				String cmd = evt.getActionCommand();
				
				if(cmd.equals("Load Media"))
					loadMedia();
				else if(cmd.equals("Find Media"))
					findMedia();
				else if(cmd.equals("Rent Media"))
					rentMedia();
				else if(cmd.equals("Quit"))
					quit();
			}
		};	
		
		JMenu fileMenu = new JMenu("Menu");
		
		JMenuItem loader = new JMenuItem("Load Media");
		loader.addActionListener(listener);
		fileMenu.add(loader);
		
		JMenuItem finder = new JMenuItem("Find Media");
		finder.addActionListener(listener);
		fileMenu.add(finder);
		
		JMenuItem renter = new JMenuItem("Rent Media");
		renter.addActionListener(listener);
		fileMenu.add(renter);
		
		fileMenu.addSeparator();
		
		JMenuItem quitter = new JMenuItem("Quit");
		quitter.addActionListener(listener);
		fileMenu.add(quitter);
		
		JMenuBar bar = new JMenuBar();
		bar.add(fileMenu);
		return bar;
	}

	//create load media menu option
	private void loadMedia() {
		
		Manager mgr = null;
		
		if (directory == null)
			directory = new JFileChooser();
		directory.setDialogTitle("Open Directory");
		directory.setCurrentDirectory(null);
		directory.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		directory.setAcceptAllFileFilterUsed(false);
		if(directory.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
			return;	//indicates user cancelled or closed dialog box
		directoryPath = directory.getSelectedFile().toString();

		try {
			mgr = new Manager(directoryPath);
			mgr.displayAllMedia();
			
		}catch(FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(this , "Sorry but an error occured while trying to open this file " + e);
			return;
		}
		try {
			mgr.createMediaFiles(directoryPath);
		}catch (IOException e) {
			JOptionPane.showMessageDialog(this , "Sorry, there was an error trying to create or update file(s).");
		}
	}
	
	//create find media menu option
	private void findMedia() {
		
		Manager mgr;
		try {
			mgr = new Manager(directoryPath);
			String str = mgr.searchMedia(JOptionPane.showInputDialog("Enter a title"));
			JOptionPane.showMessageDialog(this ,  str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//create rent media menu option
	private void rentMedia() {
		
		Manager mgr;
		try {
			mgr = new Manager(directoryPath);
			String str = mgr.searchRental(Integer.parseInt(JOptionPane.showInputDialog("Enter the ID.")));
			JOptionPane.showMessageDialog(this ,  str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//create quit menu option
	private void quit() {
		
		System.exit(0);
	}

	//start main method
	public static void main(String[] args) {

		JFrame window = new MediaRentalSystem();
		window.setVisible(true);
	}
}