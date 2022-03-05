package oppg3;

import oppg3.*;

public class KjedetStabel<T> implements StabelADT<T> {
	private LinearNode<T> topp;

	public KjedetStabel() {
		topp = null;

	}

	@Override
	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(topp);
		topp = nynode;

	}

	@Override
	public T pop() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		T resultat = topp.getElement();
		topp = topp.getNeste();

		return resultat;
	}

	@Override
	public T peek() {
		if (erTom())
			throw new EmptyCollectionException("stabel");

		return topp.getElement();
	}

	@Override
	public boolean erTom() {
		return (topp == null);
	}
}