package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 크기가 NxN인 배열 A가 있다.
 * 이 배열의 값 A[i][j] = i*j이다.
 * 이 때 k번째 수의 값을 찾는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * k번째 수는 min(mid/i, n)을 이용하여 구할 수 있다.
	 * 여기서 mid는 임의의 수이고, i는 행을 의미한다.
	 * i번째 줄에서 임의의 수 mid보다 작은 수의 개수를 찾는 것이다.
	 * 만약 수의 개수가 n보다 크다면 n을 반환해야 한다.
	 * 1 2 3
	 * 2 4 6
	 * 3 6 9
	 * n = 3인 배열에서 mid가 4라면
	 * 1번째 행에서는 mid(4/1, 3)인 3개가 나오고
	 * 2번재 행에서는 mid(4/2, 3)인 2개가 나오고
	 * 3번째 행에서는 mid(4/3, 3)인 1개가 나온다.
	 * 따라서 4는 6번째 수라는 것을 알 수 있다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 0, right = k;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 1; i <= n; i++)
				cnt += Math.min(mid / i, n);
			if (cnt >= k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}