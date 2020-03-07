package uredjivanje;

public class Izbor implements Uredjivac {

protected boolean prekinut = false;
	
	
	public int[] uredi(int[] niz, boolean raste) {
		Uporedjivac u;
		prekinut = false;
		if(raste==true) u = new Vece();
		else u = new Manje();
		
		
		for(int i=0; i<niz.length; i++) {
			int x = niz[i];
			int pos = i;
			for(int j=i+1; j<niz.length; j++) {
				if(prekinut) return niz;
				if(u.uporedi(x, niz[j])) {
					x = niz[j];
					pos = j;
				}
			}
			int t = niz[i];
			niz[i] = niz[pos];
			niz[pos] = t;
		}
		
		return niz;
	}
	
	public void prekini() {
		prekinut = true;
	}
}
