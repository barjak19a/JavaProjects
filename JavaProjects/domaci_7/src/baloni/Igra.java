package baloni;

import java.awt.*;
import java.awt.event.*;

public class Igra extends Frame{
	private static final long serialVersionUID  = 0;
	private Scena s;
	private Luk l;
	
	public Igra() {
		super("Gadjanje balona");
		popuniProzor();
	}
	
	
	private void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				s.nit.interrupt();
				dispose();
			}
		});
		this.add(s = new Scena());
		s.dodaj(l = new Luk(20,20));
		
		Panel p = new Panel();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Button b;
		p1.add(b = new Button("Gore"));
		b.addActionListener(new Pomeranje());
		p1.add(b = new Button("Dole"));
		b.addActionListener(new Pomeranje());
		p1.add(b = new Button("Pali"));
		b.addActionListener(new novaStrela());
		p2.add(b = new Button("Balon"));
		b.addActionListener(new noviBalon());
		
		p.add(p1, "West");
		p.add(new Label());
		p.add(p2,"East");
		add(p, "South");
		
		setVisible(true);
	}
	
	private class Pomeranje implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(((Button)e.getSource()).getLabel()=="Gore") l.gore();
			else l.dole();
		}
	}
	
	private class novaStrela implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int x = l.x+10;
			int y = l.y+5;
			int v = 4;
			s.dodaj(new Strela(x,y,v));
		}
	}
	
	private class noviBalon implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int x, y, v;
			x = (int)(Math.random()*300+50);
			y = (int)(Math.random()*200);
			v = 2 + (int)(Math.random()*6);
			s.dodaj(new Balon(x, y, v,Color.GREEN, Color.RED));
		}
	}
	
	
	public static void main(String [] argv) {
		new Igra();
	}
	
}
