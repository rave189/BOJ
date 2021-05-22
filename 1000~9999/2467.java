package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �� ��װ� ���� ����
 * N���� ����� �־�����.
 * ����� ������ Ư������ ������ �� ���� -10�￡�� 10������� ������ ǥ���� �� �ִ�.
 * �� �� �� ����� �����Ͽ� Ư������ ���� 0�� ����� �� ����� ã�� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ���� ����� �������� ������ �� �ٸ� �� ����� �̺� Ž������ ã�´�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		int[] answer = {};
		for (int i = 0; i < n - 1; i++) {
			int left = i + 1, right = n - 1;
			// = ��ȣ�� �����ϸ� i+1�� ���� Ž������ ���Ѵ�.
			while (left <= right) {
				int mid = (left + right) / 2;
				int sum = arr[i] + arr[mid];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer = new int[] { arr[i], arr[mid] };
				}
				if (sum < 0)
					left = mid + 1;
				else if (sum == 0)
					break;
				else
					right = mid - 1;
			}
		}
		System.out.println(String.format("%d %d", answer[0], answer[1]));
	}
}