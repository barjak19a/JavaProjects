package slot;

import java.awt.*;

public class Prikazivac extends Canvas implements Runnable{

	private Thread nit = new Thread(this);
	private static final long serialVersionUID = 0;
	private Color col;
	private Simbol s;
	private boolean radi = false;
	
	public Prikazivac(Color _col, Simbol _s) {
		col = _col;
		s = _s;
		int sl = (int)(Math.random()*3);
		if(sl==0) s = new Izlomljena(10,10,90,90);
		else if(sl==1) s = new Elipsa(10,10,80,80);
		else s = new Zvezda(10,10,90,90);
		
		nit.start();
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
	
				synchronized(this) {
					while(!radi)wait();
				}
				
				Thread.sleep(50+(long)(150*Math.random()));
				int sl = (int)(Math.random()*3);
				if(sl==0) s = new Izlomljena(10,10,90,90);
				else if(sl==1) s = new Elipsa(10,10,80,80);
				else s = new Zvezda(10,10,90,90);
				
				repaint();
			}
		}
		catch(InterruptedException g) { }
	}
	
	public boolean radi() {
		return radi;
	}
	
	public Simbol simbol() {
		return s;
	}
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
	}
	
	public void stani() {
		radi = false;
	}
	
	public void prekini() {
		nit.interrupt();
	}
	
	public void paint(Graphics g) {
		g.setColor(col);
		s.crtaj(g);
	}
}
