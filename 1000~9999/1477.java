package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N���� �ްԼҰ� �ִ� ��ӵ��ο� M���� �ްԼҸ� �� ������� �Ѵ�.
 * M���� �ްԼҸ� �� ���� �ްԼҰ� ���� ������ ������ �ִ��� �ּҰ��� ���ϴ� ����
 * �ݵ�� M���� ��� ����� �Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ް��Ұ� ���� ������ ������ �ִ��� �̺�Ž���� ���� ã�´�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// �迭�� 0�� l�� �߰��Ͽ� �����.
		int[] RestArea = new int[n + 2];
		for (int i = 1; i <= n; i++)
			RestArea[i] = Integer.parseInt(st.nextToken());
		RestArea[n + 1] = l;
		// ������ �Ͽ� �ް��Ұ� ���� ������ ���̸� �� �� �ְ� �Ѵ�.
		Arrays.sort(RestArea);
		int left = 1, right = l, answer = Integer.MAX_VALUE;
		// �̺� Ž���� ���� ������ ã�´�.
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			// mid�� 70�̰� �� �ް����� �Ÿ� ���̰� 210�� ��, 70�� 140�� ��ġ�ϸ� �ȴ�.
			// ���� ���̸� mid�� ������ ���� �ø��� �� 1�� ���� ������� ���� �� �ִ�.
			for (int i = 1; i < RestArea.length; i++)
				cnt += Math.ceil((RestArea[i] - RestArea[i - 1]) / (double) mid) - 1;
			if (cnt > m)
				left = mid + 1;
			else {
				answer = Math.min(answer, mid);
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}
}