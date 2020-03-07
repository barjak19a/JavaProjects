package z11;

import java.util.*;

public class Bara extends Povrs implements Runnable {
	private ArrayList<Talas> lista = new ArrayList<Talas>();
	private Thread nit;
	
	public Bara() {
		nit = new Thread(this);
		nit.start();
	}
	
	public void prekini() {
		for(Talas t: lista) {
			t.prekini();
		}
		nit.interrupt();
		lista.clear();
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(40);
				for(int i = 0; i < lista.size(); i++) {
					Talas t = lista.get(i);
					if(t.isAlive()) {
						//t.crtaj(getGraphics());
					} else {
						lista.remove(i);
					}
				}
				repaint();
			}
		} catch(InterruptedException e) {}
		
	}

	@Override
	public void pad(Kap k) {
		lista.add(new Talas(this, k.getX(), k.getY(), 0.05*k.getQ(), 0.05/k.getQ()));
	}

}
