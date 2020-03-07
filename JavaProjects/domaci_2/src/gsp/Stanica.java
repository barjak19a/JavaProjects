package gsp;

import java.awt.*;

public class Stanica extends Akter{

	private int br = 0;
	private String naziv; 
	
	public Stanica(Label _l, long _minT, long _maxT, String _naziv) {
		super(_l, _minT, _maxT);
		naziv = _naziv;
		start();
	}
	
	public void radnja() throws InterruptedException {
		br++;
		l.setText(this.toString());
	}
	
	public int dohv() {
		return br;
	}
	
	public void uzmi(int k) {
		br-=k;
	}
	
	public String ime() {
		return naziv;
	}
	
	@Override
	public String toString() {
		return naziv + ":" + br;
	}
}
