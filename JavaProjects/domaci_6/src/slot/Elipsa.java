package slot;

import java.awt.*;

public class Elipsa implements Simbol{

private int x,y,a,b;
	
	public Elipsa(int _x, int _y, int _a, int _b) {
		x = _x;
		y = _y;
		a = _a;
		b = _b;
	}
	
	public void crtaj(Graphics g) {
		g.drawOval(x, y, a, b);
	}
}
