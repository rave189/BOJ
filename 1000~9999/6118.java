package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 재서기와 수혀니가 숨바꼭질을 하고 있다.
 * 재서기는 농장의 헛간들 중 가장 먼 헛간에 숨어야 할때,
 * 헛간의 번호(거리가 같은 헛간이 여러개라면 가장 작은 번호의 헛간),
 * 헛간까지의 거리, 같은 거리의 헛간의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	// 입력이 많아 hash에 담는다.
	static HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			hash.putIfAbsent(first, new ArrayList<>());
			hash.putIfAbsent(second, new ArrayList<>());
			hash.get(first).add(second);
			hash.get(second).add(first);
		}
		// 시작은 1번 헛간이다.
		BFS(1);
	}

	/**
	 * 가장 먼 헛간들의 정보를 알기 위해 너비 우선 탐색을 수행하는 메소드
	 * @param start 시작 헛간
	 */
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int number = 0, distance = 0, count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int min = Integer.MAX_VALUE;
			count = size;
			distance++;
			while (size-- > 0) {
				int cur = q.poll();
				for (int next : hash.get(cur))
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
						min = Math.min(min, next);
					}
			}
			// 가장 먼 헛간의 번호는 while문의 마지막-1번째 실행일 때의 최소값이다.
			if (min != Integer.MAX_VALUE)
				number = min;
		}
		System.out.println(number + " " + (distance - 1) + " " + count);
	}
}