package z1;


public class Ojler extends Akter {
	Ojler(Prikazivac p) {
		super(p);
	}

	@Override
	public void racunaj() {
		p.postavi("");
		double sum = 0;
		double pret = 0;
		for(int k = 1; k <= iter; k++) {
			sum += 1.0/(k*k);
			if(k % korak == 0 || k == iter) {
				double rez = Math.sqrt(sum * 6);
				p.dodaj(k + "\t" + rez + "\t" + Math.abs(pret - rez) + "\n");
				pret = rez;
			}
		}
	}
}
