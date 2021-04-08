import java.util.Scanner;

public class Main {

	final static int mod = 1000000000;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[][] arr = new int[k][n];
		for (int i = 0; i < n; i++)
			arr[0][i] = 1;
		for (int i = 1; i < k; i++)
			arr[i][0] = arr[i-1][0] + 1;
		for (int i = 1; i < k; i++)
			for (int j = 1; j < n; j++)
				arr[i][j] = ((arr[i - 1][j] % mod) + (arr[i][j - 1] % mod)) % mod;
		System.out.println(arr[k-1][n-1]);
	}
}
