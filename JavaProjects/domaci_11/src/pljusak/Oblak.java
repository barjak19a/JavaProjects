package pljusak;

public class Oblak extends Thread{

	private Povrs p;
	private long minT, maxT;
	private boolean radi = true;
	
	public Oblak(Povrs _p, long _minT, long _maxT) {
		p = _p;
		minT = _minT;
		maxT = _maxT;
		start();
	}
	
	public void run() {
		try {
			
			while(!interrupted()) {
				
				synchronized(this) {
					while(!radi)wait();
				}
				
				sleep(minT + (long)(Math.random()*(maxT-minT)));
				
				p.registruj(new Kap((int)(Math.random()*p.getWidth()),(int)(Math.random()*p.getHeight()), Math.random()*6+2));
			}
			
		}
		catch(InterruptedException g) { }
	}
	
	public void prekini() {
		interrupt();
	}
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
	}
	
	public void stani() {
		radi = false;
	}
}
