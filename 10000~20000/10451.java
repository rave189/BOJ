import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int[][] array;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		for (int t = 0; t < number; t++) {
			int point = input.nextInt();
			array = new int[point + 1][point + 1];
			check = new boolean[point + 1];
			for (int i = 1; i <= point; i++) {
				int x = input.nextInt();
				array[i][x] = 1;
				array[x][i] = 1;
			}
			int count = 0;
			for (int i = 1; i < check.length; i++)
				if (check[i] == false) {
					dfs(i);
					count++;
				}
			System.out.println(count);
		}
	}

	public static void dfs(int n) {
		check[n] = true;
		for (int i = 1; i <= array.length - 1; i++)
			if (array[n][i] == 1 && check[i] == false)
				dfs(i);
	}
}
