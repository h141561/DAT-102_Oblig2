package oving4.oppg2;

import oving4.oppg1.MengdeADT;
import oving4.oppg1.TabellMengde;

public class Datakontakt {
	private static MengdeADT<Medlem> medlemsTabell;
	
	public Datakontakt() {
		medlemsTabell = new TabellMengde<Medlem>();
	}
	
	public void printAlle() {
		for(Medlem i : medlemsTabell)
		{
			System.out.println(i.toString());
		}
	}
	public void leggTil(Medlem med) {
		medlemsTabell.leggTil(med);
	}
}

