package z2;

import java.awt.*;
import java.awt.event.*;

public class Stanica extends Akter {
	private String ime;
	private long tmin, tmax;
	private int putnici;
	
	Stanica(Label l, String ime, long min, long max) {
		super(l);
		this.ime = ime;
		tmin = min;
		tmax = max;
		start();
	}

	@Override
	public void radnja() throws InterruptedException {
		// TODO Auto-generated method stub
		sleep((long) (tmin + Math.random()*(tmax - tmin)));
		putnici++;
	}
	
	public int brPutnika() {return putnici;}
	public String ime() {return ime;}
	public synchronized void smanji(int k) {
		putnici -= k;
		if(putnici < 0) putnici = 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ime + " " + putnici;
	}
}
