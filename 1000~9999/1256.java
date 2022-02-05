package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 a와 M개의 z로 이루어진 사전이 있다.
 * 사전에는 알파벳 순서로 수록되어 있다.
 * 이 중 K번째 문자열이 무엇인지 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int k;
	static long[][] pascal;

	/**
	 * 카운팅 쿼리와 매우 비슷한 문제
	 * a와 z로만 이루어져 있으므로 n+m개의 문자열 중 a가 들어갈 수 있는 n개의 자리를 고른다.(이항 계수)
	 * k의 최대값은 10억이므로 Integer.MAX_VALUE보다 큰 값은 파스칼의 삼각형에 담을 필요가 없다.
	 * 이제 n+mCn부터 시작하여 각 자리에 a를 넣어야 하는지 z를 넣어야 하는지 확인해본다.
	 * n+mCn에서 n+m-1Cn-1의 값이 k보다 크면 a가 들어갈 수 있는 자리이고, k보다 작으면 a로 나올 수 있는 문자열의 수보다 크므로 z가 들어간다.
	 * n == m == 0인 경우에 탈출하도록 하고, n==0이면 z를, m==0이면 a를 추가해주면서 n과 m을 0으로 만든다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		pascal = new long[n + m + 1][];
		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new long[i + 1];
			for (int j = 0; j < pascal[i].length; j++) {
				try {
					pascal[i][j] = Math.min(Integer.MAX_VALUE, pascal[i - 1][j - 1] + pascal[i - 1][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					pascal[i][j] = 1;
				}
			}
		}
		try {
			System.out.println(findString(n + m, n));
		} catch (Exception e) {
			System.out.println(-1);
		}
	}

	public static String findString(int n, int m) {
		if (n == 0 && m == 0)
			return "";
		else if (n == 0)
			return 'a' + findString(n, m - 1);
		else if (m == 0)
			return 'z' + findString(n - 1, m);
		else if (k <= pascal[n - 1][m - 1]) {
			return 'a' + findString(n - 1, m - 1);
		} else {
			k -= pascal[n - 1][m - 1];
			return 'z' + findString(n - 1, m);
		}
	}
}