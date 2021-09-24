package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * n���� ���� �ٸ� ���� ������ �־�����.
 * �׸��� �ڿ��� x�� �־����� ��, a[i] + a[j] = x�� �Ǵ� i, j ���� ���ϴ� ����
 * i�� j�� ���� �ʴ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���Ʈ������ ���ϸ� �ð��ʰ��� ���´�.
	 * ���� �� �����͸� ����Ͽ� �� ���������� ���غ���.
	 * x�� ã�� ��� �����̳� ������ �ƹ����� �ø��ų� ������.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int answer = 0;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum < x)
				start++;
			else if (sum == x) {
				answer++;
				start++;
			} else
				end--;
		}
		System.out.println(answer);
	}
}