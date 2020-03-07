package z11;

public class Oblak extends Thread {
	private Povrs povrs;
	private long tmin, tmax;
	private boolean radi = false;
	
	public Oblak(Povrs povrs, long tmin, long tmax) {
		super();
		this.povrs = povrs;
		this.tmin = tmin;
		this.tmax = tmax;
		start();
	}
	
	public synchronized void kreni() {
		radi = true;
		notify();
	}
	
	public synchronized void pauza() {
		radi = false;
	}
	
	public void prekini() {
		interrupt();
	}
	
	public void run() {
		try {
			while(!interrupted()) {
				while(!radi) synchronized(this) {wait();}
				
				sleep((long) (tmin + Math.random() * (tmax - tmin)));
				
				povrs.pad(new Kap(Math.random() * povrs.getWidth(),
						Math.random() * povrs.getHeight(),
						2 + Math.random() * 7));
			}
		} catch(InterruptedException e) {}
	}
	
	
}
