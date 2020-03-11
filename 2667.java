import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int[][] array;
	static boolean[][] check;
	static int count;

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.nextLine();
		array = new int[number][number];
		check = new boolean[number][number];
		for (int i = 0; i < number; i++) {
			String s = input.nextLine();
			for (int j = 0; j < number; j++)
				array[i][j] = Integer.parseInt(s.substring(j, j + 1));
		}
		int[] result = new int[number * number];
		int cnt = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				count = 0;
				if (array[i][j] == 1 && check[i][j] == false) {
					dfs(i, j);
					result[cnt] = count;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		for(int i=0; i<cnt; i++)
			for(int j=0; j<cnt; j++)
				if(result[i] < result[j]) {
					int temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
		for(int i=0; i<cnt; i++)
			System.out.println(result[i]);
	}

	public static void dfs(int i, int j) {
		check[i][j] = true;
		if (j > 0 && array[i][j - 1] == 1 && check[i][j - 1] == false)
			dfs(i, j - 1);
		if (j < array.length - 1 && array[i][j + 1] == 1 && check[i][j + 1] == false)
			dfs(i, j + 1);
		if (i > 0 && array[i - 1][j] == 1 && check[i - 1][j] == false)
			dfs(i - 1, j);
		if (i < array.length - 1 && array[i + 1][j] == 1 && check[i + 1][j] == false)
			dfs(i + 1, j);
		count++;
	}
}
