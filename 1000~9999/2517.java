package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * N명의 사람들이 달리기 대회에 참가하여 반환점을 지나쳤다.
 * 각 선수들은 평소 실력이 있어, 앞에 있는 선수보다 평소 실력이 좋으면 앞의 선수를 앞지르는 것이 가능하다.
 * 이때, 각 선수의 최선의 등수를 구하는문제
 * 입력은 앞에서 달리는 선수부터 차례대로 주어진다.
 * 선수의 평소 실력은 모두 다르다.
 * 
 * @author Rave
 *
 */
public class Main {

	static int[] tree;
	static int[] arr;
	static int s = 1;
	static Map<Integer, Integer> hash = new TreeMap<>();

	/**
	 * 세그먼트 트리를 이용하는 문제
	 * 선수의 평소 실력이 매우 커 배열을 사용하지 않고 값 압축을 사용한다.
	 * 값 압축은 선수의 평소 실력마다 인덱스를 hash에 저장해둔다.
	 * 앞에서부터 선수의 평소 실력이 들어오면 자신보다 앞에 있는 선수 중 평소 실력이 더 좋은 선수의 수를 찾는다.
	 * 찾은 선수의 수 + 1을 하면 자신의 예상 등수가 나온다.
	 * 
	 * hash를 사용하니 많이 느린거 같음.
	 * hash를 배열로 바꾸거나 좀 더 좋은 방법을 사용하면 단축이 많이 될 것 같다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hash.put(arr[i], 0);
		}
		while (s < n)
			s *= 2;
		tree = new int[2 * s];
		int count = 1;
		for (int key : hash.keySet())
			hash.put(key, count++);
		for (int i = 0; i < n; i++) {
			// 쿼리를 먼저 날려 순위를 알고 트리에 업데이트한다.
			answer.append(query(1, s, 1, hash.get(arr[i]) + 1, s) + 1).append('\n');
			update(hash.get(arr[i]));
		}
		System.out.print(answer);
	}

	public static void update(int n) {
		int index = s + n - 1;
		tree[index] = 1;
		while ((index /= 2) > 0)
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
	}

	public static int query(int left, int right, int node, int queryLeft, int queryRight) {
		if (right < queryLeft || left > queryRight)
			return 0;
		if (queryLeft <= left && right <= queryRight)
			return tree[node];
		else {
			int mid = (left + right) / 2;
			int leftResult = query(left, mid, node * 2, queryLeft, queryRight);
			int rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
			return leftResult + rightResult;
		}
	}
}