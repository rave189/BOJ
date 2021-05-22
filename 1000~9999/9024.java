package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N���� ���� K�� �־�����.
 * N���� �� �� 2���� �����Ͽ� ���� ���� K�� ���� ����� ������ ������ ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static int n;
	static int k;
	
	/**
	 * Java8�� �޸� �ʰ�, Java11�� AC�̴�.
	 * N���� ���� �Է����� �޾� �� �����͸� �̿��Ͽ� �� ���� ���Ѵ�.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			sb.append(twoPointer() + "\n");
		}
		System.out.print(sb);
	}

	/**
	 * �� �����͸� �̿��Ͽ� K�� ���� ����� ���� ������ ���Ѵ�.
	 * @return K�� ���� ����� ���� ����
	 */
	public static int twoPointer() {
		int min = Integer.MAX_VALUE;
		int count = 0, start = 0, end = n - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (Math.abs(sum - k) < min) {
				min = Math.abs(sum - k);
				count = 1;
			} else if (Math.abs(sum - k) == min)
				count++;
			if (sum < k)
				start++;
			else
				end--;
		}
		return count;
	}
}