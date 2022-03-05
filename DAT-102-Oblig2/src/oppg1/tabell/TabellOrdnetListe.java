package oppg1.tabell;
import oppg1.adt.*;
import oppg1.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}
	
	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}
	
	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = liste[bak-1];
		liste[bak--] = null;
		
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		for(int i = 0; i < bak - 1; i++)
		{
			liste[i] = liste[i + 1];
		}
		bak--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[bak - 1];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		int funnet = 1;
		
		for(int i = bak; i >= 0 ; i--)
		{
			if(bak == 0)
			{
				liste[bak] = element;
				bak++;
				return;
			}
			if((i == 0))
			{
				if( funnet == 1)
				{
					liste[i] = element;
					break;
				}
				if(funnet == 0)
				{
					break;
				}
			}
			if((liste[i-1].compareTo(element) <= 0) && (funnet == 1))
			{
				funnet = 0;
				liste[i]= element;
			}
			liste[i] = liste[i-funnet];
		}
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		int funnet = 0;
		T resultat = null;
		for(int i = 0; i < bak; i++)
		{
			if(liste[i] == element)
			{
				funnet = 1;
				resultat = liste[i];
			}
			liste[i] = liste[i + funnet];
		}
		bak--;
		return resultat;

	}

	private int finn(T el) {
		for(int i = 0; i < bak; i++) 
		{
			if(liste[i] == el)
				return 1;
		}
		return IKKE_FUNNET;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
