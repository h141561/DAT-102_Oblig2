package oppg3;
import oppg3.*;

public class Sjekkar implements ParentesSjekker{
	
	private StabelADT<Character> stabel = new KjedetStabel<Character>();
	
	public boolean erVenstreparentes(char p) {
		switch(p)
		{
		case'(':
		case'[':
		case'{':
			return true;
		default:
			return false;
		}
	}
	
	public boolean erHogreparentes(char p) {
		switch(p)
		{
		case'}':
		case')':
		case']':
			return true;
		default:
			return false;
		}
	}
	public boolean erParentes(char p) {
		switch(p)
		{
		case'(':
		case'[':
		case'{':
		case'}':
		case')':
		case']':
			return true;
		default:
			return false;
		}
	}
	
	public boolean erPar(char venstre, char hogre) {
		if(venstre == '{' && hogre == '}')
			return true;
		if(venstre == '[' && hogre == ']')
			return true;
		if(venstre == '(' && hogre == ')')
			return true;
		return false;
	}
	public boolean erBalansert(String s) {
		boolean ret = true;
		stabel = new KjedetStabel<Character>();
		int newlines = 0;
		for(int i = 0; i < s.length();i++)
		{
			char c = s.charAt(i);
			if(c=='\n')
				++newlines;
			if(this.erParentes(c))
			{
				try {
					if(this.erHogreparentes(c) && stabel.erTom())
					{
						ret = false;
						System.out.printf("FEIL: parantes \"%c\" er ein lukkeparantes utan åpnar på linje %d, teikn nr %d\n",c,newlines,i);
						continue;
					}
					if(
							(this.erHogreparentes(c) && stabel.erTom())
							||
							(this.erHogreparentes(c) && !(this.erPar(stabel.peek(), c)))
						)
					{
						System.out.printf("FEIL: %c er ein høgreparantes men den har ikkje motpart med %c\n", c,stabel.peek());
						continue;
					}
					if(this.erHogreparentes(c) && (this.erPar(stabel.peek(), c)))
					{
						stabel.pop();
						continue;
					}
					stabel.push(c);
				}catch(EmptyCollectionException e) {
					
				}
			}
		}
		if(!stabel.erTom())
		{
			System.out.printf("FEIL: det er uparra parantesar\n");
		}
		return ret;
	}
	
}
