
public class Converter{
	//attributes
	private double in;
	//constructor
	public Converter() {
		in = Double.NaN;
	}
	//overloaded constructor with parameter
	public Converter(Double in) {
		this.in = in;
	}
	//get method
	public double getIn() {
		return this.in;
	}
	//set method
	public void setIn(double in) {
		this.in = in;
	}
	//convert method
	private double convert() {
		return in;
	}
}
