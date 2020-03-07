package uredjivanje;

public class Vece implements  Uporedjivac{

	@Override
	public boolean uporedi(int a, int b) {
		return a>b;
	}
}
