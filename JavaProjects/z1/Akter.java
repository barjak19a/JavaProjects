package z1;

import java.awt.*;
import java.awt.event.*;

public abstract class Akter extends Thread {
	protected Prikazivac p;
	protected int iter;
	private boolean radi = false;
	protected double korak;
	
	Akter(Prikazivac pp) {
		p = pp;
		start();
	}
	
	public synchronized void kreni(int i, int k) {
		iter = i;
		korak = k;
		radi = true;
		notifyAll();
	}
	
	public synchronized void zaustavi() {
		radi = false;
	}
	
	public void run() {
		try {
			while(!interrupted()) {
				while(!radi) synchronized(this) { wait(); }
				racunaj();
				radi = false;
			}
		} catch(InterruptedException e) {}
	}
	
	public abstract void racunaj();
}
