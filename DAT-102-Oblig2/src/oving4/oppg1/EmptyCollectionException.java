package oving4.oppg1;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom
//********************************************************************
public class EmptyCollectionException extends RuntimeException {
	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public EmptyCollectionException(String samling) {
		super("" + samling + " er tom.");
	}
}
