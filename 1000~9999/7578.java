package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ���忡�� N���� ��谡 �ִ�.
 * �� ���� ������ �ĺ� ��ȣ�� ������.
 * �� ������ 2�ٷ� �����ϴµ�, �� ���� ����� ������ �ٸ���.
 * 1��: 132, 392, 311, 351, 231
 * 2��: 392, 351, 132, 311, 231
 * �̶� ���� ��ȣ�� ��踦 ������ ��, �����ϴ� ���� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] tree;
	static int s = 1;
	static Map<Integer, Integer> hash = new HashMap<>();

	/**
	 * ���׸�Ʈ Ʈ���� ����ϴ� ����
	 * 1���� ���� ��ġ�Ѵ�.
	 * 2�������� �Է��� ������ Ʈ���� ������ ������Ʈ �ϸ� 1���� ���� �̾��ش�.
	 * ���� ��ġ�� ����� ������ ���� ������ �߿� ��ġ�� ���� ������ ���Ѵ�.
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
			// ��踦 ������Ʈ
			update(index, 1);
			// ������ ���� ������ �������� ���� ������ ���� �ʵ��� �Ѵ�.
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