package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� ���� ������ 1���� 100������ �ִ� �������� �ִ�.
 * ���� ���� ���� ������ 1�̰� ���� ���� ���� ������ 100���̴�.
 * �� ������ ���ڿ� �־�ΰ� i��°�� ���ִ� ������ �ϳ��� ���� �Դ´�.
 * ������ �������� ������ i��° ���ִ� ������ ��ȣ�� ����ϴ� ����
 * 
 * @author Rave
 *
 */
public class Main {

	static int s = 1048576;

	/**
	 * ���׸�Ʈ Ʈ��(�ε��� Ʈ��)�� ����ϴ� ����
	 * Bottom Up������δ� Ǯ �� ����, Top Down ������θ� Ǯ �� �ִ� ī���� ���� �����̴�.
	 * command�� 1�̸� i��°�� ���ִ� ������ ������ ��ȣ�� ����Ѵ�.
	 * command�� 2�̸� i��° ������ count��ŭ �߰��� �ش�.
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