package slot;


public class Galerija{

	private Simbol[] simboli;
	private int br;
	
	public Galerija(int n) {
		simboli = new Simbol[n];
	}
	
	public void dodaj(Simbol s) {
		simboli[br] = s;
		br++;
	}
	
	public Simbol uzmi() {
		return simboli[(int)(Math.random()*br)];
	}
}
