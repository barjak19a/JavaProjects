package gsp;

import java.awt.*;

public abstract class Akter extends Thread{

	private boolean radi = true;
	protected Label l;
	private long minT, maxT;
	
	public Akter(Label _l, long _minT, long _maxT) {
		l = _l;
		minT = _minT;
		maxT = _maxT;
	}
	
	public abstract void radnja() throws InterruptedException;
	
	public void run() {
		try {
			while(!interrupted()) {
				
				synchronized(this) {
					while(!radi)wait();
				}
				
				sleep(minT + (long)(Math.random() * (maxT-minT)));
				radnja();
			}
		}
		catch(InterruptedException g) { }
	}
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
	}
	
	public void stani() {
		radi = false;
	}
	
	public void unisti() {
		interrupt();
	}
	
}
