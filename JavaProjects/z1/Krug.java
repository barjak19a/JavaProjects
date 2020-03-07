package z1;

public class Krug extends Akter {
	Krug(Prikazivac p) {
		super(p);
	}

	@Override
	public void racunaj() {
		p.postavi("");
		double sum = 0;
		double pret = 0;
		int m = 0;
		for(int k = 1; k <= iter; k++) {
			double x = Math.random();
			double y = Math.random();
			double d = Math.sqrt(x*x + y*y);
			if(d <= 1) m++;
			if(k % korak == 0 || k == iter) {
				double rez = 4.0 * m / k;
				p.dodaj(k + "\t" + rez + "\t" + Math.abs(pret - rez) + "\n");
				pret = rez;
			}
		}
	}
	
	
}
