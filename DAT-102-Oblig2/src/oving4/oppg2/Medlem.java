package oving4.oppg2;

import oving4.oppg1.*;

public class Medlem {
	private String namn;
	private MengdeADT<String> hobbyar;
	private int statusIndeks;
	
	public Medlem(String navn) {
		this.namn = navn;
		hobbyar = new TabellMengde<String>();
	}
	public void leggTilHobby(String nyHobby) {
		this.hobbyar.leggTil(nyHobby);
	}
	public MengdeADT<String> getHobbyar(){
		return this.hobbyar;
	}
	public boolean passarTil(Medlem medlem2){
		return this.hobbyar.equals(medlem2.getHobbyar());
	}
	
	public String toString() {
		String ret = new String();
		ret += namn + " ";
		ret += '<';
		for(String i : hobbyar)
		{
			ret += i;
			ret += '.';
		}
		
		return ret.substring(0, ret.length() - 1) + '>';
	}
}
