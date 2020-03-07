package pljusak;

import java.awt.*;

public class Talas extends Thread implements Prikaziva{

	private int x, y;
	private double dr, db;
	private double r;
	private double col;
	private boolean radi = true;
	
	public Talas(Kap k) {
		col = 0;
		x = k.x();
		y = k.y();
		dr = 0.05 * k.q();
		db = 2;
		r = 100;
		start();
	}
	
	public void run() {
		try {
			
			while(!interrupted()) {
				
				synchronized(this) {
					while(!radi) wait();
				}
				
				sleep(40);
				r += dr;
				col += db;
				if(col==254) this.interrupt();
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
	
	public void prekid() {
		interrupt();
	}
	
	public void crtaj(Graphics g) {
		g.setColor(new Color((int)col,(int)col,(int)col));
		g.drawOval(x, y, (int)r, (int)r);
	}
}
