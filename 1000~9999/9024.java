package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 수와 K가 주어진다.
 * N개의 수 중 2개를 선택하여 더한 값이 K에 가장 가까운 정수의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int[] arr;
	static int n;
	static int k;
	
	/**
	 * Java8은 메모리 초과, Java11은 AC이다.
	 * N개의 수를 입력으로 받아 투 포인터를 이용하여 두 수를 구한다.
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
	 * 투 포인터를 이용하여 K에 가장 가까운 수의 개수를 구한다.
	 * @return K에 가장 가까운 수의 개수
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