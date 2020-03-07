package pi;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{

	private static final long serialVersionUID = 0;
	private TextArea ta;
	private int iter = 0;
	private Akter a;
	private TextField tf1;
	private Checkbox rb1;
	
	public Program() {
		super("PI");
		popuniProzor();
	}
	
	private void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		MenuBar mb = new MenuBar();
		this.setMenuBar(mb = new MenuBar());
		Menu m;
		mb.add(m = new Menu("Komande"));
		MenuItem mi;
		m.add(mi = new MenuItem("Kreni"));
		mi.addActionListener(new Bar());
		m.add(mi = new MenuItem("Prekini"));
		mi.addActionListener(new Bar());
		m.add(mi = new MenuItem("Zavrsi"));
		mi.addActionListener(new Bar());
		
		Panel p = new Panel();
		
		p.setLayout(new GridLayout(2,1));
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		
		
		p1.add(new Label("iter:"));
		p1.add(tf1 = new TextField("100"));
		tf1.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent te) {
				try {
					iter = 0;
				}
				catch(NumberFormatException err) {} 
			}
		});
		p1.add(new Label("korak:"));
		p1.add(tf1 = new TextField("100"));
		
		CheckboxGroup g = new CheckboxGroup();
		p2.add(rb1 = new Checkbox("Ojler", g, false));
		p2.add(new Checkbox("Krug", g, true));
		
		p.add(p1);
		p.add(p2);
		
		
		this.add(ta = new TextArea(),"Center");
		this.add(p, "South");
		a = new Krug(ta);
		
		setVisible(true);
	}
	
	private class Bar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((MenuItem)e.getSource()).getLabel();
			if(command=="Kreni") {
				a.prekini();
				if(rb1.getState()) a = new Ojler(ta);
				else a = new Krug(ta);
				int korak = Integer.parseInt(tf1.getText());
				
				a.setIter(iter+korak);
				iter+=korak;
				a.kreni();
			}
			else if(command == "Prekini"){
				a.stani();
			}
			else {
				a.prekini();
				dispose();
			}
		}
	}
	
	public static void main(String[] argv) {
		new Program();
	}
}
