package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N*4���� �����Ͱ� �־�����.
 * �ϳ��� ���� �ϳ��� �迭�̴�.
 * �� �迭���� �ϳ��� ���� ��� ���� ���� 0�� �Ǵ� ���� ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] left, right;

	/**
	 * �̺�Ž���� �� �����ͷ� Ǯ �� �ִ�.
	 * �� �����ʹ� 2���� �迭�� �ɰ� �� �迭���� ���� �� �ִ� ��� ����� ���� ���Ѵ�.
	 * ����� ���� �� �迭�� �� �����ͷ� 0�� �Ǵ� ���� ã�� ������.
	 * �̺� Ž���� 2���� �迭�� �����Ͽ� ��� ����� ���� ���ϰ� �����Ѵ�.
	 * ���� 2���� �迭�� ���� Ž���ϸ� ���� ���� -�� ���� ���� ���ĵ� �� �ȿ� �ִ��� Ȯ���Ѵ�.
	 * ���� ���� ���� �� ���� �� �����Ƿ� target�� ���� ������ �ε����� ���ϰ� target +1�� ���� ������ �ε����� ���� ���ִ� ������
	 * ���� ���� ������ ���� �� �ִ�.
	 * 
	 * �̺� Ž������ ������ ��, ArrayList�� ����ϸ� ������ �ð� �ʰ��� ���´�.
	 * N�� �ִ� 4000���̰� �̸� �迭�� ����� 16000���ε� ArrayList���� ���� �ʹ� ���� ������ ���� ���� �迭�� �ø��� ������ �߰��� ��� ������
	 * �ȱ׷��� �ƽ��ƽ��� �ð��� ���ߵ�� �ð� �ʰ��� ����.
	 * �̸� ������ ũ���� int �迭�� �����صθ� �ð� �ʰ��� �ȳ��µ� �ð��� 11�� �ɸ��� �ȴ�.
	 * �׷��� �� �����͸� ����ϸ� 4�ʷ� ���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		left = new int[n * n];
		right = new int[n * n];
		int[][] arr = new int[n][4];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				left[i * n + j] = arr[i][0] + arr[j][1];
				right[i * n + j] = arr[i][2] + arr[j][3];
			}
		Arrays.sort(left);
		Arrays.sort(right);
		long answer = 0;
		int start = 0, end = right.length - 1;
		while (start < left.length && 0 <= end) {
			int sum = left[start] + right[end];
			if (sum > 0)
				end--;
			else if (sum < 0)
				start++;
			else {
				long startCnt = 0, endCnt = 0;
				int leftTarget = left[start], rightTarget = right[end];
				while (start < left.length && left[start] == leftTarget) {
					startCnt++;
					start++;
				}
				while (0 <= end && right[end] == rightTarget) {
					endCnt++;
					end--;
				}
				answer += startCnt * endCnt;
			}
		}
		System.out.println(answer);
	}
}