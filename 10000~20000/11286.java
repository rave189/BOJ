package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 절댓값 힙을 구현하는 문제
 * 절댓값 힙은 배열에 정수 x를 넣는 연산과
 * 배열에서 절댓값이 가장 작은 값을 출력하고,
 * 작은 값이 여러 개일 경우 가장 작은 수를 출력하고 배열에서 그 수를 제거하는 연산으로 이루어져 있다.
 * 배열에서 제거되는 수들을 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 우선순위 큐의 Comparator를 구현하여 문제를 해결할 수 있다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) < Math.abs(o2))
					return -1;
				else if (Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				return 1;
			}
		});
		int count = Integer.parseInt(br.readLine());
		while (count-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				answer.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
			else
				pq.add(n);
		}
		System.out.print(answer);
	}
}