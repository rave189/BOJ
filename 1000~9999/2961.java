package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 도영이는 새로운 요리를 만들려고 한다.
 * 도영이의 앞에 재료 N개가 놓여져 있고, 각 재료의 쓴맛과 신맛을 모두 알고 있다.
 * 이 때, 쓴맛과 신맛의 차이가 가장 적게나는 요리의 차이를 구하는 문제
 * 여러 재료를 사용할 때, 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.
 * @author Rave
 *
 */
public class Main {

	static Food[] foods;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		foods = new Food[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			foods[i] = new Food(sour, bitter);
		}
		for (int i = 0; i < n; i++)
			BruteForce(i + 1, foods[i]);
		System.out.println(answer);
	}

	/**
	 * 브루트 포스를 사용하여 재료를 사용하는 모든 경우의 수를 넣어본다.
	 * @param cur 시작 인덱스
	 * @param food 현재까지 음식의 쓴맛과 신맛
	 */
	public static void BruteForce(int cur, Food food) {
		answer = Math.min(answer, Math.abs(food.sour - food.bitter));
		for (int i = cur; i < foods.length; i++) {
			Food curFood = foods[i];
			BruteForce(i + 1, new Food(food.sour * curFood.sour, food.bitter + curFood.bitter));
		}
	}
}

class Food {
	int sour, bitter;

	public Food(int _sour, int _bitter) {
		this.sour = _sour;
		this.bitter = _bitter;
	}
}