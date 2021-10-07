package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준이는 상담원으로 일하고 있고 퇴사를 하려고 한다.
 * 퇴사하기 전까지 최대한 많은 상담을 하여 최대 수익을 얻으려고 한다.
 * 상담은 Ti일이 걸리고, 그에 따른 페이는 Pi이다.
 * 백준이가 받을 수 있는 최대 수익을 구하는 문제
 * 
 * @author Rave
 *
 */
public class Main {

	/**
	 * 현재 상담을 진행할 경우 상담이 종료된 날짜에 현재 금액 + 받는 금액의 값을 저장한다.
	 * 상담을 진행하지 않는 경우 현재 금액과 다음 날의 금액 중 큰 값으로 저장한다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] pay = new int[n];
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			try {
				int nextPay = dp[i] + pay[i];
				int workingTime = i + time[i];
				// 상담을 하지 않는 경우
				dp[i + 1] = Math.max(dp[i + 1], dp[i]);
				// 상담을 하는 경우
				dp[workingTime] = Math.max(dp[workingTime], nextPay);
			} catch (Exception e) {
			}
		}
		System.out.println(dp[n]);
	}
}