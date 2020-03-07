package z11;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame {
	private Bara bara;
	private Oblak oblak;
	
	public Program() {
		super("Pljusak");
		setSize(400, 300);
		
		popuniProzor();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				bara.prekini();
				oblak.prekini();
				dispose();
			}
		});
		setVisible(true);
	}
	
	public void popuniProzor() {
		bara = new Bara();
		oblak = new Oblak(bara, 200, 500);
		
		Button kreni = new Button("Kreni");
		Button stani = new Button("Stani");
		
		kreni.addActionListener(e -> {
			oblak.kreni();
		});
		stani.addActionListener(e -> {
			oblak.pauza();
		});
		
		Panel p = new Panel();
		p.add(kreni); p.add(stani);
		p.setBackground(Color.gray);
		
		add(bara, "Center");
		add(p, "South");
	}
	
	public static void main(String[] args) {
		new Program();
	}
}
