package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 공장에는 N개의 기계가 있다.
 * 각 기계는 고유의 식별 번호를 가진다.
 * 이 기계들을 2줄로 나열하는데, 각 줄의 기계의 순서는 다르다.
 * 1열: 132, 392, 311, 351, 231
 * 2열: 392, 351, 132, 311, 231
 * 이때 같은 번호의 기계를 연결할 때, 교차하는 선의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] tree;
	static int s = 1;
	static Map<Integer, Integer> hash = new HashMap<>();

	/**
	 * 세그먼트 트리를 사용하는 문제
	 * 1열을 먼저 설치한다.
	 * 2열에서는 입력을 받으며 트리의 정보를 업데이트 하며 1열의 기계와 이어준다.
	 * 이후 설치한 기계의 오른쪽 부터 끝까지 중에 겹치는 선의 개수를 구한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (s < n)
			s *= 2;
		tree = new int[2 * s];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			hash.put(Integer.parseInt(st.nextToken()), i);
		st = new StringTokenizer(br.readLine());
		long answer = 0;
		for (int i = 0; i < n; i++) {
			int machineNo = Integer.parseInt(st.nextToken());
			int index = hash.get(machineNo);
			// 기계를 업데이트
			update(index, 1);
			// 마지막 기계와 이으면 오른쪽이 없기 때문에 들어가지 않도록 한다.
			if (index + 1 <= s)
				answer += query(1, s, 1, index + 1, s);
		}
		System.out.println(answer);
	}

	public static void update(int index, int target) {
		index = s + index - 1;
		tree[index] = target;
		while ((index /= 2) > 0)
			tree[index] = tree[index * 2] + tree[index * 2 + 1];
	}

	public static int query(int left, int right, int node, int queryLeft, int queryRight) {
		if (queryRight < left || right < queryLeft)
			return 0;
		else if (queryLeft <= left && right <= queryRight)
			return tree[node];
		else {
			int mid = (left + right) / 2;
			return query(left, mid, node * 2, queryLeft, queryRight)
					+ query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
		}
	}
}