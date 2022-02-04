package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * K���� �Ҽ��� ������������ �־�����.
 * �Ҽ��� �߿��� �� ���� ���Ͽ� ���� �� �ִ� ���� �ִ�.
 * �� ���� �־����� �Ҽ��� �����Ͽ� ���Ѵ�.
 * �� ������ ������������ �������� ��, N��° ���� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �Ҽ� K�� �켱���� ť�� �ִ´�.
	 * ���� �ϳ��� ������ �ٽ� K���� �Ҽ��� ���ϰ�, �켱���� ť�� �ִ´�.
	 * �� �۾��� N���ϸ� N��° ���� ���� �� �ִ�.
	 * ��, ���� ����� �ߺ��� ���� �� �����Ƿ� % �������� �������� �� �ִ� �������� �߰����ش�.
	 * 	 2 3 4 5
	 * 2 *
	 * 3 * *
	 * 4 * * *
	 * 5 * * * *
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long[] arr = new long[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(arr[i]);
		}
		while (--n > 0) {
			long cur = pq.poll();
			for (long v : arr) {
				pq.add(cur * v);
				if (cur % v == 0)
					break;
			}
		}
		System.out.println(pq.poll());
	}
}