package oppg4;
import java.time.Clock;
public class Main {
	public static void main(String[] args) {
		System.out.printf("summen av dei 100 fyste tala er %d\n", sumAvN(100));
		
		for(int i = 0; i <= 10; i++)
		{
			System.out.printf("talfolge(%d) er \t%d\n", i, talfolge(i));
		}
		for(int i = 0; i < 49; i++)
		{
			System.out.printf("Fibonacci(%d) er \t%d\n", i, fibonacciRekursiv(i));
		}
		for(int i = 0; i < 10; i++)
		{
			System.out.printf("FibonacciIterativ(%d) er \t%d\n", i, fibIterativ(i));
		}
		Clock tid = Clock.systemDefaultZone();
		
		int lengde = 46;
		long millis = tid.millis();
		int t = fibIterativ(lengde);
		long iterativTid = tid.millis() - millis;
		millis = tid.millis();
		int t2 = fibonacciRekursiv(lengde);
		long rekursivTid = tid.millis() - millis;
		
		System.out.printf("Rekursiv tok \t%d ms \nIterativ tok \t%d ms\nFor fib(%d)",rekursivTid, iterativTid, lengde);
		
		
	}
	/*
	 * 
	 * Oppg4-a
	 */
	public static int sumAvN(int n) {
		if(n <= 1)
			return 1;
		else
			return n + (sumAvN(n - 1));
	}
	/*
	 * Oppg 4-b
	 */
	public static int talfolge(int a) { 
		if(a <= 0)
			return 2;
		if(a == 1)
			return 5;
		
		return (5 * talfolge(a - 1)) - (6 * talfolge(a-2)) + 2;
	}
	
	/*
	 * Oppg 4-c
	 */
	public static int fibonacciRekursiv(int f) {
		if(f <= 0)
			return 0;
		if(f == 1)
			return 1;
		
		return fibonacciRekursiv(f-1) + fibonacciRekursiv(f-2);
	}
	
	public static int fibIterativ(int f) {
		int[] res = {0,0,0};
		for(int i = 0; i < f ; i++)
		{
			if(i <= 0)
			{
				res[2] = 0;
			}
			if(i == 1)
			{
				res[2] = 1;
			}
			res[0] = res[1];
			res[1] = res[2];
			res[2] = res[1] + res[0];
		}
		return res[2];
	}
}
