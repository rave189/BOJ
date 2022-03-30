package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 가장 긑의 0의 개수가 M인 N! 중 가장 작은 N을 찾는 문제
 * 존재하지 않는다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 5씩 더해주며 5의 개수만큼 m을 빼준다.
	 * m == 0이면 정답이 존재하고, 음수인 경우 존재하지 않으므로 -1을 출력한다.
	 * 
	 * 5/5 = 1, 10/5 = 2 처럼 N!에 들어있는 5의 개수를 나누기로 바로 알 수 있음
	 * 이를 이용하여 m을 찾는 이분 탐색을 할 수 있음.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		long answer = 0;
		while (m > 0) {
			answer += 5;
			int fiveCnt = getFiveCnt(answer);
			m -= fiveCnt;
		}
		System.out.println(m == 0 ? answer : -1);
	}

	public static int getFiveCnt(long n) {
		int count = 0;
		while (n % 5 == 0) {
			count++;
			n /= 5;
		}
		return count;
	}
}