package pi;

import java.awt.*;

public class Krug extends Akter{

	private double m,n;
	
	public Krug(TextArea ta) {
		super(ta);
		m = 0;
		n = 0;
	}
	
	public void racunaj() {
		double x = Math.random();
		double y = Math.random();
		
		if(x>0.5 && y>0.5) m++;
		n++;
	
		super.PI = (12*m)/n;
		
	}
	
	public void ocisti() {
		m = n = 0;
	}
}
