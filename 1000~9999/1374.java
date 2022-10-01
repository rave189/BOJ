package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * N���� ���ǰ� �ִ�.
 * �� ���Ǻ� ���� �ð��� ������ �ð��� �־�����.
 * ���ǽ��� �ּ� � �ʿ����� ���ϴ� ����
 * ������ �ð��� ���� �ð��� ��ġ�� ���Ǵ� ��� ����.
 * @author Rave
 *
 */
public class Main {

	static Lecture[] lectures;

	/**
	 * �ٸ� ���ǽ� ������ �Ȱ��� ��..?
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lectures = new Lecture[n];
		for (int i = 0; i < n; i++) {
			int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v)).toArray();
			lectures[i] = new Lecture(values[0], values[1], values[2]);
		}
		Arrays.sort(lectures);
		PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.endTime - o2.endTime;
			}
		});
		int max = 0;
		for (int i = 0; i < n; i++) {
			while (!pq.isEmpty() && pq.peek().endTime <= lectures[i].startTime)
				pq.poll();
			pq.add(lectures[i]);
			max = max(max, pq.size());
		}
		System.out.println(max);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}

class Lecture implements Comparable<Lecture> {
	int no, startTime, endTime;

	public Lecture(int no, int startTime, int endTime) {
		this.no = no;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Lecture o) {
		return startTime - o.startTime;
	}
}