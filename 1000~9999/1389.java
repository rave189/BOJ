package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 케빈 베이컨의 6단계 법칙은 모든 사람들은 최대 6단계 이내로 서로 아는 사람으로 연결될 수 있다는 법칙이다.
 * 이를 통해 N명의 사람이 있을 때 1번과 2번의 단계, 1번과 3번의 단계... 1번과 N번의 단계를 구할 수 있다.
 * 이러한 단계를 모두 합한 값을 케빈 베이컨의 수라고 할 때 이 수가 가장 작은 사람을 구하는 문제
 * 1번과 2번이 2단계, 1번과 3번이 1단계, 1번과 4번이 1단계, 1번과 5번이 2단계라면
 * 2+1+1+2 = 6이 되고 이 수가 케빈 베이컨의 수가 된다.
 * @author Rave
 *
 */
public class Main {

	static HashSet<Integer>[] relationship;
	static boolean[] visited;

	/**
	 * 각각의 친구 관계를 해쉬에 저장하고 각 친구들까지 몇 단계만에 도달할 수 있는지 너비 우선 탐색을 통해 알아낸다.
	 * 이후 이러한 단계의 합이 가장 작은 사람을 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		relationship = new HashSet[n];
		for (int i = 0; i < n; i++)
			relationship[i] = new HashSet<>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			relationship[first].add(second);
			relationship[second].add(first);
		}
		int min = Integer.MAX_VALUE, answer = -1;
		for (int i = 0; i < n; i++) {
			int kevinNum = KevinBacon(i);
			if (kevinNum < min) {
				min = kevinNum;
				answer = i;
			}
		}
		System.out.println(answer + 1);
	}

	public static int KevinBacon(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited = new boolean[relationship.length];
		visited[start] = true;
		int kevinNum = 0;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int friend = q.poll();
				kevinNum += depth;
				for (int nextFriend : relationship[friend]) {
					if (visited[nextFriend])
						continue;
					visited[nextFriend] = true;
					q.add(nextFriend);
				}
			}
			depth++;
		}
		return kevinNum;
	}
}