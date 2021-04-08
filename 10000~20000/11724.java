import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int[][] array;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int point = input.nextInt();
		int line = input.nextInt();
		array = new int[point+1][point+1];
		check = new boolean[point+1];
		for(int i=0; i<line; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			array[x][y] = 1;
			array[y][x] = 1;
		}
		int count = 0;
		for(int i=1; i<check.length;i++)
			if(check[i] == false) {
				dfs(i);
				count++;
			}
		System.out.println(count);
	}
	public static void dfs(int n) {
		check[n] = true;
		for(int i=1; i<=array.length-1; i++)
			if(array[n][i] == 1 && check[i] == false)
				dfs(i);
	}
}
