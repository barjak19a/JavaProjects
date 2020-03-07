package slot;

import java.awt.*;

public class Masina extends Panel{

	private static final long serialVersionUID  = 0;
	private Prikazivac[] niz;
	private int br;
	private Label l;
	private int novac;
	
	public Masina(int n, Label _l) {
		niz = new Prikazivac[n];
		l = _l;
		novac = Integer.parseInt(l.getText());
		br = 0;
	}
	
	public void dodaj(Prikazivac p) {
		add(p);
		niz[br] = p;
		br++;
	}
	
	
	
	public void kreni() {
		if(novac>=100) {
			novac-=100;
			l.setText(novac + "");
		}
		else {
			l.setText("Nemate vise novca");
			return;
		}
		for(int i=0; i<br; i++)
			niz[i].kreni();
	}
	
	public void stani() {
		for(int i=0; i<br; i++)
			niz[i].stani();
		
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException g) { }
		
		
		int[] sim = new int[br];
		for(int i=0; i<br; i++) {
			if(niz[i].simbol() instanceof Elipsa) sim[i] = 0;
			else if(niz[i].simbol() instanceof Izlomljena) sim[i] = 1;
			else if(niz[i].simbol() instanceof Zvezda) sim[i] = 2;
		}
		
		int max = 0;
		for(int i=0; i<br; i++) {
			int tre = 0;
			for(int j=0; j<br; j++) 
				if(sim[i]==sim[j]) tre++;
				
			if(max<tre) max = tre;
		}
		
		System.out.println(max);
		if(max==2) novac +=100;
		else if(max==3) novac += 300;

		l.setText(novac+"");
		
	}
	
	public void prekini() {
		for(int i=0; i<br; i++)
			niz[i].prekini();
	}
	
}
