package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ���� ���� ������ ���� �ִ�.
 * ������ ������ ������ ������ �ִ�.
 * �� ���鸶�� ���� �����̸鼭 ���� ����� �������� �Ÿ��� ���Ϸ��� �Ѵ�.
 * ���� �Ÿ��� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static List<Integer>[] points;

	/**
	 * ���� Ž��, ����
	 * ������ �ִ� N������ ���� �� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		points = new List[n + 1];
		for (int i = 1; i <= n; i++)
			points[i] = new ArrayList<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			points[color].add(location);
		}
		int answer = 0;
		for (int i = 1; i < points.length; i++) {
			points[i].sort((v1, v2) -> v1 - v2);
			answer += solution(points[i]);
		}
		System.out.println(answer);
	}

	public static int solution(List<Integer> arr) {
		if (arr.isEmpty())
			return 0;
		int sum = arr.get(1) - arr.get(0);
		for (int i = 1; i < arr.size() - 1; i++)
			sum += Math.min(arr.get(i) - arr.get(i - 1), arr.get(i + 1) - arr.get(i));
		sum += arr.get(arr.size() - 1) - arr.get(arr.size() - 2);
		return sum;
	}
}