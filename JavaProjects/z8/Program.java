package z8;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame {
	private TextField xmin, xmax, ymin, ymax;
	private Button crtaj, prekini;
	private Kriva[] krive = new Kriva[3];
	private Platno platno = new Platno(-10, 10, -10, 10);
	
	public Program() {
		super("Spirale");
		setSize(300, 400);
		popuniProzor();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		setVisible(true);
	}
	
	private void popuniProzor() {
		krive[0] = new Kriva(platno, Color.red, new Spirala(1, 1, 2 * Math.PI / 3 * 0), 
				0, 5 * Math.PI, Math.PI / 100);
		krive[1] = new Kriva(platno, Color.blue, new Spirala(1, 1, 2 * Math.PI / 3 * 1), 
				0, 5 * Math.PI, Math.PI / 100);
		krive[2] = new Kriva(platno, Color.black, new Spirala(1, 1, 2 * Math.PI / 3 * 2), 
				0, 5 * Math.PI, Math.PI / 100);
		platno.dodaj(krive[0]);
		platno.dodaj(krive[1]);
		platno.dodaj(krive[2]);
		
		add(platno, "Center");
		
		Panel jug = new Panel(new GridLayout(2, 1));
		Panel p = new Panel();
		p.add(new Label("x", Label.RIGHT));
		xmin = new TextField("-10", 5);
		xmax = new TextField("10",  5);
		ymin = new TextField("-10", 5);
		ymax = new TextField("10",  5);
		p.add(xmin); p.add(xmax);
		p.add(new Label("y", Label.RIGHT));
		p.add(ymin); p.add(ymax);
		
		jug.add(p);
		
		crtaj = new Button("Crtaj");
		prekini = new Button("Prekini");
		
		crtaj.addActionListener(e -> {
			platno.prekiniSve();
			double x1, x2, y1, y2;
			try {
				x1 = Double.parseDouble(xmin.getText());
				x2 = Double.parseDouble(xmax.getText());
				y1 = Double.parseDouble(ymin.getText());
				y2 = Double.parseDouble(ymax.getText());
				platno.postavi(x1, x2, y1, y2);
				platno.crtajSve();
			} catch(NumberFormatException nfe) {}
		});
		
		prekini.addActionListener(e -> {
			platno.prekiniSve();
		});
		
		p = new Panel();
		p.add(crtaj); p.add(prekini);
		
		jug.add(p);
		
		add(jug, "South");
	}
	
	public static void main(String[] args) {
		new Program();
	}
}
