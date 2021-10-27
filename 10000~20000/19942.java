package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 식재료 N개 중 몇 개를 선택하여 최소 영양분을 채우려고 한다.
 * 영양분은 단백질, 탄수화물, 지방, 비타민으로 이루어져있다.
 * 각각의 식재료의 영양성분과 가격이 주어질 때,
 * 최소한의 영양분을 챙길 수 있는 가장 최소의 금액과 그때 구매해야하는 식재료를 오름차순으로 출력하는 문제
 * 만약 답이 없다면 -1과 공백라인을 출력한다.
 * @author Rave
 *
 */
public class Main {

	static int[] limit = new int[4];
	static int[][] food;
	static int answer = Integer.MAX_VALUE;
	static String routeAns = "";

	/**
	 * 브루트포스와 백트래킹을 사용하여 식재료의 조합을 모두 탐색해 본다.
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
		// 현재 식재료를 선택하지 않는다.
		bruteforce(cur + 1, nutrient, sum, route);
		for (int i = 0; i < nutrient.length; i++)
			nutrient[i] += food[cur][i];
		// 현재 식재료를 선택한다.
		bruteforce(cur + 1, nutrient, sum + food[cur][4], route + (cur + 1) + " ");
		for (int i = 0; i < nutrient.length; i++)
			nutrient[i] -= food[cur][i];
	}

	public static boolean isValid(int[] nutrient) {
		return nutrient[0] >= limit[0] && nutrient[1] >= limit[1] && nutrient[2] >= limit[2] && nutrient[3] >= limit[3];
	}
}