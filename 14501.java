import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] arr = new int[n + 1][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = input.nextInt();
			arr[i][1] = input.nextInt();
		}
		int[] result = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int next = i + arr[i][0];
			if (next <= n)
				for (int j = next; j <= n; j++)
					if (result[j] < result[i] + arr[i][1])
						result[j] = result[i] + arr[i][1];
		}
		System.out.println(result[n]);
	}
}
