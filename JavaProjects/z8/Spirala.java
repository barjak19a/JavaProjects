package z8;

public class Spirala extends Funkcija {
	private double a, b, c;
	
	public Spirala(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double x(double p) {
		return a * p * Math.cos(b*p + c);
	}

	@Override
	public double y(double p) {
		return a * p * Math.sin(b*p + c);
	}

}
