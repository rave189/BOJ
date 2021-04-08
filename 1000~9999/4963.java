import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int[][] array;
	static boolean[][] check;
	static int count;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		while (input.hasNextLine()) {
			int y = input.nextInt();
			int x = input.nextInt();
			if(x == 0 && y == 0)
				break;
			array = new int[x][y];
			check = new boolean[x][y];
			for (int i = 0; i < x; i++)
				for (int j = 0; j < y; j++)
					array[i][j] = input.nextInt();
			int count = 0;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if (array[i][j] == 1 && check[i][j] == false) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void dfs(int i, int j) {
		check[i][j] = true;
		if (j > 0 && array[i][j - 1] == 1 && check[i][j - 1] == false)
			dfs(i, j - 1);
		if (j < array[0].length - 1 && array[i][j + 1] == 1 && check[i][j + 1] == false)
			dfs(i, j + 1);
		if (i > 0 && array[i - 1][j] == 1 && check[i - 1][j] == false)
			dfs(i - 1, j);
		if (i < array.length - 1 && array[i + 1][j] == 1 && check[i + 1][j] == false)
			dfs(i + 1, j);
		if (i > 0 && j > 0 && array[i - 1][j - 1] == 1 && check[i - 1][j - 1] == false)
			dfs(i - 1, j - 1);
		if (i > 0 && j < array[0].length - 1 && array[i - 1][j + 1] == 1 && check[i - 1][j + 1] == false)
			dfs(i - 1, j + 1);
		if (i < array.length - 1 && j > 0 && array[i + 1][j - 1] == 1 && check[i + 1][j - 1] == false)
			dfs(i + 1, j - 1);
		if (i < array.length - 1 && j < array[0].length - 1 && array[i + 1][j + 1] == 1 && check[i + 1][j + 1] == false)
			dfs(i + 1, j + 1);
	}
}
