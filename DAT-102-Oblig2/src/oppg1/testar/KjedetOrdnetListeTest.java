package oppg1.testar;

import oppg1.adt.*;
import oppg1.kjedet.*;


public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
	   @Override
		protected OrdnetListeADT<Integer> reset() {
			return new KjedetOrdnetListe<Integer>();
		}		
}

