package baloni;

import java.awt.*;

public class Scena extends Canvas implements Runnable{

	Thread nit = new Thread(this);
	
	public Scena() {
		first = last = null;
		nit.start();
	}
	
	private class el{
		el next;
		Figura x;
		
		public el(Figura _x) {
			x = _x;
			if(first==null) first = last = this;
			else last = last.next = this;
		}
	}
	
	private el first, last;
	
	public void run() {
	
		try {
			while(!Thread.interrupted()) {

				el temp = first;
				while(temp!=null) {
					if(temp.x instanceof Strela) {
						
						el p = temp.next;
						System.out.println(temp.x);
						while(p!=null) {
							if(p.x instanceof Balon) {
									int xb, yb;
									int xs, ys;
									
									xb = p.x.x();
									yb = p.x.y();
									
									xs = temp.x.x();
									ys = temp.x.y();
									
									System.out.println(xs + " " + ys + "/" + xb + " " + yb);
								}
							
							p = p.next;
						}
					}
					temp = temp.next;
				}
				
				Thread.sleep(40);
				repaint();
				
				
				
				temp = first;
				el pre = null;
				while(temp!=null) {
					if(temp.x.x()>500 || ((temp.x instanceof Balon) && ((Balon)temp.x).gotov())) {
						System.out.println("Brise," + temp.x);
						pre.next = temp.next;
						temp = temp.next;
					}
					else {
						pre = temp;
						temp = temp.next;
					}
					
					if(temp==null) last = pre;
				}
			}
		}
		catch(InterruptedException g) { }
	}
	
	public void dodaj(Figura f) {
		new el(f);
	}
	
	public void paint(Graphics g) {
		el temp = first;
		while(temp!=null) {
			temp.x.crtaj(g);
			temp = temp.next;
		}
	}
	
	public void izbaci(Figura f) {
		el temp = first;
		el pre = null;
		while(temp!=null) {
			if(temp.x == f) {
				
				if(pre==null) {
					first = temp.next;
					if(first==null) last = null;
				}
				else {
					pre.next = temp.next; 
				}
				return;
			}
			pre = temp;
			temp = temp.next;
		}
	}
	
	public Figura dohvati(int ind) {
		el temp = first;
		while(temp!=null && ind>0) {
			ind--;
			temp = temp.next;
		}
		return temp.x;
	}
}

