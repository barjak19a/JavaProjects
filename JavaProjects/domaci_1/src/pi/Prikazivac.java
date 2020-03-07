package pi;

import java.awt.*;

public class Prikazivac {

	private TextArea comp;
	
	public Prikazivac(TextArea _comp) {
		comp = _comp;
	}
	
	public void postavi(String s) {
		comp.setText(s);
	}
	
	public void dodaj(String s) {
		String ss = comp.getText();
		ss += "\n" + s;
		comp.setText(ss);
	}
}
