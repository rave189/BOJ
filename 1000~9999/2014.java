package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * K개의 소수가 오름차순으로 주어진다.
 * 소수들 중에서 몇 개를 곱하여 얻을 수 있는 수가 있다.
 * 이 수는 주어지는 소수를 포함하여 구한다.
 * 이 수들을 오름차순으로 나열했을 때, N번째 오는 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 소수 K를 우선순위 큐에 넣는다.
	 * 이후 하나씩 빼내며 다시 K개의 소수와 곱하고, 우선순위 큐에 넣는다.
	 * 이 작업을 N번하면 N번째 수를 구할 수 있다.
	 * 단, 곱한 결과가 중복이 나올 수 있으므로 % 연산으로 나누어질 수 있는 수까지만 추가해준다.
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