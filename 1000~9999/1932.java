import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] arr = new int[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < arr[i].length; j++)
				arr[i][j] = input.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0)
					arr[i + 1][j] += arr[i][j];
				else if (arr[i][j - 1] > arr[i][j])
					arr[i + 1][j] += arr[i][j - 1];
				else
					arr[i + 1][j] += arr[i][j];
			}
			arr[i + 1][arr[i + 1].length - 1] += arr[i][arr[i].length - 1];
		}
		long max = 0;
		for (int i = 0; i < arr[n - 1].length; i++)
			if (arr[n - 1][i] > max)
				max = arr[n - 1][i];
		System.out.println(max);
	}
}
