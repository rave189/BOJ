package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 정수가 주어질 때마다 그동안 나온 정수들 중 중앙값을 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> big = new PriorityQueue<Integer>();
		PriorityQueue<Integer> small = new PriorityQueue<>((v1, v2) -> v2 - v1);
		// 중앙 값을 항상 small에 두게한다.
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			if (small.size() == big.size()) {
				// small이 비어있거나(small이 비어있다면 big도 비어있다) big의 가장 작은 수보다 작으면 small에 넣는다.
				if (small.isEmpty() || num <= big.peek())
					small.add(num);
				// big의 가장 작은 수보다 크다면 big에 num을 넣고 가장 작은 수를 small로 옮긴다.
				else {
					big.add(num);
					small.add(big.poll());
				}
			} else if (small.size() > big.size()) {
				// num이 small에 들어가야 한다면 small에 num을 넣고 small의 가장 큰 수를 big으로 옮긴다.
				if (num <= small.peek()) {
					small.add(num);
					big.add(small.poll());
				}
				// small의 가장 큰 수보다 크다면 big에 넣는다.
				else
					big.add(num);
			}
			sb.append(small.peek() + "\n");
		}
		System.out.println(sb);
	}
}