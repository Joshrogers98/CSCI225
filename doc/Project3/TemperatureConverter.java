
public class TemperatureConverter extends Converter{
	//constructor to call parent constructor
	public TemperatureConverter(){
	}
	//overloaded parent method
	public TemperatureConverter(double in) {
		super(in);
	}	
	//override convert()
	public double convert() {
		
		if (super.getIn() != Double.NaN) {
		double temp = ((super.getIn() - 32) * 5) / 9;
		return temp;
		}
		else
			return Double.NaN;
	}
}
