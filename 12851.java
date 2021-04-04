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
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + k * 2 + 1];
		int[][] timeSave = new int[2][arr.length];
		Arrays.fill(timeSave[0], Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		timeSave[0][n] = 0;
		timeSave[1][n] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k)
				continue;
			int[] move = { -1, 1, cur };
			for (int i = 0; i < 3; i++) {
				int next = cur + move[i];
				try {
					if (timeSave[0][cur] + 1 < timeSave[0][next]) {
						timeSave[0][next] = timeSave[0][cur] + 1;
						timeSave[1][next] = 1;
					} else if (timeSave[0][cur] + 1 == timeSave[0][next])
						timeSave[1][next]++;
					else
						continue;
					q.add(next);
				} catch (Exception e) {
				}
			}
		}
		System.out.println(timeSave[0][k]);
		System.out.println(timeSave[1][k]);
	}
}
