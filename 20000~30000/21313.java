package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 8개의 팔을 가진 N마리의 문어가 있다.
 * 이 문어들이 서로 손을 잡고 강강술래를 하려고 한다.
 * 이 때 지켜야 될 예절이 있는데 다음과 같다.
 * 1. 서로 같은 번호의 손을 잡아야 한다.
 * 2. 한 문어와 둘 이상의 손을 잡을 수 없다.
 * 3. 한 손으로 여러 문어의 손을 잡을 수 없다.
 * 각각의 손에 번호를 부여할 때, 문어들이 손을 잡은 번호를 이어 수열을 만들 수 있다.
 * 이 때, 사전 순으로 제일 앞서는 수열을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while (n >= 2) {
			n -= 2;
			answer.append("1 2 ");
		}
		if (n > 0)
			answer.append("3");
		System.out.println(answer);
	}
}