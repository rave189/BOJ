package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 총 F층으로 이루어진 건물이 있다.
 * 강호는 S층에 있고 G층으로 가려고 엘리베이터를 타려고 한다.
 * 엘리베이터는 버튼이 위로 U층 가는 버튼과 아래로 D층 가는 버튼만 있다.
 * 강호가 G층으로 가기 위해 누르는 버튼의 최솟값을 구하는 문제
 * G층으로 가지 못한다면 use the stairs를 출력한다.
 * @author Rave
 *
 */
public class Main {

	// 해당 층을 방문한 적이 있는지 확인한다.
	static boolean[] visited;
	// u와 -d를 저장할 배열
	static int[] move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		visited = new boolean[f + 1];
		move = new int[] { u, -d };
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		int click = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int floor = q.poll();
				if (floor == g) {
					System.out.println(click);
					return;
				}
				for (int i = 0; i < 2; i++) {
					int nextFloor = floor + move[i];
					try {
						// 방문한 적이 없는 층이거나 0층이 아닌 경우 큐에 해당 층을 넣는다.
						// 0층으로 갔다가 u만큼 올라올 수 있으므로 0층을 제외한다.
						if (nextFloor != 0 && !visited[nextFloor]) {
							q.add(nextFloor);
							visited[nextFloor] = true;
						}
					} catch (Exception e) {
					}
				}
			}
			click++;
		}
		System.out.println("use the stairs");
	}
}