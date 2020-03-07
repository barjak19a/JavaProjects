package gsp;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{

	private static final long serialVersionUID = 0;
	private Stanica s1,s2,s3,s4,s5;
	private Vozilo v1, v2;
	public Program() {
		super("Gradski prevoz");
		popuniProzor();
	}
	
	public void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				s1.unisti();
				s2.unisti();
				s3.unisti();
				s4.unisti();
				s5.unisti();
				v1.unisti();
				v2.unisti();
				dispose();
			}
		});
		
		
		
		Label l1,l2,l3,l4,l5;
		l1 = new Label();
		l2 = new Label();
		l3 = new Label();
		l4 = new Label();
		l5 = new Label();
		
		s1 = new Stanica(l1,500,1000,"Alfa");
		s2 = new Stanica(l2,500,1000,"Beta");
		s3 = new Stanica(l3,500,1000,"Gama");
		s4 = new Stanica(l4,500,1000,"Delta");
		s5 = new Stanica(l5,500,1000,"Eta");
		
		Label ll1 = new Label();
		Label ll2 = new Label();
		Stanica[] s = {s1,s2,s3,s4,s5};
		
		v1 = new Vozilo(ll1, 2000, 4000,5, s, "V1",1000);
		v2 = new Vozilo(ll2, 2000, 4000,5, s, "V2",1000);
		
		
		this.setLayout(new GridLayout(7,2));
		
		Label l;
		add(l = new Label("Stanice: "));
		l.setBackground(Color.GRAY);
		add(l = new Label("Vozila: "));
		l.setBackground(Color.GRAY);
		Panel p = new Panel();
		
		this.add(l1);
		this.add(new Label());
		this.add(l2);
		this.add(ll1);
		this.add(l3);
		this.add(new Label());
		this.add(l4);
		this.add(ll2);
		this.add(l5);
		this.add(new Label());
		this.add(p);
		Button b;
		p.add(b = new Button("Kreni"));
		b.addActionListener(new Osluskivac());
		p.setBackground(Color.GRAY);
		p = new Panel();
		this.add(p);
		p.add(b = new Button("Stani"));
		b.addActionListener(new Osluskivac());
		p.setBackground(Color.GRAY);
		
		setVisible(true);
	}

	private class Osluskivac implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String comand = ((Button)e.getSource()).getLabel();
			if(comand=="Kreni") {
				s1.kreni();
				s2.kreni();
				s3.kreni();
				s4.kreni();
				s5.kreni();
				v1.kreni();
				v2.kreni();
			}
			else {
				s1.stani();
				s2.stani();
				s3.stani();
				s4.stani();
				s5.stani();
				v1.stani();
				v2.stani();
			}
		}
	}
	public static void main(String [] argv) {
		new Program();
	}
}
