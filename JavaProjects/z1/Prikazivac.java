package z1;

import java.awt.*;
import java.awt.event.*;

public class Prikazivac {
	private TextArea ta;
	private String tekst;
	
	Prikazivac(TextArea t) {
		ta = t;
	}
	
	void postavi(String tekst) {
		this.tekst = tekst;
		ta.setText(this.tekst);
	}
	
	void dodaj(String tekst) {
		this.tekst += tekst;
		ta.setText(this.tekst);
	}
}
