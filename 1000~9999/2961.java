package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �����̴� ���ο� �丮�� ������� �Ѵ�.
 * �������� �տ� ��� N���� ������ �ְ�, �� ����� ������ �Ÿ��� ��� �˰� �ִ�.
 * �� ��, ������ �Ÿ��� ���̰� ���� ���Գ��� �丮�� ���̸� ���ϴ� ����
 * ���� ��Ḧ ����� ��, �Ÿ��� ����� ����� �Ÿ��� ���̰�, ������ ���̴�.
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
	 * ���Ʈ ������ ����Ͽ� ��Ḧ ����ϴ� ��� ����� ���� �־��.
	 * @param cur ���� �ε���
	 * @param food ������� ������ ������ �Ÿ�
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