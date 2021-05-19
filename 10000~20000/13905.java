package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 섬과 그 섬을 연결하는 다리가 있다.
 * 숭이는 어느 섬에서 혜빈이가 존재하는 섬까지 금을 최대한 많이 가져가려고 한다.
 * 숭이의 윛, 혜빈이의 위치, 다리의 정보들이 주어질 때 가져갈 수 있는 금의 최대 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int n;
	static int s;
	static int e;
	static boolean[] visited;
	// 다리의 정보
	static ArrayList<Bridge>[] map;

	/**
	 * 중량제한과 같은 문제이다.
	 * 옮길 수 있는 최소한의 무게를 mid로 설정한 후 mid보다 큰 무게제한을 가진 다리만을 건너본다.
	 * 건널 수 있다면 값이 최대인지 확인한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		int left = 0, right = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Bridge(second, weight));
			map[second].add(new Bridge(first, weight));
			right = Math.max(right, weight);
		}
		int answer = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean isMove = BFS(mid);
			if (isMove) {
				left = mid + 1;
				answer = Math.max(answer, mid);
			} else
				right = mid - 1;
		}
		System.out.println(answer);
	}

	/**
	 * 숭이의 위치 s부터 혜빈이의 위치 e까지 도달할 수 있는지 확인하는 메소드
	 * 탐색은 BFS로 탐색한다.
	 * @param minWeight 금을 가져갈 최소 무게
	 * @return 혜빈이의 위치에 도달할 수 있다면 true, 아니라면 false
	 */
	public static boolean BFS(int minWeight) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == e)
				return true;
			for (Bridge next : map[cur]) {
				// 이미 방문했거나 다리의 무게제한이 minWeight보다 작은 경우 건너뛴다.
				if (visited[next.island] || next.weight < minWeight)
					continue;
				visited[next.island] = true;
				q.add(next.island);
			}
		}
		return false;
	}
}

class Bridge {
	int island, weight;

	public Bridge(int _island, int _weight) {
		this.island = _island;
		this.weight = _weight;
	}
}