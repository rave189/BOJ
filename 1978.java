import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int count = 0;
		for(int i=0; i<number; i++) {
			if(prime(input.nextInt()))
				count++;
		}
		System.out.println(count);
	}
	public static boolean prime(int n) {
		if(n < 2)
			return false;
		for(int i=2; i*i<=n; i++)
			if(n % i == 0)
				return false;
		return true;
	}
}
