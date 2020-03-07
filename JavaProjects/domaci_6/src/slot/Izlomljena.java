package slot;

import java.awt.Graphics;

public class Izlomljena implements Simbol{
	
private int x,y,a,b;
	
	public Izlomljena(int _x, int _y, int _a, int _b) {
		x = _x;
		y = _y;
		a = _a;
		b = _b;
	}
	
	public void crtaj(Graphics g) {
		
		g.drawLine(x, y, a, b);
		g.drawLine(x, b, a, y);
		g.drawLine(x,b,a,b);
	}
}
