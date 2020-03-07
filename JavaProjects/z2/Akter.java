package z2;

import java.awt.*;
import java.awt.event.*;

public abstract class Akter extends Thread {
	protected Label l;
	private boolean radi = false;
	
	Akter(Label l) {
		this.l = l;
	}
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
	}
	
	public synchronized void pauziraj() {
		radi = false;
	}
	
	public void run() {
		try {
			while(!interrupted()) {
				while(!radi) synchronized(this) {wait();}
				radnja();
				l.setText(toString());
			}
		} catch(InterruptedException e) {}
	}
	
	public abstract void radnja() throws InterruptedException;
	public abstract String toString();
}
