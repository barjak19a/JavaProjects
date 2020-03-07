package baloni;

import java.awt.*;

public class Strela extends Figura{
	
	private int v;
	
	public Strela(int _x, int _y, int _v) {
		super(_x, _y);
		v = _v;
	}
	
	
	public void crtaj(Graphics g) {
		g.drawLine(x, y, x+10, y);
		x+=v;
	}
	

}
