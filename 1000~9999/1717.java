package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * {0}, {1} ... {N}이 각각 N+1의 집합을 이루고 있다.
 * 이후 M개의 명령에 대해 다음과 같은 작업을 수행한다.
 * 0 a b는 a가 속한 집합과 b가 속한 집합을 합쳐 합집합을 이루도록 한다.
 * 1 a b는 a와 b가 같은 집합에 속해있는지 확인한다.
 * 1의 명령에 대해서 결과를 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[] unionFind;

	/**
	 * unionFind를 통해 합집합을 표현하고 같은 집합인지 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		unionFind = new int[n + 1];
		// unionFind 초기화
		for (int i = 1; i < unionFind.length; i++)
			unionFind[i] = i;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			// first와 second의 루트 노드를 찾는다.
			int firstParent = find(first);
			int secondParent = find(second);
			// 한쪽의 루트노드를 다른 쪽으로 변경한다.
			if (command == 0)
				unionFind[firstParent] = unionFind[secondParent];
			// command가 1인 경우
			// 두 루트 노드의 값이 같다면 같은 집합이고, 아니라면 다른 집합이다.
			else
				sb.append(firstParent == secondParent ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}

	/**
	 * unionFind의 루트 노드를 찾는 메소드
	 * @param cur 현재 노드
	 * @return 루트 노드
	 */
	public static int find(int cur) {
		// cur과 unionFind[cur]이 같다면 루트 노드이다.
		if (cur == unionFind[cur])
			return cur;
		// 아니라면 unionFind[cur]을 업데이트 해주며 재귀 호출을 수행한다.
		return unionFind[cur] = find(unionFind[cur]);
	}
}