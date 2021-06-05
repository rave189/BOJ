package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ���Ұ� ����ִ� ������ �־����� ��,
 * ���ӵ� K���� ���� ���� ū ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ó�� k���� ���� ���� �� �� �����ͷ� �̵��ϸ� ������ ����, �������� ���Ѵ�.
	 * ���� �ִ밪���� Ȯ���Ͽ� ���� ���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int left = 0, right = k, sum = 0, answer = Integer.MIN_VALUE;
		for (int i = left; i < right; i++)
			sum += arr[i];
		while (right < n) {
			answer = Math.max(answer, sum);
			sum -= arr[left++];
			sum += arr[right++];
		}
		System.out.println(Math.max(answer, sum));
	}
}