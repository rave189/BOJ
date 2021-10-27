package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ����� N�� �� �� ���� �����Ͽ� �ּ� ������� ä����� �Ѵ�.
 * ������� �ܹ���, ź��ȭ��, ����, ��Ÿ������ �̷�����ִ�.
 * ������ ������� ���缺�а� ������ �־��� ��,
 * �ּ����� ������� ì�� �� �ִ� ���� �ּ��� �ݾװ� �׶� �����ؾ��ϴ� ����Ḧ ������������ ����ϴ� ����
 * ���� ���� ���ٸ� -1�� ��������� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static int[] limit = new int[4];
	static int[][] food;
	static int answer = Integer.MAX_VALUE;
	static String routeAns = "";

	/**
	 * ���Ʈ������ ��Ʈ��ŷ�� ����Ͽ� ������� ������ ��� Ž���� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		food = new int[n][5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < limit.length; i++)
			limit[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < food[i].length; j++)
				food[i][j] = Integer.parseInt(st.nextToken());
		}
		bruteforce(0, new int[4], 0, "");
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			System.out.println();
		} else {
			System.out.println(answer);
			System.out.println(routeAns);
		}
	}

	public static void bruteforce(int cur, int[] nutrient, int sum, String route) {
		if (isValid(nutrient)) {
			if (sum < answer) {
				answer = sum;
				routeAns = route;
			} else if (sum == answer) {
				if (routeAns.equals("") || route.compareTo(routeAns) < 0)
					routeAns = route;
			}
			return;
		}
		if (cur >= food.length)
			return;
		// ���� ����Ḧ �������� �ʴ´�.
		bruteforce(cur + 1, nutrient, sum, route);
		for (int i = 0; i < nutrient.length; i++)
			nutrient[i] += food[cur][i];
		// ���� ����Ḧ �����Ѵ�.
		bruteforce(cur + 1, nutrient, sum + food[cur][4], route + (cur + 1) + " ");
		for (int i = 0; i < nutrient.length; i++)
			nutrient[i] -= food[cur][i];
	}

	public static boolean isValid(int[] nutrient) {
		return nutrient[0] >= limit[0] && nutrient[1] >= limit[1] && nutrient[2] >= limit[2] && nutrient[3] >= limit[3];
	}
}