package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Ư������ ��� �ٸ� ��� N���� �ִ�.
 * �� �߿��� 3���� ����� �����Ͽ� Ư������ ���� 0�� ���� ����� ����� ����� ����
 * ���� ���� ���� ��� �ƹ��ų� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ���� ����� �������� �����Ѵ�.
	 * ���� �� ���� ����� �̺� Ž������ Ž���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// ����� �����Ѵ�.
		Arrays.sort(arr);
		int[] answer = new int[3];
		long min = Long.MAX_VALUE;
		// �������� i��° ����� ����
		for (int i = 0; i < n - 2; i++) {
			// i+1��° ��׿� n-1��° ����� �������� �̺� Ž���� �Ѵ�.
			int left = i + 1, right = n - 1;
			while (left < right) {
				// ����� ���� -10����� 10������̹Ƿ� �� ����� ���ϸ� int�� ������ �ʰ��Ѵ�.
				long sum = (long) arr[i] + arr[left] + arr[right];
				// 0�� �� ������ min�� answer�� ������Ʈ�Ѵ�.
				if (Math.abs(sum) < min) {
					answer = new int[] { arr[i], arr[left], arr[right] };
					min = Math.abs(sum);
				}
				if (sum > 0)
					right--;
				else if (sum == 0)
					break;
				else
					left++;
			}
		}
		System.out.println(String.format("%d %d %d", answer[0], answer[1], answer[2]));
	}
}