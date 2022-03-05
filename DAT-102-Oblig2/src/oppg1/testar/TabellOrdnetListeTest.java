package oppg1.testar;

import oppg1.adt.OrdnetListeADT;

import org.junit.jupiter.api.Test;

import oppg1.*;
import oppg1.tabell.*;
public class TabellOrdnetListeTest extends OrdnetListeADTTest {
	
	@Override
	protected OrdnetListeADT<Integer> reset() {
		return new TabellOrdnetListe<Integer>();
	}
}
