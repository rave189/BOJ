package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ���� 8���� �־��� ��, ���� ���� ���� 5���� �հ� �� ������ �ε����� ����ϴ� ����
 * �ε����� ������������ ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Score> pq = new PriorityQueue<>();
		for (int i = 0; i < 8; i++)
			pq.add(new Score(Integer.parseInt(br.readLine()), i + 1));
		int sum = 0;
		int[] select = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += pq.peek().score;
			select[i] = pq.poll().index;
		}
		Arrays.sort(select);
		System.out.println(sum);
		for (int i = 0; i < 5; i++)
			System.out.print(select[i] + " ");
	}
}

class Score implements Comparable<Score> {
	int score, index;

	public Score(int _score, int _index) {
		this.score = _score;
		this.index = _index;
	}

	@Override
	public int compareTo(Score o) {
		return o.score - score;
	}
}