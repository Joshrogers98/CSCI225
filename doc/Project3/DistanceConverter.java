
public class DistanceConverter extends Converter {
	//constructors to call parent constructor
	public DistanceConverter() {
	}
	//overloaded parent method
	public DistanceConverter(double in) {
		super(in);
	}
	//override convert()
	public double convert() {
		
		if (super.getIn() != Double.NaN) {
			double distance = (super.getIn() * 1.609);
			return distance;
		}
		else
			return Double.NaN;
	}
}