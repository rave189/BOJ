package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ �̷���� �迭 N�� �ִ�.
 * �� �迭�� �κ� �迭 �� ������ ���� ���� ū �ִ� �κй迭�� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] arr;

	/**
	 * �迭�� ���������� �����Ѵ�.
	 * ���� ���Ʈ������ �ϳ��� ���غ��� �ִ밪���� ���Ѵ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++)
				arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
			sb.append(findMax()).append('\n');
		}
		System.out.print(sb);
	}

	public static int findMax() {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++)
			for (int j = i; j < arr.length; j++)
				max = Math.max(max, arr[j] - arr[i - 1]);
		return max;
	}
}