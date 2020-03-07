package spirale;

public class Spirala {

	private int a, b;
	private double c;
	
	public Spirala(int _a, int _b, double _c) {
		a = _a;
		b = _b;
		c = _c;
	}
	
	public int x(double p) {
		return (int)(a*p*Math.cos(b*p+c)); 
	}
	
	public int y(double p) {
		return (int)(a*p*Math.sin(b*p+c));
	}
}
