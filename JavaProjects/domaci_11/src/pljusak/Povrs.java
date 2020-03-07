package pljusak;

import java.awt.*;

public abstract class Povrs extends Canvas{

	private static final long serialVersionUID = 0;
	
	public int height() {
		return this.getHeight();
	}
	
	public int width() {
		return this.getWidth();
	}
	
	public abstract void registruj(Kap k);
}
