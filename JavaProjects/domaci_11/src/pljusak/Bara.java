package pljusak;

import java.awt.*;

public class Bara extends Povrs implements Runnable{

	private static final long serialVersionUID = 0;
	
	Thread nit = new Thread(this);
	
	public Bara() {
	
		nit.start();
	}
	
	private class el{
		
		public el next;
		public Talas t;
		
		public el(Talas _t) {
			t = _t;
			if(first==null) first = last = this;
			else last = last.next = this;
		}
	}
	
	private el first, last;
	private boolean radi = true;
	
	public void run() {
		try {
			
			while(!Thread.interrupted()) {
		
				synchronized(this) {
					while(!radi)wait();
				}
				
				while(first!=null && first.t.isAlive()==false)first = first.next;
				Thread.sleep(40);
				this.repaint();
			}
		}
		catch(InterruptedException err) { }
	}
	
	
	public void paint(Graphics g) {
		el temp = first;
		while(temp!=null) {
			temp.t.crtaj(g);
			temp = temp.next;
		}
	}
	
	public void registruj(Kap t) {
		new el(new Talas(t));
	}
	
	public synchronized void kreni() {
		radi = true;
		notifyAll();
		el temp = first;
		while(temp!=null) {
			temp.t.kreni();
			temp = temp.next;
		}
	}
	
	public void stani() {
		radi = false;
		el temp = first;
		while(temp!=null) {
			temp.t.stani();
			temp = temp.next;
		}
	}
	

	public void prekini() {
		nit.interrupt();
		el temp = first;
		while(temp!=null) {
			temp.t.prekid();
			temp = temp.next;
		}
	}
}


