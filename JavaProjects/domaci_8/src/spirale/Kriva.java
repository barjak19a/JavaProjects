package spirale;

import java.awt.*;

public class Kriva extends Canvas {
	private static final long serialVersionUID = 0;
	Spirala s;
	private boolean prekini = false;
	private Color col;
	public Kriva(int a, int b, double c, Color _col) {
		s = new Spirala(a,b,c);
		col = _col;
		
	}
	
	public void paint(Graphics g) {
		prekini = false;
		int x1, x2;
		int y1, y2;
		g.setColor(col);
		x1 = s.x(0);
		y1 = s.y(0);
		for(double i=Math.PI/100; i<50; i+=Math.PI/100) {
			if(prekini) return;
			x2 =s.x(i);
			y2 = s.y(i);
			
			if(x11>x2 || x22<x2 || y11>y2 || y22<y2) continue;
			
			g.drawLine(200+x1*5, 200+y1*5, 200+x2*5, 200+y2*5);
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException err) { };
			x1 = x2;
			y1 =y2;
		}
	}
	
	private int x11,x22,y11,y22;
	
	public void set(int _x1, int _x2, int _y1, int _y2) {
		x11 = _x1;
		x22 = _x2;
		y11 = _y1;
		y22 = _y2;
	}
	
	public void prekini() {
		prekini = true;
	}
	
}
