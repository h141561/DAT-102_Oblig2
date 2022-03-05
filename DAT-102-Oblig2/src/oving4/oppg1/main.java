package oving4.oppg1;
import oving4.oppg1.*;
public class main {

	public static void main(String[] args) {
		MengdeADT<Integer> tabell = new TabellMengde<Integer>();
		MengdeADT<Integer> liste = new KjedetMengde<Integer>();
		MengdeADT<Integer> resultat = new TabellMengde<Integer>();
		tabell.leggTil(1);
		tabell.leggTil(3);
		tabell.leggTil(5);
		tabell.leggTil(6);

		liste.leggTil(1);
		liste.leggTil(2);
		liste.leggTil(3);
		liste.leggTil(10);
		
		resultat = tabell.union(liste);
		
		System.out.print("Union\n");
		for(Integer i : resultat)
			System.out.println(i);
		
		resultat = tabell.snitt(liste);
		System.out.print("\nSnitt\n");
		for(Integer i : resultat)
			System.out.println(i);
		
		resultat = tabell.differens(liste);
		System.out.print("\nDifferensTabell\n");
		for(Integer i : resultat)
			System.out.println(i);
		
		resultat = liste.differens(tabell);
		System.out.print("\nDifferensListe\n");
		for(Integer i : resultat)
			System.out.println(i);
	}

}
