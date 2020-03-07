package z8;

import java.awt.*;

public class Kriva extends Grafik implements Runnable {
	private Platno platno;
	private Color boja;
	private double pmin, pmax, dp;
	private Thread nit = null;
	private Funkcija f;
	
	public Kriva(Platno platno, Color boja, Funkcija f, double pmin, double pmax, double dp) {
		super();
		this.platno = platno;
		this.boja = boja;
		this.f = f;
		this.pmin = pmin;
		this.pmax = pmax;
		this.dp = dp;
		//nit.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			int x0, y0, x1, y1;
			x0 = platno.a(f.x(pmin));
			y0 = platno.b(f.y(pmin));
			for(double p = pmin+dp; p <= pmax && !Thread.interrupted(); p += dp) {
				x1 = platno.a(f.x(p));
				y1 = platno.b(f.y(p));
				Graphics g = platno.getGraphics();
				if(g != null) {
					g.setColor(boja);
					g.drawLine(x0, y0, x1, y1);
				}
				x0 = x1;
				y0 = y1;
				Thread.sleep(5);
			}
		} catch(InterruptedException e) {}
		nit = null;
	}
	@Override
	public void crtaj(Graphics g) {
		// TODO Auto-generated method stub
		if(nit != null) synchronized(nit) {
			nit.interrupt();
			try {
				nit.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		nit = new Thread(this);
		nit.start();
	}
	@Override
	public void prekini() {
		// TODO Auto-generated method stub
		if(nit != null)
			nit.interrupt();
	}
}
