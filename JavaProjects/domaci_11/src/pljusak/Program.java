package pljusak;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{
	
	private static final long serialVersionUID = 0;
	private Bara bara;
	private Oblak oblak;
	
	public Program() {
		super("Pljusak");
		popuniProzor();
	}
	
	public void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				oblak.prekini();
				bara.prekini();
				dispose();
			}
		});
		this.add(bara = new Bara());
		oblak = new Oblak(bara,500,1000);
		
		
		Panel p = new Panel();
		this.add(p, "South");
		Button b;
		p.add(b = new Button("Kreni"));
		b.addActionListener(new Dugmad());
		p.add(b = new Button("Stani"));
		b.addActionListener(new Dugmad());
		p.setBackground(Color.GRAY);
		setVisible(true);
	}
	
	private class Dugmad implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = ((Button)e.getSource()).getLabel();
			if(s=="Kreni") {
				bara.kreni();
				oblak.kreni();
			}
			else {
				bara.stani();
				oblak.stani();
			}
		}
	}
	public static void main(String [] argv) {
		new Program();
	}
}
