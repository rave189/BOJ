package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ������ N�� �߿��� 4���� �����̸� ��� ����� 2���� ������� �Ѵ�.
 * ������� ū ������ �� ���� �Ʒ��� �ΰ� ũ�� ���� �����̸� ���� �ø��� ������� �����.
 * ������� Ű�� �� �������� ������ �հ� ����.
 * �� ������� Ű�� ������ �ּڰ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� for���� ���� ����� �� ���� �ϼ��Ѵ�.
	 * ���� i�� j������ ����� �̺� Ž���� �Ͽ� �� ��° ������� �����.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int answer = Integer.MAX_VALUE;
		// ����� �ϳ��� ���Ʈ������ ã�´�.
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 3; j < n; j++) {
				// i�� j������ ����� �̺� Ž���� �����Ѵ�.
				int left = i + 1, right = j - 1;
				int snowMan = arr[i] + arr[j];
				while (left < right) {
					int compare = arr[right] + arr[left];
					// ������� Ű�� ���̰� �ּҰ��� �����Ѵ�.
					answer = Math.min(answer, Math.abs(snowMan - compare));
					// snowMan�� ũ�ٸ� left�� �������� compare�� ũ�⸦ �ø���.
					if (snowMan - compare > 0)
						left++;
					// Ű�� ���̰� 0���� ���� �� �����Ƿ� 0�̸� ����ϰ� �����Ѵ�.
					else if (snowMan - compare == 0) {
						System.out.println(0);
						return;
					}
					// compare�� ũ�ٸ� right�� ���ҽ��� compare�� ũ�⸦ ���δ�.
					else
						right--;
				}
			}
		}
		System.out.println(answer);
	}
}