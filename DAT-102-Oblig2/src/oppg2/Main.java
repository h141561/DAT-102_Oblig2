package oppg2;

public class Main {

	public static void main(String[] args) {
		DobbelKjedetOrdnetListe<Integer> liste = new DobbelKjedetOrdnetListe<Integer>(0,100);
		liste.leggTil(10);
		liste.leggTil(90);
		liste.leggTil(1);
		liste.visListe();
		liste.fjern(10);
		liste.fjern(90);
		liste.visListe();
	}

}
