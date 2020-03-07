package uredjivanje;

import java.awt.*;
import java.awt.event.*;

public class Program extends Frame{
	private static final long serialVersionUID = 0;
	private Izbor izbor;
	private TextArea ta;
	private boolean raste = true;
	private int n = 100;
	private int[] niz;
	private Izbor ure;
	
	public Program() {
		super("Uredjivac");
		ure = new Izbor();
		izbor = new Izbor();
		popuniProzor();
	}
	
	private void popuniProzor() {
		setBounds(100,100,700,500);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				izbor.prekini();
				dispose();
			}
		});
		
		Panel p = new Panel();
		CheckboxGroup cb = new CheckboxGroup();
		Checkbox cbg;
		p.setLayout(new GridLayout(2,4));
		p.add(new Label("duz"));
		TextField tf;
		p.add(tf = new TextField("100"));
		tf.addTextListener(new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				TextField tf =(TextField) e.getSource();
				n = Integer.parseInt(tf.getText());
			}
		});
		p.add(cbg = new Checkbox("raste", cb, true));
		cbg.addFocusListener(new Radio());
		p.add(cbg = new Checkbox("opada", cb, false));
		cbg.addFocusListener(new Radio());
		Panel pp = new Panel();
		Button b;
		pp.add(b = new Button("Napuni"));
		b.addActionListener(new Napuni());
		pp.add(b = new Button("Uredi"));
		b.addActionListener(new Uredi());
		pp.add(b = new Button("Prekini"));
		b.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p.add(new Label());
		p.add(pp);
		p.add(new Label());
		this.add(p, "South");
		this.add(ta = new TextArea(), "Center");
		setVisible(true);
	}
	
	private class Radio implements FocusListener{
		@Override
		public void focusGained(FocusEvent e) {
			String s = ((Checkbox)e.getSource()).getLabel();
			if(s=="raste") raste = true;
			else raste = false;
		}
		public void focusLost(FocusEvent e) {
		}
	}
	
	private class Uredi implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(niz==null) return;
			niz = ure.uredi(niz, raste);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				if(i%40==0) sb.append("\n");
				sb.append(niz[i] + " "); 
			}
			ta.setText(sb.toString());
			ta.setVisible(true);
		}
	}
	
	private class Napuni implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			niz = new int[n];
			for(int i=0; i<n; i++)
				niz[i] = (int)(Math.random()*n);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				if(i%40==0) sb.append("\n");
				sb.append(niz[i] + " "); 
			}
			ta.setText(sb.toString());
		}
 	}
	
	public static void main(String [] argv) {
		new Program();
	}
}
