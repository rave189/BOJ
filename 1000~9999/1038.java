package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 음이 아닌 정수가 가장 큰 자리수부터 작은 자리수까지 감소한다면, 그 수를 감소하는 수라고 한다.
 * N이 주어질 때, N번째 감소하는 수를 구한다.
 * N번째 감소하는 수가 없다면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long answer = 1;
		for (int i = 0; i != n;) {
			// 9876543210을 넘어가면 감소하는 수를 만들 수가 없다.
			if (answer > 98765432210L) {
				System.out.println(-1);
				return;
			}
			int check = isDecrease(Long.toString(answer));
			// -1은 answer이 감소하는 수라는 표시이므로 i와 answer을 증가시킨다.
			if (check == -1) {
				i++;
				answer++;
			} 
			// -1이 아니라면 감소하는 수가 아니므로 10^(check-1)만큼 건너뛴다.
			else
				answer += Math.pow(10, check);
		}
		System.out.println(answer - 1);
	}

	/**
	 * str이 감소하는 수인지 검사한다.
	 * 감소하는 수라면 -1을 반환한다.
	 * 감소하는 수가 아니라면 감소하는 수가 아니게된 자리수를 반환한다.
	 * @param str 감소하는지 검사할 수
	 * @return -1이면 감소하는 수이고, 다른 수이면 감소하는 수가 아니게 된 자리수를 반환한다.
	 */
	public static int isDecrease(String str) {
		for (int i = 1; i < str.length(); i++)
			if (str.charAt(i - 1) <= str.charAt(i))
				return str.length() - i - 1;
		return -1;
	}
}