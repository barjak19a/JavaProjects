package z2;

import java.awt.*;
import java.awt.event.*;

public class Linija {
	private Stanica[] stanice;
	private Vozilo[] vozila;
	private Panel pst, pvz;
	
	Linija(String[] imena, long tminp, long tmaxp, String[] oznaka, int kap, long tstan, long tminv, long tmaxv) {
		stanice = new Stanica[imena.length];
		Label tmp;
		pst = new Panel(new GridLayout(imena.length, 1));
		for(int i = 0; i < stanice.length; i++) {
			stanice[i] = new Stanica(tmp = new Label(), imena[i], tminp, tmaxp);
			pst.add(tmp);
		}
		vozila = new Vozilo[oznaka.length];
		pvz = new Panel(new GridLayout(oznaka.length, 1));
		for(int i = 0; i < oznaka.length; i++) {
			vozila[i] = new Vozilo(tmp = new Label(), tminv, tmaxv, tstan, kap, oznaka[i], this);
			pvz.add(tmp);
		}
	}
	
	public Panel getPSt() {return pst;}
	public Panel getPVz() {return pvz;}
	public int brVozila() {return vozila.length;}
	public int brStanica() {return stanice.length;}
	public Stanica stanica(int i) {
		return stanice[i];
	}
	
	public void Skreni(int i) {
		stanice[i].kreni();
	}
	
	public void Spauziraj(int i) {
		stanice[i].pauziraj();
	}
	
	public void Sprekini(int i) {
		stanice[i].interrupt();
	}
	
	public void Vkreni(int i) {
		vozila[i].kreni();
	}
	
	public void Vpauziraj(int i) {
		vozila[i].pauziraj();
	}
	
	public void Vprekini(int i) {
		vozila[i].interrupt();
	}	
}
