package oppg1.testar;
import oppg1.*;
import oppg1.adt.OrdnetListeADT;
import oppg1.exceptions.EmptyCollectionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class OrdnetListeADTTest {

	/**
	 * Test av OrdnetListe med heltall.
	 * 
	 * @author Ole Olsen
	 */

	private OrdnetListeADT<Integer> liste;

	// Test data
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;

	/**
	 * Opprett en tom liste for hver test.
	 * 
	 *
	 */

	protected abstract OrdnetListeADT<Integer> reset();

	@BeforeEach
	public final void setup() {
		liste = reset();
	}

	/**
	 * Tester om en ny liste er tom.
	 */
	@Test
	public final void nyListeErTom() {
		assertTrue(liste.erTom());
	}

	/**
	 * Tester leggTil og fjern.
	 */
	@Test
	public final void leggTilOgFjern() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e4, liste.fjern(e4));
		assertEquals(e3, liste.fjern(e3));
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e0, liste.fjern(e0));
	}
	
	/**
	 * Tester ordning ikke-avtagende
	 * 
	 */
	@Test
	public final void viseOrdnetIkkeAvtagende() {
		/*
		 * 
		 * Usikker på Kva som skal skje her. så  eg la in visOrdnetIkkjeStigane() i revers.
		 */
		
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e5);
		liste.leggTil(e0);
		liste.leggTil(e4);
		liste.leggTil(e3);
		assertEquals(e0, liste.fjernFoerste());
		assertEquals(e1, liste.fjernFoerste());
		assertEquals(e2, liste.fjernFoerste());
		assertEquals(e3, liste.fjernFoerste());
		assertEquals(e4, liste.fjernFoerste());
		assertEquals(e5, liste.fjernFoerste());
		
	}

	@Test
	public final void viseOrdnetIkkeStigende() { // 4 >= 5 >= 5 >= 5 >= 6 ...
		/*
		 * nok ein gong, ikkje sikker på kva eg skal gjere her
		 */
	}

	/**
	 * Tester leggTil og fjern med like verdier.
	 */
	@Test
	public final void leggTilOgfjernMedDuplikater() {
		liste.leggTil(e0);
		liste.leggTil(e1);
		liste.leggTil(e2);
		liste.leggTil(e3);
		liste.leggTil(e4);
		liste.leggTil(e5);
		liste.leggTil(e5);


		assertEquals(e0, liste.fjern(e0));
		assertEquals(e1, liste.fjern(e1));
		assertEquals(e4, liste.fjern(e4));
		/*
		 * assertEquals(e1, liste.fjern(e1));
		 * 
		 * Usikker på den her, den gjer feil når du prøvar å fjerne ting som ikkje er i lista.
		 * Er ikkje dette ynskja oppførsel?
		 */
		assertEquals(e2, liste.fjern(e2));
		assertEquals(e3, liste.fjern(e3));
		
		/*
		 * No fjernar den duplikatane av e5
		 */
		assertEquals(e5, liste.fjern(e5));
		assertEquals(e5, liste.fjern(e5));
		System.out.println(liste.antall());
		assertTrue(liste.erTom());

	}

	/**
	 * Tester leggTil og inneholder
	 */
	@Test
	public final void leggTilOgInnholder() {
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);

		assertTrue(liste.inneholder(e0));
		assertTrue(liste.inneholder(e1));
		assertTrue(liste.inneholder(e2));
		assertTrue(liste.inneholder(e3));
		assertTrue(liste.inneholder(e4));
		assertFalse(liste.inneholder(e5));

	}

	/**
	 * Tester om listen med verdier ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		liste.leggTil(e1);
		liste.leggTil(e3);
		liste.leggTil(e2);
		liste.leggTil(e4);
		liste.leggTil(e5);
		assertFalse(liste.erTom());
		assertEquals(liste.antall(), 5);
	}

	/**
	 * Tester om leggTil-fjern p� en tom liste gir en tom liste.
	 */
	@Test
	public final void leggTilFjernErTom() {
		assertTrue(liste.erTom());
		
		liste.leggTil(e2);
		
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);
		while(!liste.erTom())
		{
			liste.fjernFoerste();
		}
		liste.leggTil(e2);
		liste.leggTil(e1);
		liste.leggTil(e4);
		liste.leggTil(e0);
		liste.leggTil(e3);
		while(!liste.erTom())
		{
			liste.fjernSiste();
		}
	}

	/**
	 * Pr�ver � ta ut et element fra en tom liste.
	 * 
	 */
	@Test
	
	public void fjernFraTomListe() {	
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			liste.fjernFoerste();
		});
	}
	

	

}
