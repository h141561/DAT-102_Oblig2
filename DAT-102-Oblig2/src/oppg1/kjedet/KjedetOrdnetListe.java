package oppg1.kjedet;

import oppg1.adt.*;

import oppg1.exceptions.*;
import oppg1.adt.OrdnetListeADT;
import oppg1.kjedet.*;
/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = this.foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();
		LinearNode<T> nestSiste = foerste;
		while(nestSiste != siste)
		{
			if(nestSiste.getNeste() == siste)
			{
				siste = nestSiste;
				break;
			}
			nestSiste = nestSiste.getNeste();
		}
		--antall;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> ny = new LinearNode<T>(element);
		LinearNode<T> curr = foerste;
		if(this.erTom())
		{
			foerste = siste = ny;
		}
		else
		{
			short t = 100;
			curr = foerste;
			while(curr != null)
			{ 
				--t;
				if(t <= 0)
					break;
				if(foerste.getElement().compareTo(element) > 0) //nye elementet er mindre enn fyrste
				{
					ny.setNeste(foerste);
					foerste = ny;
					break;
				}
				if(curr.getNeste() == null) //curr er siste element
				{
					//System.out.printf("curr = %s, element = %s\n",curr.getElement().toString(),element.toString());
					if(siste.getElement().compareTo(element) <= 0)
					{
						siste.setNeste(ny);
						siste = ny;
						break;
					}
					else
					{
						curr.setNeste(ny);
						ny.setNeste(siste);
						break;
					}
					//System.out.printf("%d er storre enn %smtydelegvis, og ny blir ny siste\n", element, gamlesiste.toString());
				}
				if(curr.getNeste().getElement().compareTo(element) >= 0)//neste element er større enn ny
				{
					//System.out.printf("curr.neste = %s, element = %s\n",curr.getNeste().getElement().toString(),element.toString());
					ny.setNeste(curr.getNeste());
					curr.setNeste(ny);
					break;
				}
				curr = curr.getNeste();//elementet er større enn curr.neste, flyttar peikaren 1 fram
			}
		}
		++antall;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
