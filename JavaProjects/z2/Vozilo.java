package z2;

import java.awt.*;
import java.awt.event.*;

public class Vozilo extends Akter {
	private String oznaka;
	private int kapacitet, putnici;
	private long tmin, tmax;
	private long fiks;
	private Stanica sled;
	private Linija lin;
	private boolean napred = true;
	private int ind = 0;
	private String glagol;
	
	Vozilo(Label l, long min, long max, long f, int kap, String oznaka, Linija lin) {
		super(l);
		tmin = min;
		tmax = max;
		fiks = f;
		kapacitet = kap;
		this.oznaka = oznaka;
		this.lin = lin;
		sled = lin.stanica(0);
		start();
	}

	@Override
	public void radnja() throws InterruptedException {
		// TODO Auto-generated method stub
		glagol = "vozi ka";
		l.setText(toString());
		sleep((long) (tmin + Math.random()*(tmax - tmin)));
		glagol = "stoji u";
		l.setText(toString());
		sleep(fiks);
		int izlazi = (int) (Math.random() * putnici);
		putnici -= izlazi;
		int max = kapacitet - putnici;
		if(sled.brPutnika() >= max) {
			putnici = kapacitet;
			sled.smanji(max);
		} else {
			putnici += sled.brPutnika();
			sled.smanji(sled.brPutnika());
		}
		if(napred) {
			if(ind < lin.brStanica()-1) {
				ind++;
				sled = lin.stanica(ind);
			} else {
				napred = false;
				ind--;
				sled = lin.stanica(ind);
			}
		} else {
			if(ind > 0) {
				ind--;
				sled = lin.stanica(ind);
			} else {
				napred = true;
				ind++;
				sled = lin.stanica(ind);
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return oznaka + " " + glagol + " " + sled.ime() + " " + putnici;
	}

}
