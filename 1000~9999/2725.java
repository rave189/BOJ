package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * (0, 0)에서 (x, y)를 연결하는 직선이 다른 점과 통과하지 않는 (x, y)를 직선으로 이으려고 한다.
 * N이 주어졌을 때, 0<=N<=x, y인 x, y의 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * (0, 1), (1, 0) 두 점이 기본
	 * (1, 1)을 제외한 (i, i)는 안됨
	 * 나머지 x, y의 gcd가 1이면 중간에 지나치는 점이 없다는 뜻이다.
	 * 추가되는 넓이는 y=x 대칭이므로 한쪽만 구해서 2배 해주면 구할 수 있음.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int[] arr = new int[1001];
		arr[0] = 2;
		arr[1] = 1;
		for (int i = 1; i < arr.length; i++) {
			arr[i] += arr[i - 1];
			int sum = 0;
			for (int j = 1; j < i; j++)
				if (gcd(i, j) == 1)
					sum++;
			arr[i] += sum * 2;
		}
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0)
			answer.append(arr[Integer.parseInt(br.readLine())]).append('\n');
		System.out.println(answer);
	}

	public static int gcd(int a, int b) {
		while (a % b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return b;
	}
}