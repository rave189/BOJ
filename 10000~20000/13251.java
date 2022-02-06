package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���ڿ� N���� ���൹�� ����ִ�.
 * ���൹�� ������ 1���� M���� ���� �ϳ��̴�.
 * ���൹�� �����ϰ� K�� �̾��� ��, ��� ���� ���� Ȯ���� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� ���൹�� ���� �̴� Ȯ���� ��� �����ش�.
	 * ��� ���� ���൹�� ���� Ȯ���� (v-i)/(sum-i)�̴�. (0 <= i < k)
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		double sum = 0;
		int[] arr = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		int k = Integer.parseInt(br.readLine());
		double answer = 0;
		for (int v : arr) {
			if (v < k)
				continue;
			answer += solution(sum, v, k);
		}
		System.out.println(answer);
	}

	public static double solution(double sum, int count, int k) {
		double result = 1;
		for (int i = 0; i < k; i++)
			result *= (count - i) / (sum - i);
		return result;
	}
}