package slot;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{
	private static final long serialVersionUID = 0;
	private Masina m;
	public Program() {
		super("Slot masina");
		popuniProzor();
	}
	
	public void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		
		
		Panel p = new Panel();
		Prikazivac c1, c2, c3;
		Label l;
		p.add(l = new Label("1000"));
		l.setFont(new Font("Serif",Font.BOLD, 32));
		add(p, "North");
		
		m = new Masina(3,l);
		m.setBackground(Color.gray);
		
		m.dodaj(c1 = new Prikazivac(Color.BLUE,null));
		c1.setBackground(Color.WHITE);
		c1.setBounds(0,0,100, 100);
		
		m.dodaj(c2 = new Prikazivac(Color.RED, null));
		c2.setBackground(Color.white);
		c2.setBounds(0, 0, 100, 100);
		
		
		m.dodaj(c3 = new Prikazivac(Color.GREEN, null));
		c3.setBackground(Color.white);
		c3.setBounds(0, 0, 100, 100);
	
		
		add(m);
		
		p = new Panel();
		add(p,"South");
		Button b;
		p.add(b = new Button("Kreni"));
		b.addActionListener(new Dugmad());
		p.add(b = new Button("Stani"));
		b.addActionListener(new Dugmad());
		p.add(b = new Button("Brisi"));
		b.addActionListener(new Dugmad());
		
		setVisible(true);
	}
	
	private class Dugmad implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((Button)e.getSource()).getLabel();
			if(command=="Kreni") m.kreni();
			else if(command=="Stani")m.stani();
			else m.prekini();
		}
	}
	
	public static void main(String[] argv) {
		new Program();
	}
}
