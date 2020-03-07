package baloni;

import java.awt.*;

public abstract class Figura {

	protected int x, y;
	
	public Figura(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	
	public abstract void crtaj(Graphics g);
}
