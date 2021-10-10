package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 캡틴 이다솜은 적을 공격하기 위해 대포알을 많이 보관한다.
 * 보관 방법은 다음과 같다.
 * 대포알은 사면체 모양으로 쌓아 놓는다.
 * 사면체는 길이가 N인 정삼각형 모양을 만든다.
 * 그 위에 길이가 N-1인 정삼각형 모양을 얹는 과정을 반복하여 1크기의 정삼각형 모양을 얹으면 된다.
 * 각각의 삼각형은 1, 3, 6, 10 ...과 같이 있고 한 사면체는 1, 4, 10, 20 ...개를 가지고 있을 것이다.
 * 다솜이는 사면체를 가장 적게 만들어 대포알을 보관하고 싶다.
 * 사면체의 최소 개수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 사면체에 포함되는 대포알의 수를 미리 저장해둔다.
	 * 이후 1개부터 N개까지 이전의 값들과 비교하며 사면체가 최소가 되는 경우를 dp에 저장한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cannon = new int[122];
		for (int i = 1, count = 1; i < cannon.length; i++, count++)
			cannon[i] = cannon[i - 1] + count;
		for (int i = 1; i < cannon.length; i++)
			cannon[i] += cannon[i - 1];
		int[] dp = new int[n + 1];
		int idx = 1;
		for (int i = 1; i < dp.length; i++) {
			// 현재 대포알이 저장해둔 사면체의 대포알보다 크다면 idx 증가
			if (i > cannon[idx])
				idx++;
			// 사면체에 들어가는 대포알과 i가 같으면 무조건 1
			if (i == cannon[idx])
				dp[i] = 1;
			else {
				// 사면체의 개수가 최소가 되는 경우를 찾는다.
				int min = Integer.MAX_VALUE;
				for (int j = 1; j < idx; j++)
					min = Math.min(min, dp[i - cannon[j]] + 1);
				dp[i] = min;
			}
		}
		System.out.println(dp[n]);
	}
}