package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2�� Ȥ�� 3���� �ڿ����� �־�����.
 * �� ������ ������� ��� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ܼ� �񱳷� ����.
	 * �� ���� �ִ������� ã��, �ִ� ������� ����� ���ϴ� ����� ���� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			min = Math.min(arr[i], min);
		}
		for (int i = 1; i <= min; i++) {
			boolean isValid = true;
			for (int j = 0; j < n; j++)
				if (arr[j] % i != 0)
					isValid = false;
			if (isValid)
				answer.append(i).append('\n');
		}
		System.out.println(answer);
	}
}