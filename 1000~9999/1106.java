package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * �� ���ÿ� ȣ���� ȫ���Ϸ��� �Ѵ�.
 * �� ������ ȫ�� ���� �� ������� ���� �� �ִ� ���� �־��� ��,
 * ȣ���� ���� ��� C���� �ø��� ���� �ּڰ��� ���ϴ� ����
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
		// dp �ʱ�ȭ
		Arrays.fill(dp, INF);
		City[] city = new City[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			city[i] = new City(cost, customer);
			// ���� �ٸ� ������� ���� ���� ȫ���� �� �����Ƿ� �� �� ���� ���� ���� ���Ѵ�.
			dp[customer] = Math.min(dp[customer], cost);
		}
		for (int i = 0; i < dp.length; i++) {
			// �� ���̶� �湮�� �ε����� Ž���Ѵ�.
			if (dp[i] != INF)
				for (int j = 0; j < n; j++) {
					City cur = city[j];
					try {
						// ���� ������� ���� ȫ���� �� ������ dp�� ������Ʈ�Ѵ�.
						if (dp[i] + cur.cost < dp[i + cur.customer])
							dp[i + cur.customer] = dp[i] + cur.cost;
					} catch (Exception e) {
					}
				}
		}
		// ��� C���� �ø��� ���̹Ƿ� C�� �̻� �߿��� ���� ���� ���� ã�´�.
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