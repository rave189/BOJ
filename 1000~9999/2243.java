package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 맛의 좋고 나쁨이 1부터 100만까지 있는 사탕들이 있다.
 * 맛이 가장 좋은 사탕은 1이고 가장 맛이 없는 사탕은 100만이다.
 * 이 사탕을 상자에 넣어두고 i번째로 맛있는 사탕을 하나씩 꺼내 먹는다.
 * 사탕을 꺼내먹을 때마다 i번째 맛있는 사탕의 번호를 출력하는 문제
 * 
 * @author Rave
 *
 */
public class Main {

	static int s = 1048576;

	/**
	 * 세그먼트 트리(인덱스 트리)를 사용하는 문제
	 * Bottom Up방식으로는 풀 수 없고, Top Down 방식으로만 풀 수 있는 카운팅 쿼리 문제이다.
	 * command가 1이면 i번째로 맛있는 사탕을 꺼내고 번호를 출력한다.
	 * command가 2이면 i번째 사탕에 count만큼 추가해 준다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		QountingQuery it = new QountingQuery(s);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int index = it.query(1, s, 1, value) - s + 1;
				it.update(s, index, -1);
				answer.append(index).append('\n');
			} else {
				int count = Integer.parseInt(st.nextToken());
				it.update(s, value, count);
			}
		}
		System.out.print(answer);
	}
}

class QountingQuery {
	private int[] arr;

	public QountingQuery(int s) {
		arr = new int[s * 2];
	}

	public void update(int s, int value, int count) {
		int node = s + value - 1;
		arr[node] += count;
		while ((node /= 2) > 0)
			arr[node] = arr[node * 2] + arr[node * 2 + 1];
	}

	public int query(int left, int right, int node, int target) {
		if (left == right)
			return node;
		int mid = (left + right) / 2;
		if (arr[node * 2] >= target) {
			return query(left, mid, node * 2, target);
		} else
			return query(mid + 1, right, node * 2 + 1, target - arr[node * 2]);
	}
}