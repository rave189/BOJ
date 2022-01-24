package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * N���� ������� �޸��� ��ȸ�� �����Ͽ� ��ȯ���� �����ƴ�.
 * �� �������� ��� �Ƿ��� �־�, �տ� �ִ� �������� ��� �Ƿ��� ������ ���� ������ �������� ���� �����ϴ�.
 * �̶�, �� ������ �ּ��� ����� ���ϴ¹���
 * �Է��� �տ��� �޸��� �������� ���ʴ�� �־�����.
 * ������ ��� �Ƿ��� ��� �ٸ���.
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
	 * ���׸�Ʈ Ʈ���� �̿��ϴ� ����
	 * ������ ��� �Ƿ��� �ſ� Ŀ �迭�� ������� �ʰ� �� ������ ����Ѵ�.
	 * �� ������ ������ ��� �Ƿ¸��� �ε����� hash�� �����صд�.
	 * �տ������� ������ ��� �Ƿ��� ������ �ڽź��� �տ� �ִ� ���� �� ��� �Ƿ��� �� ���� ������ ���� ã�´�.
	 * ã�� ������ �� + 1�� �ϸ� �ڽ��� ���� ����� ���´�.
	 * 
	 * hash�� ����ϴ� ���� ������ ����.
	 * hash�� �迭�� �ٲٰų� �� �� ���� ����� ����ϸ� ������ ���� �� �� ����.
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
			// ������ ���� ���� ������ �˰� Ʈ���� ������Ʈ�Ѵ�.
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