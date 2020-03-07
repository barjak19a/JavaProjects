package baloni;

import java.awt.*;

public class Luk extends Figura{

	public Luk(int _x, int _y) {
		super(_x, _y);
	}
	
	
	public void crtaj(Graphics g) {
		g.drawLine(x, y, x, y+10);
		g.drawLine(x, y, x+10, y+5);
		g.drawLine(x, y+10, x+10, y+5);
	}
	
	public void gore() {
		y-=5;
	}
	
	public void dole() {
		y+=5;
	}
}
