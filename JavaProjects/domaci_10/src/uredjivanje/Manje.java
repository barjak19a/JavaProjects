package uredjivanje;

public class Manje implements  Uporedjivac{

	@Override
	public boolean uporedi(int a, int b) {
		return a<b;
	}
}
