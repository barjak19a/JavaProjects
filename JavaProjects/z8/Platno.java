package z8;

import java.awt.*;
import java.util.*;

public class Platno extends Canvas {
	private ArrayList<Grafik> lista = new ArrayList<Grafik>();
	private double xmin, xmax, ymin, ymax;
	
	public Platno(double xmin, double xmax, double ymin, double ymax) {
		super();
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
	
	public void postavi(double xmin, double xmax, double ymin, double ymax) {
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
	
	public int a(double x) {
		return (int) ((x - xmin) / (xmax - xmin) * (getWidth() - 1));
	}
	
	public int b(double y) {
		return (int) ((ymax - y) / (ymax - ymin) * (getHeight() - 1));
	}
	
	public void dodaj(Grafik g) {
		lista.add(g);
		g.crtaj(getGraphics());
	}
	
	public void crtajSve() {
		repaint();
		for(Grafik g: lista)
			g.crtaj(getGraphics());
	}
	
	public void prekiniSve() {
		for(Grafik g: lista)
			g.prekini();
	}
	
}
