package oving4.oppg1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}
	
	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall-1]= null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {
	
		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		T svar = null;
		for(int i = 0; (i < antall && !funnet);i++) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				tab[i] = tab[antall-1];
				//tab[antall-1] = null;
				antall--;
				funnet = true;
				
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		Iterator<T> it = this.iterator();
		T t;
		while(it.hasNext())
		{
			t = it.next();
			if(t == element)
			{
				return true;
			}
		}
		return (funnet);
	}
	
	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hascode-metoden da en del biblioterker burker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hascode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	
	@Override
	public boolean equals(Object m2) {
		
		boolean ret = false;
		TabellMengde<T> innLest = new TabellMengde<T>();
		if(m2 instanceof Iterable)
		{
			Iterator<T> it = ((Iterable<T>) m2).iterator();
			while(it.hasNext())
			{
				T t = it.next();
				if(this.inneholder(t))
				{
					innLest.leggTil(t);
				}else {
					return false;
				}
			}
			it = this.iterator();
			while(it.hasNext())
			{
				T t = it.next();
				if(!innLest.inneholder(t))
				{
					return false;
				}
			
			}
			return true;
		}
		return false;
	}

	

	/*
	 * Denne versjonen av unionen er lite effektiv
	 * 
	 * @Override public MengdeADT<T> union(MengdeADT<T> m2) { TabellMengde<T> begge
	 * = new TabellMengde<T>(); for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
	 * (MengdeADT<T>)begge; }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> union = new TabellMengde<T>();
		
		Iterator<T> it = this.iterator();
		while(it.hasNext())
		{
			T t = it.next();
			union.leggTil(t);
		}
		
		for(T t : m2)
		{
			union.leggTil(t);
		}
		return union;

	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		
		MengdeADT<T> snitt = new TabellMengde<T>();
		for(T t : this.tab)
		{
			
			if(m2.inneholder(t))
				snitt.leggTil(t);
		}
		return snitt;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new TabellMengde<T>();
		Iterator<T> it = this.iterator();
		while(it.hasNext())
		{
			T t = it.next();
			if(!m2.inneholder(t))
				differensM.leggTil(t);
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		
		for(T t : this.tab)
		{
			if(!m2.inneholder(t))
				return false;
		}
		return true;

	}

	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	

}// class
