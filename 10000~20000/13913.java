import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n == m) {
			System.out.println(0);
			System.out.println(n);
			return;
		}
		int[][] arr = new int[2][n + m * 2 + 1];
		Arrays.fill(arr[0], 10000000);
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		arr[0][n] = 0;
		arr[1][n] = n;
		while (!q.isEmpty()) {
			int curIdx = q.poll();
			int[] move = { 1, -1, curIdx };
			for (int i = 0; i < move.length; i++) {
				int nextIdx = curIdx + move[i];
				try {
					if (arr[0][curIdx] + 1 < arr[0][nextIdx]) {
						arr[0][nextIdx] = arr[0][curIdx] + 1;
						arr[1][nextIdx] = curIdx;
						q.add(nextIdx);
					}
				} catch (Exception e) {
				}
			}
		}
		LinkedList<Integer> route = new LinkedList<>();
		route.add(m);
		int index = arr[1][m];
		while (index != n) {
			route.add(index);
			index = arr[1][index];
		}
		route.add(n);
		System.out.println(arr[0][m]);
		while (!route.isEmpty())
			System.out.print(route.removeLast() + " ");
	}
}
