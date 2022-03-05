package oving4.oppg2;
import oving4.oppg1.*;
public class Oppg2_1 {
	
	private static Datakontakt dat;
	
	public static void main(String[] args) {
		dat = new Datakontakt();
		Medlem m1 = new Medlem("Geir");
		Medlem m2 = new Medlem("Ola");
		
		m1.leggTilHobby("Warhammer");
		m2.leggTilHobby("Warhammer");
		m2.leggTilHobby("Minecraft");
		
		dat.leggTil(m1);
		dat.leggTil(m2);
		dat.printAlle();
		

	}

}
