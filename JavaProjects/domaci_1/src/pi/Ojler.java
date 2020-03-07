package pi;

import java.awt.*;

public class Ojler extends Akter{

	private double sum = 0;
			
	public Ojler(TextArea ta) {
		super(ta);
	}
	
	public void ocisti() {
		sum = 0;
	}
	
	public void racunaj() {
		sum += 6/(iter+1);
		PI = Math.sqrt(sum);
	}
}
