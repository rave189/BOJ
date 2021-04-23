package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 점수 8개가 주어질 때, 가장 높은 점수 5개의 합과 고른 점수의 인덱스를 출력하는 문제
 * 인덱스는 오름차순으로 출력한다.
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