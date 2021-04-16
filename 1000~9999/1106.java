package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 각 도시에 호텔을 홍보하려고 한다.
 * 각 도시의 홍보 비용과 그 비용으로 얻을 수 있는 고객이 주어질 때,
 * 호텔의 고객을 적어도 C명을 늘리기 위한 최솟값을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[1101];
		// dp 초기화
		Arrays.fill(dp, INF);
		City[] city = new City[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			city[i] = new City(cost, customer);
			// 서로 다른 비용으로 같은 고객을 홍보할 수 있으므로 그 중 가장 작은 것을 택한다.
			dp[customer] = Math.min(dp[customer], cost);
		}
		for (int i = 0; i < dp.length; i++) {
			// 한 번이라도 방문한 인덱스만 탐색한다.
			if (dp[i] != INF)
				for (int j = 0; j < n; j++) {
					City cur = city[j];
					try {
						// 적은 비용으로 고객을 홍보할 수 있으면 dp를 업데이트한다.
						if (dp[i] + cur.cost < dp[i + cur.customer])
							dp[i + cur.customer] = dp[i] + cur.cost;
					} catch (Exception e) {
					}
				}
		}
		// 적어도 C명을 늘리는 것이므로 C명 이상 중에서 가장 적은 값을 찾는다.
		int answer = Integer.MAX_VALUE;
		for (int i = c; i < dp.length; i++)
			answer = Math.min(answer, dp[i]);
		System.out.println(answer);
	}
}

class City {
	int cost, customer;

	public City(int _cost, int _customer) {
		this.cost = _cost;
		this.customer = _customer;
	}
}