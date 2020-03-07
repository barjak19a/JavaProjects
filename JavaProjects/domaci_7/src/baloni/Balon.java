package baloni;

import java.awt.*;

public class Balon extends Figura{

	private int v;
	private Color c1, c2;
	private boolean gotov = false;
	
	public Balon(int _x, int _y, int _v, Color _c1, Color _c2) {
		super(_x, _y);
		v = _v;
		c1 = _c1;
		c2 = _c2;
	}
	public void sudar() {
		gotov = true;
	}
	
	public boolean gotov() {
		return gotov;
	}
	
	public void crtaj(Graphics g) {
		if(!gotov)g.setColor(c1);
		else g.setColor(c2);
		g.fillOval(x, y, 20, 20);
		g.setColor(Color.BLACK);
		g.drawLine(x+10, y+20, x+10, y+35);
		y-=v;
		if(y<0)y=400;
	}
}
