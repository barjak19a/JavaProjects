package z2;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame {
	private Linija lin;
	private Button kreni, stani;
	
	Program() {
		super("Gradski saobracaj");
		setBounds(200,200,400,400);
		dodajStvari();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < lin.brStanica(); i++)
					lin.Sprekini(i);
				for(int i = 0; i < lin.brVozila(); i++)
					lin.Vprekini(i);
				dispose();
			}
			
		});
		setVisible(true);
	}
	
	public void dodajStvari() {
		Panel sev = new Panel(new GridLayout(1, 2));
		sev.add(new Label("Stanice:"));
		sev.add(new Label("Vozila:"));
		sev.setBackground(Color.GRAY);
		
		add(sev, BorderLayout.NORTH);
		
		String[] imena = {"Alfa", "Beta", "Gama", "Delta", "Eta"};
		String[] oznake = {"V1", "V2"};
		lin = new Linija(imena, 500, 1000, oznake, 40, 1000, 2000, 4000);
		
		Panel cen = new Panel(new GridLayout(1, 2));
		cen.add(lin.getPSt());
		cen.add(lin.getPVz());
		
		add(cen, BorderLayout.CENTER);
		
		Panel sou = new Panel();
		sou.add(kreni = new Button("Kreni"));
		sou.add(stani = new Button("Stani"));
		sou.setBackground(Color.DARK_GRAY);
		
		kreni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < lin.brStanica(); i++)
					lin.Skreni(i);
				for(int i = 0; i < lin.brVozila(); i++)
					lin.Vkreni(i);
			}
		});
		
		stani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0; i < lin.brStanica(); i++)
					lin.Spauziraj(i);
				for(int i = 0; i < lin.brVozila(); i++)
					lin.Vpauziraj(i);
			}
		});
		
		add(sou, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new Program();
	}
}
