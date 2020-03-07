package pi;

import java.awt.*;

public abstract class Akter extends Thread{

	private int maxIter;
	protected int iter;
	private Prikazivac p;
	protected double PI;
	private double prePI;
	private boolean radi = true;
	
	public Akter(TextArea _ta) {
		maxIter = 100;
		iter = 0;
		prePI = Math.PI;
		p = new Prikazivac(_ta);
		start();
	}
	
	protected abstract void ocisti();
	
	public synchronized void setIter(int _iter) {
		maxIter = _iter;
		ocisti();
		iter = 0;
		notifyAll();
	}
	
	public void run() {
		try {
			
			while(!interrupted()) {
				synchronized(this) {
					while(iter==maxIter || radi==false) wait();
				}
				
				sleep(5);
				racunaj();
				
				iter++;
				if(iter==maxIter) {
					p.dodaj(iter + " " + this.PI + " " + Math.abs(this.PI - this.prePI));
					this.prePI = this.PI;
				}
			}
			
		}
		catch(InterruptedException er) { }
		
	}

	
	public abstract void racunaj();
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
	}
	
	public void stani() {
		radi = false;
	}
	
	public void prekini() {
		interrupt();
	}
}
