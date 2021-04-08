import java.io.IOException;
import java.util.Scanner;

public class Main {
	public final static int mod = 1000000000;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		long[][] array = new long[101][101];
		for(int i=1; i<=9; i++)
			array[1][i] = 1;
		for(int i=2; i<=number; i++) {
			for(int j=0; j<=9; j++) {
				array[i][j] = 0;
				if(j-1 >= 0)
					array[i][j] += array[i-1][j-1];
				if(j+1 <= 9)
					array[i][j] += array[i-1][j+1];
				array[i][j] %= mod;
			}
		}
		long sum = 0;
		for(int i=0; i<=9; i++)
			sum += array[number][i];
		System.out.println(sum%mod);
	}
}
