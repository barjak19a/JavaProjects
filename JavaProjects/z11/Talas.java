package z11;

import java.awt.*;

public class Talas extends Thread implements Prikaziva {
	private Bara bara;
	private double x, y;
	private double dr, db;
	private double radius = 0;
	float r = 0, g = 0, b = 0;
	
	public Talas(Bara bara, double x, double y, double dr, double db) {
		super();
		this.bara = bara;
		this.x = x;
		this.y = y;
		this.dr = dr;
		this.db = db;
		start();
	}

	public void run() {
		try {
			while(!interrupted()) {
				Graphics gr = bara.getGraphics();
				while(r <= 1) {
					sleep(40);
					crtaj(gr);
					r += db; g += db; b += db;
					radius += dr;
				}
				break;
			}
		} catch(InterruptedException e) {}
		
	}
	
	public void prekini() {
		interrupt();
	}
	
	
	@Override
	public void crtaj(Graphics gr) {
		gr.setColor(new Color(r, g, b));
		gr.drawOval((int)x, (int)y, (int)radius*2, (int)radius*2);		
	}
	
}
