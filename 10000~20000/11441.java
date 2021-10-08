package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� N�� �־�����.
 * �� ������ i��°���� j�������� ���� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �迭�� ���� ���� �����صΰ� j��° �� - i-1��° ���� �� i���� j������ ���� ���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			sb.append(arr[second] - arr[first - 1]).append("\n");
		}
		System.out.println(sb);
	}
}