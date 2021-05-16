package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * n���� ��� �߿��� 3���� �����Ͽ� ���� 0�� �ǵ��� �Ϸ��� �Ѵ�.
 * ���� 0�� �Ǵ� ����� ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �������� �� ����� �����Ѵ�.
	 * ���� �� �����͸� �̿��Ͽ� �� ����� �����Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().replaceAll(" ", ""));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long answer = 0;
		for (int i = 0; i < n; i++) {
			// �Ѹ��� �������� ����
			int first = arr[i];
			// ���� �Ǿ� �ֱ� ������ ����� ��� �� ������ ����� ������
			if (first > 0)
				break;
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				// ���� ���Ѵ�.
				int sum = first + arr[left] + arr[right];
				if (sum > 0)
					right--;
				else if (sum < 0)
					left++;
				// ���� 0�� ���
				else {
					// left�� right�� ���� ��� ���ĵǾ� �ֱ� ������ left�� right ���̿��� ���� ���鸸 �����Ѵ�.
					// �׷��Ƿ� right-left���� �� �߿��� 2���� �����ϴ� nC2�� �ȴ�.
					if (arr[left] == arr[right]) {
						answer += (right - left + 1) * (long) (right - left) / 2;
						break;
					} else {
						// arr[left]�� ������ ����.
						int leftCnt = 1;
						int prev = arr[left];
						while (prev == arr[++left])
							leftCnt++;
						// arr[right]�� ������ ����.
						int rightCnt = 1;
						prev = arr[right];
						while (prev == arr[--right])
							rightCnt++;
						// arr[left]�� ������ arr[right]�� ������ ���Ͽ� ����� ���� ã�´�.
						answer += leftCnt * (long) rightCnt;
					}
				}
			}
		}
		System.out.println(answer);
	}
}