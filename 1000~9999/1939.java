package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N개의 섬으로 이루어진 나라가 있다.
 * 이 나라는 섬마다 다리가 있어 다리를 이용하여 물건을 옮긴다.
 * 하지만 다리의 중량 제한이 있어 물건을 마음대로 옮기지 못한다.
 * 다리가 연결되어 있는 섬의 정보가 주어지고, 두 섬이 주어질 때,
 * 두 섬 사이에 한 번의 이동으로 옮길 수 있는 물건의 최대 중량을 구하는 문제
 * 다리는 모두 양방향이다.
 * @author Rave
 *
 */
public class Main {

	static ArrayList<Island>[] map;
	static int n;
	static int start;
	static int end;
	static boolean[] visited;

	/**
	 * 이분 탐색을 통해 minWeight를 설정한다.
	 * minWeight보다 중량이 큰 다리만을 이동 하였을 때 두 섬 사이를 이동할 수 있는지 확인한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			map[i] = new ArrayList<>();
		int left = 0, right = 0;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[first].add(new Island(second, weight));
			map[second].add(new Island(first, weight));
			right = Math.max(right, weight);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		while (left <= right) {
			// minWeight를 설정한다.
			int mid = (left + right) / 2;
			// 두 섬 사이를 이동할 수 있는지 확인한다.
			boolean isMove = BFS(mid);
			// 이동할 수 있다면 minWeight를 높여본다.
			if (isMove)
				left = mid + 1;
			// 아니라면 minWeight를 낮춰본다.
			else
				right = mid - 1;
		}
		System.out.println(left - 1);
	}

	/**
	 * minWeight보다 높은 중량을 견딜 수 있는 다리만을 건너 두 섬 사이를 이동할 수 있는지 확인하는 메소드
	 * 
	 * @param minWeight 최소 중량
	 * @return 두 섬 사이를 이동할 수 있다면 true, 아니라면 false
	 */
	public static boolean BFS(int minWeight) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end)
				return true;
			for (Island next : map[cur]) {
				if (next.weight < minWeight || visited[next.island])
					continue;
				visited[next.island] = true;
				q.add(next.island);
			}
		}
		return false;
	}
}

class Island {
	int island, weight;

	public Island(int _island, int _weight) {
		this.island = _island;
		this.weight = _weight;
	}
}