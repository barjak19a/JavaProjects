package spirale;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{
	private static final long serialVersionUID = 0;
	private Kriva k1, k2, k3;
	private int x1, x2,y1,y2;
	private TextField tf1, tf2, tf3, tf4;
	public Program() {
		super("Spirala");
		k1 = new Kriva(1,1,0, Color.BLUE);
		k2 = new Kriva(1,1,2*Math.PI/3, Color.RED);
		k3 = new Kriva(1,1,4*Math.PI/3, Color.BLACK);
		popuniProzor();
		
	}
	
	
	public void paint(Graphics g) {
		k1.paint(g);
		k2.paint(g);
		k3.paint(g);
	}
	
	private void popuniProzor() {
		setBounds(100,100,400,400);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		Panel p = new Panel();
		Panel p1 = new Panel();
		p1.setBackground(Color.GRAY);
		p1.add(new Label("x"));
		p1.add(tf1 = new TextField("-10"));
		p1.add(tf2 = new TextField("10"));
		p1.add(new Label("y"));
		p1.add(tf3 = new TextField("-10"));
		p1.add(tf4= new TextField("10"));
		
		tf1.addTextListener(new Tekst());
		tf2.addTextListener(new Tekst());
		tf3.addTextListener(new Tekst());
		tf4.addTextListener(new Tekst());
		
		
		p.setLayout(new GridLayout(2,1));
		p.add(p1);
		
		Panel p2 = new Panel();
		Button b;
		p2.add(b = new Button("Crtaj"));
		b.addActionListener(new Dugme());
		p2.add(b = new Button("Prekini"));
		b.addActionListener(new Dugme());
		p2.setBackground(Color.GRAY);
		p.add(p2);
		
		add(p, "South");
		
		setVisible(true);
	}
	
	private class Tekst implements TextListener{
		@Override
		public void textValueChanged(TextEvent e) {
			try {
			x1 = Integer.parseInt(tf1.getText());
			x2 = Integer.parseInt(tf2.getText());
			y1 = Integer.parseInt(tf3.getText());
			y2 = Integer.parseInt(tf4.getText());
			
			k1.set(x1,x2,y1,y2);
			k2.set(x1,x2,y1,y2);
			k3.set(x1,x2,y1,y2);
			}
			catch(NumberFormatException err) { }
		}
	}
	
	private class Dugme implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = ((Button)e.getSource()).getLabel();
			if(command=="Crtaj") {
				Program.super.repaint();
			}
			else {
				k1.prekini();
				k2.prekini();
				k3.prekini();
			}
		}
	}
	
	public static void main(String [] argv) {
		new Program();
	}
	
	
}
