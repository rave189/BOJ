import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				arr[i][j] = input.nextInt();
		int k = input.nextInt();
		for (int i = 0; i < k; i++) {
			int sum = 0;
			int[] point = new int[4];
			for (int j = 0; j < 4; j++)
				point[j] = input.nextInt() - 1;
			for (int x = point[0]; x <= point[2]; x++)
				for (int y = point[1]; y <= point[3]; y++)
					sum += arr[x][y];
			System.out.println(sum);
		}
	}
}
