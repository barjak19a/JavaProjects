package gsp;

import java.awt.Label;

public class Vozilo extends Akter{
	
	private int n;
	private int br;
	private Stanica[] niz;
	private int etapa = 0;
	private String oznaka;
	private int smer;
	private long T;
	public Vozilo(Label _l, long _minT, long _maxT, int kap,Stanica[] _niz, String _oznaka, long _T) {
		super(_l, _minT, _maxT);
		niz = _niz;
		n = kap;
		T = _T;
		br = 0;
		smer = 1;
		oznaka = _oznaka;
		etapa = 1;
		l.setText(oznaka + ":" + br + ", vozi se u " + niz[1].ime());
		start();
	}
	
	public void radnja() throws InterruptedException{
		int napolje = (int)(br * Math.random());
		br -=napolje;
		Stanica s = niz[etapa];
		etapa+=smer;
		if(etapa==0 || etapa==niz.length-1) smer*=-1;
		int unutra = s.dohv();
		if(unutra>n-br) {
			s.uzmi(n-br);
			br = n;
		}
		else {
			s.uzmi(unutra);
			br+=unutra;
		}
		l.setText(oznaka + ": " + br + " stoji u " + s.ime()); 
		sleep(T);
		l.setText(oznaka + ": " + br + " vozi se u " + niz[etapa].ime());
	}
	
	public String oznaka() {
		return oznaka;
	}
}
