package z1;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame implements ActionListener {
	private TextArea ta = new TextArea();
	private Prikazivac p = new Prikazivac(ta);
	private TextField iter, korak;
	private Checkbox ojler, krug;
	private Akter nit;
	
	Program() {
		super("Pi");
		setBounds(100, 100, 300, 300);
		dodajStvari();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if(nit != null) nit.interrupt();
				dispose();
			}
			
		});
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String komanda = e.getActionCommand();
		if(komanda.equals("Zavrsi")) dispose();
		if(komanda.equals("Kreni")) {
			int i = Integer.parseInt(iter.getText());
			int k = Integer.parseInt(korak.getText());
			if(ojler.getState()) {
				nit = new Ojler(p);
				nit.kreni(i, k);
			} else {
				nit = new Krug(p);
				nit.kreni(i, k);
			}
		}
		if(komanda.equals("Prekini")) {
			nit.interrupt();
		}
		
	}
	
	private void dodajStvari() {
		MenuBar traka = new MenuBar();
		Menu meni = new Menu("Komande");
		meni.add("Kreni");
		meni.add("Prekini");
		meni.add("Zavrsi");
		meni.addActionListener(this);
		traka.add(meni);
		setMenuBar(traka);
		
		add(ta, BorderLayout.CENTER);
		Panel jug = new Panel(new GridLayout(2, 4));
		jug.add(new Label("iter:", Label.RIGHT));
		jug.add(iter = new TextField());
		jug.add(new Label("korak:", Label.RIGHT));
		jug.add(korak = new TextField());
		
		CheckboxGroup grupa = new CheckboxGroup();
		jug.add(new Label(""));
		jug.add(ojler = new Checkbox("Ojler", true, grupa));
		jug.add(krug = new Checkbox("Krug", false, grupa));
		jug.add(new Label(""));
		
		add(jug, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new Program();
	}
}
