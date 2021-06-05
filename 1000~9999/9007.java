package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ī�� ���� è�Ǿ�ʿ� ���� �л��� �������� �Ѵ�.
 * �� ī�� ���ֿ��� �ִ��� ������ ������ �л����� �������� ���� Ư���� ���� �ٻ��ؾ� �Ѵ�.
 * �� 4���� �ݿ� N���� �л����� ���� ��, �������� ���� Ư���� ���� �ٻ��ϴ� 4���� �л��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * 4���� ���� ���Ʈ������ Ž���ϱ⿡�� �ʹ� �����ɸ��Ƿ�
	 * 4���� ���� 2��, 2���� ���� �� 2���� �ݿ��� ���ü� �ִ� ��� �������� ���� �ϳ��� �迭�� �ִ´�.
	 * ���� �� ���� ���� ������ ��, �������� ���� �ݿ��� ���� Ž���� ���ĵ� �ݿ����� �̺� Ž������ 4���� �л��� ã�´�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] classes = new int[4][n];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					classes[i][j] = Integer.parseInt(st.nextToken());
			}
			// ���� 2���� ������.
			int[] class1 = new int[n * n];
			int[] class2 = new int[n * n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					// ���� �� �ִ� ��� �������� ���� �ִ´�.
					class1[i * n + j] = classes[0][i] + classes[1][j];
					class2[i * n + j] = classes[2][i] + classes[3][j];
				}
			// �� �� �ݸ� �����Ѵ�.
			Arrays.sort(class2);
			int answer = Integer.MAX_VALUE;
			// ���ĵ��� ���� �ݿ��� ����Ž����, ���ĵ� �ݿ��� �̺� Ž���� �����Ѵ�.
			loop: for (int i = 0; i < class1.length; i++) {
				int left = 0, right = class2.length - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					int sum = class1[i] + class2[mid];
					int check = Math.abs(sum - k) - Math.abs(answer - k);
					if (check < 0)
						answer = sum;
					else if (check == 0)
						answer = Math.min(answer, sum);
					if (sum - k < 0)
						left = mid + 1;
					else if (sum == k)
						break loop;
					else
						right = mid - 1;
				}
			}
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	}
}