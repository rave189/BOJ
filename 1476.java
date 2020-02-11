import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int E = input.nextInt();
		int S = input.nextInt();
		int M = input.nextInt();
		int count = 1;
		int e = 1, s = 1, m = 1;
		while (true) {
			boolean done = false;
			if (S == s)
				if(M == m)
					if(E == e)
						done = true;
			if(done)
				break;
			else {
				e++;s++;m++;count++;
				if(e % 16 == 0)
					e = 1;
				if(m % 20 == 0)
					m = 1;
				if(s % 29 == 0)
					s = 1;
			}
		}
		System.out.println(count);
	}
}
