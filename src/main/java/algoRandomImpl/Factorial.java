package algoRandomImpl;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int lastfact = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				System.out.println(lastfact = 1);
			} else
//				System.out.print(" for i="+i+" factorial is ");
				System.out.println(lastfact = i * lastfact);

		}
	}
}
