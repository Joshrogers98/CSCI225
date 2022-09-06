/*@Author Joshua Rogers
 * Project 3 CMIS 242
 * 22 April 2022
 * This program creates a GUI with 3 buttons, Distance converter, Temperature Converter,  and exit
 * these buttons call the class Converter as well as its child classes TemperatureConverter and DistanceConverter
 * These child classes convert from miles to kilometers and F to C respectively
 * When the button on the interface is clicked the user will be asked to input distance in miles
 * or temperature in F to be converted to either kilometers or C.
 * once the user has input their number to be converted, a new window will appear with the input and current values as
 * well as their respective labels.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIConverter {
	//exit event handler
	private static class ExitHandler implements ActionListener{
			
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	//Distance converter event handler
	private static class DistHandler implements ActionListener{
		
		private JFrame window = null;
		
		private DistanceConverter distance = new DistanceConverter();
		
		public DistHandler(JFrame frame) {
			window = frame;
		}
		public void actionPerformed(ActionEvent e) {
			
			distance.setIn(Double.parseDouble(JOptionPane.showInputDialog(window, "Input miles distance to convert.")));
			
			JOptionPane.showMessageDialog(window , distance.getIn() + " miles equals " + distance.convert() + " Kilometers.");
		}
	}
	//Temperature converter event handler
	private static class TempHandler implements ActionListener{
		
		private JFrame window = null;
		
		private TemperatureConverter temp = new TemperatureConverter();
		
		public TempHandler(JFrame frame) {
			
			window = frame;
		}
		public void actionPerformed(ActionEvent e) {
			
			temp.setIn(Double.parseDouble(JOptionPane.showInputDialog(window , "Input fahrenheit temperature to convert.")));
			
			JOptionPane.showMessageDialog(window, temp.getIn()  + " F equals " + temp.convert() + " C");
		}
	}
	//create the GUI
	private static class MakeGUI{
		
		public MakeGUI(){
			//create the three JButtons
			JButton distConverter = new JButton("Distance Converter");
			JButton tempConverter = new JButton("Temperature Converter");
			JButton exit = new JButton("Exit");
			
			//create the JFrame
			JFrame window = new JFrame("Welcome to Converter");
			
			//create JPanel
			JPanel content = new JPanel();
			content.setLayout(new BorderLayout());
			
			//add listeners to buttons
			ExitHandler exitListener = new ExitHandler();
			exit.addActionListener(exitListener);
			DistHandler distListener = new DistHandler(window);
			distConverter.addActionListener(distListener);
			TempHandler tempListener = new TempHandler(window);
			tempConverter.addActionListener(tempListener);
			
			//add buttons to the panel
			content.add(exit , BorderLayout.SOUTH);
			exit.setPreferredSize(new Dimension(500 , 25));
			content.add(distConverter , BorderLayout.WEST);
			distConverter.setPreferredSize(new Dimension(250 , 175));
			content.add(tempConverter , BorderLayout.EAST);
			tempConverter.setPreferredSize(new Dimension(250 , 175));
			
			
			//add panel to the window
			window.setContentPane(content);
			
			//set window size and location
			window.setSize(500 , 200);
			window.setLocation(500 , 500);
			window.setVisible(true);
		}
	}
	//main method
	public static void main(String[] args) {
		MakeGUI gui = new MakeGUI();
	}
}