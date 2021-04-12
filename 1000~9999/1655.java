package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * ������ �־��� ������ �׵��� ���� ������ �� �߾Ӱ��� ����ϴ� ����
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
		// �߾� ���� �׻� small�� �ΰ��Ѵ�.
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			if (small.size() == big.size()) {
				// small�� ����ְų�(small�� ����ִٸ� big�� ����ִ�) big�� ���� ���� ������ ������ small�� �ִ´�.
				if (small.isEmpty() || num <= big.peek())
					small.add(num);
				// big�� ���� ���� ������ ũ�ٸ� big�� num�� �ְ� ���� ���� ���� small�� �ű��.
				else {
					big.add(num);
					small.add(big.poll());
				}
			} else if (small.size() > big.size()) {
				// num�� small�� ���� �Ѵٸ� small�� num�� �ְ� small�� ���� ū ���� big���� �ű��.
				if (num <= small.peek()) {
					small.add(num);
					big.add(small.poll());
				}
				// small�� ���� ū ������ ũ�ٸ� big�� �ִ´�.
				else
					big.add(num);
			}
			sb.append(small.peek() + "\n");
		}
		System.out.println(sb);
	}
}