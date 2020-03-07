import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] array;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int point = input.nextInt();
		int line = input.nextInt();
		int start = input.nextInt();
		array = new int[point+1][point+1];
		check = new boolean[point+1];
		for(int i=0; i<line; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			array[x][y] = 1;
			array[y][x] = 1;
		}
		dfs(start);
		System.out.println();
		check = new boolean[point+1];
		bfs(start);
	}
	public static void dfs(int n) {
		check[n] = true;
		System.out.print(n+" ");
		for(int i=1; i<=array.length-1; i++)
			if(array[n][i] == 1 && check[i] == false)
				dfs(i);
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[n] = true;
		q.add(n);
		while(!q.isEmpty()) {
			int x = q.peek();
			q.poll();
			System.out.print(x+" ");
			for(int i=1; i<=array.length-1; i++){
				if(array[x][i] == 1 && check[i] == false) {
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
}
