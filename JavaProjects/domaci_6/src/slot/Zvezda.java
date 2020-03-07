package slot;

import java.awt.*;

public class Zvezda implements Simbol{

	private int x,y,a,b;
	
	public Zvezda(int _x, int _y, int _a, int _b) {
		x = _x;
		y = _y;
		a = _a;
		b = _b;
	}
	
	public void crtaj(Graphics g) {
		
		g.drawLine(x, y, a, b);
		g.drawLine(x, b, a, y);
		g.drawLine((x+a)/2, y, (x+a)/2, b);
		g.drawLine(x, (y+b)/2, a, (y+b)/2);
	}
}
