import java.io.IOException;
import java.util.Scanner;

public class Main {
	public final static int mod = 10007;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		long[][] array = new long[1001][1001];
		for(int i=0; i<=9; i++)
			array[1][i] = 1;
		for(int i=2; i<=number; i++) {
			for(int j=0; j<=9; j++) {
				for(int t=0; t<=j; t++) {
					array[i][j] += array[i-1][t];
					array[i][j] %= mod;
				}
			}
		}
		long sum = 0;
		for(int i=0; i<=9; i++)
			sum += array[number][i];
		System.out.println(sum%mod);
	}
}
